package at.allianz.litigation.repository;

import at.allianz.litigation.domain.Jurisdiction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JurisdictionRepository extends MongoRepository<Jurisdiction, String> {

    List<Jurisdiction> findAllByLitigationId(String litigationId);
}
