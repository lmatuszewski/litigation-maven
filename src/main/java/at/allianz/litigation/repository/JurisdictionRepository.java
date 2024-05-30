package at.allianz.litigation.repository;

import at.allianz.litigation.domain.Jurisdiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JurisdictionRepository extends JpaRepository<Jurisdiction, String> {

    List<Jurisdiction> findAllByLitigationId(String litigationId);
}
