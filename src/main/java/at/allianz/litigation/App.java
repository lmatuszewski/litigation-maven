package at.allianz.litigation;


import at.allianz.litigation.domain.Litigation;
import at.allianz.litigation.repository.LitigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

import static at.allianz.litigation.domain.LitigationReason.*;
import static at.allianz.litigation.domain.LitigationType.*;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private LitigationRepository litigationRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        String claimNumber = UUID.randomUUID().toString();
        litigationRepository.save(new Litigation(claimNumber, ADMINISTRATIVE_PROCEEDING, REASON1));
        litigationRepository.save(new Litigation(claimNumber, ALTERNATIVE_DISPUTE_RESOLUTION, REASON2));
        litigationRepository.save(new Litigation(claimNumber, ARBITRATION_PROCEEDING, REASON1));

        String claimNumber2 = UUID.randomUUID().toString();
        litigationRepository.save(new Litigation(claimNumber2, ADMINISTRATIVE_PROCEEDING, REASON2));
        litigationRepository.save(new Litigation(claimNumber, ARBITRATION_PROCEEDING, REASON1));
    }
}
