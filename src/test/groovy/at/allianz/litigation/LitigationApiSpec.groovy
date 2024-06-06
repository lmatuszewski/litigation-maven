package at.allianz.litigation

import at.allianz.litigation.domain.Litigation
import at.allianz.litigation.repository.LitigationRepository
import org.skyscreamer.jsonassert.Customization
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import org.skyscreamer.jsonassert.comparator.CustomComparator
import org.spockframework.spring.EnableSharedInjection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestClient
import spock.lang.Shared
import spock.lang.Specification


import static at.allianz.litigation.domain.LitigationReason.*
import static at.allianz.litigation.domain.LitigationType.*

@SpringBootTest
@EnableSharedInjection
class LitigationApiSpec extends Specification {

    @Autowired @Shared
    private LitigationRepository litigationRepository

    @Shared
    RestClient restClient = RestClient.builder().baseUrl("http://localhost:8080/api/v1/litigations").build()

    def "get litigation list"() {
        given:
            String expectedJson = new ClassPathResource("litigations/all.json").getFile().text

        when:
            String responseBody = restClient.get().uri("/").retrieve().body(String.class)

        then:
            JSONAssert.assertEquals(responseBody, expectedJson,
                new CustomComparator(JSONCompareMode.STRICT,
                        new Customization("[*].id", (o1, o2) -> true),
                        new Customization("[*].createdAt", (o1, o2) -> true),
                        new Customization("[*].updatedAt", (o1, o2) -> true)
                )
        )
    }

    def "create/show/edit/remove litigation"() {
        given:
            Litigation litigation = new Litigation("claim-123", ADMINISTRATIVE_PROCEEDING, REASON1)

        when:
            ResponseEntity<Litigation> response = restClient.post().uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(litigation)
                .retrieve()
                .toEntity(Litigation.class)

        then:
            response.statusCode.value() == 200
            Litigation newLitigation = response.body
            newLitigation.claimNumber == "claim-123"
            newLitigation.type == ADMINISTRATIVE_PROCEEDING
            newLitigation.reason == REASON1

        when:
            ResponseEntity<Litigation> getResp = restClient.get().uri("/{id}", newLitigation.id)
                .retrieve()
                .toEntity(Litigation.class)

        then:
            getResp.body.claimNumber == "claim-123"
            getResp.body.type == ADMINISTRATIVE_PROCEEDING
            getResp.body.reason == REASON1

        when:
            newLitigation.type = ALTERNATIVE_DISPUTE_RESOLUTION
            newLitigation.reason = REASON2
            ResponseEntity<Litigation> updateResp = restClient.put().uri("/{id}", newLitigation.id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(newLitigation)
                .retrieve()
                .toEntity(Litigation.class)

        then:
            updateResp.statusCode.value() == 200
            Litigation updatedLitigation = updateResp.body
            updatedLitigation.type == ALTERNATIVE_DISPUTE_RESOLUTION
            updatedLitigation.reason == REASON2

        when:
            ResponseEntity<Void> deleteResp = restClient.delete().uri("/{id}", newLitigation.id)
                .retrieve()
                .toBodilessEntity()

        then:
            deleteResp.statusCode.value() == 200
    }
}
