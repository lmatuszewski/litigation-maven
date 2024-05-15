package at.allianz.litigation;


import at.allianz.litigation.domain.Litigation;
import at.allianz.litigation.repository.LitigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

import static at.allianz.litigation.domain.LitigationReason.*;
import static at.allianz.litigation.domain.LitigationType.*;

@SpringBootApplication
@EnableJpaAuditing
public class App implements CommandLineRunner {

    @Autowired
    private LitigationRepository litigationRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        String claimNumber = "claim-1";
        litigationRepository.save(new Litigation(claimNumber, ADMINISTRATIVE_PROCEEDING, REASON1));
        litigationRepository.save(new Litigation(claimNumber, ALTERNATIVE_DISPUTE_RESOLUTION, REASON2));
        litigationRepository.save(new Litigation(claimNumber, ARBITRATION_PROCEEDING, REASON1));

        String claimNumber2 = "claim-2";
        litigationRepository.save(new Litigation(claimNumber2, ADMINISTRATIVE_PROCEEDING, REASON2));
        litigationRepository.save(new Litigation(claimNumber2, ARBITRATION_PROCEEDING, REASON1));
    }
}
