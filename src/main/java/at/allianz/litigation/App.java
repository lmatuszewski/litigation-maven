package at.allianz.litigation;


import at.allianz.litigation.domain.Jurisdiction;
import at.allianz.litigation.domain.Litigation;
import at.allianz.litigation.repository.JurisdictionRepository;
import at.allianz.litigation.repository.LitigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static at.allianz.litigation.domain.JurisdictionLevel.*;
import static at.allianz.litigation.domain.LitigationReason.*;
import static at.allianz.litigation.domain.LitigationType.*;

@SpringBootApplication
@EnableJpaAuditing
public class App implements CommandLineRunner {

    @Autowired
    private LitigationRepository litigationRepository;

    @Autowired
    private JurisdictionRepository jurisdictionRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        String claimNumber = "claim-1";
        Litigation l1 = litigationRepository.save(new Litigation(claimNumber, ADMINISTRATIVE_PROCEEDING, REASON1));
        Litigation l2 = litigationRepository.save(new Litigation(claimNumber, ALTERNATIVE_DISPUTE_RESOLUTION, REASON2));
        Litigation l3 = litigationRepository.save(new Litigation(claimNumber, ARBITRATION_PROCEEDING, REASON1));

        String claimNumber2 = "claim-2";
        Litigation l4 = litigationRepository.save(new Litigation(claimNumber2, ADMINISTRATIVE_PROCEEDING, REASON2));
        Litigation l5 = litigationRepository.save(new Litigation(claimNumber2, ARBITRATION_PROCEEDING, REASON1));

        jurisdictionRepository.save(new Jurisdiction(l1.getId(), FIRST, "Court-1"));
        jurisdictionRepository.save(new Jurisdiction(l1.getId(), SECOND, "Court-2"));
        jurisdictionRepository.save(new Jurisdiction(l1.getId(), THIRD, "Court-3"));
        jurisdictionRepository.save(new Jurisdiction(l1.getId(), FOURTH, "Court-4"));

        jurisdictionRepository.save(new Jurisdiction(l2.getId(), FIFTH, "Court-5"));
        jurisdictionRepository.save(new Jurisdiction(l2.getId(), SIXTH, "Court-6"));

        jurisdictionRepository.save(new Jurisdiction(l4.getId(), FIRST, "Court-7"));
    }
}
