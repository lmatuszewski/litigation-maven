package at.allianz.litigation.repository;

import at.allianz.litigation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    List<Person> findAllByClaimNumber(String claimNumber);
}
