package at.allianz.litigation.controller;

import at.allianz.litigation.domain.Jurisdiction;
import at.allianz.litigation.repository.JurisdictionRepository;
import at.allianz.litigation.repository.LitigationRepository;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jurisdictions")
public class JurisdictionController {

    @Autowired
    JurisdictionRepository jurisdictionRepository;
    @Autowired
    private LitigationRepository litigationRepository;

    @GetMapping("/")
    List<Jurisdiction> all() {
        return jurisdictionRepository.findAll();
    }

    @GetMapping("/by-litigation/{litigationId}")
    List<Jurisdiction> findAllByLitigationId(@PathVariable String litigationId) {
        return jurisdictionRepository.findAllByLitigationId(litigationId);
    }

    @GetMapping("/{id}")
    Jurisdiction get(@PathVariable String id) {
        return jurisdictionRepository.findById(id).get();
    }

    @PostMapping("/")
    ResponseEntity<?> crate(@Valid @RequestBody Jurisdiction jurisdiction) {
        String litigationId = jurisdiction.getLitigationId();
        if (StringUtils.isEmpty(litigationId)) {
            return ResponseEntity.badRequest().body("LitigationId can't be empty");
        }
        if (!litigationRepository.existsById(litigationId)) {
            return ResponseEntity.badRequest().body("Litigation not found by id: " + litigationId);
        }
        Jurisdiction newJurisdiction = jurisdictionRepository.save(jurisdiction);
        return ResponseEntity.ok(newJurisdiction);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Jurisdiction update(@PathVariable("id") final String id, @RequestBody final Jurisdiction newJurisdiction) {
        Jurisdiction jurisdiction = jurisdictionRepository.findById(id).get();
        jurisdiction.setLevel(newJurisdiction.getLevel());
        return jurisdictionRepository.save(jurisdiction);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        jurisdictionRepository.deleteById(id);
    }
}
