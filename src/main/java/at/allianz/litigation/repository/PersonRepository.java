package at.allianz.litigation.repository;

import at.allianz.litigation.domain.Person;
import at.allianz.litigation.domain.PersonType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findAllByClaimNumber(String claimNumber);

    List<Person> findAllByClaimNumberAndType(String claimNumber, PersonType type);
}
