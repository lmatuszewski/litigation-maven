package at.allianz.litigation.repository;

import at.allianz.litigation.domain.Litigation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LitigationRepository extends MongoRepository<Litigation, String> {

    List<Litigation> findAllByClaimNumber(String claimNumber);
}
