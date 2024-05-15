package at.allianz.litigation.repository;

import at.allianz.litigation.domain.Litigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitigationRepository extends JpaRepository<Litigation, String> {

}
