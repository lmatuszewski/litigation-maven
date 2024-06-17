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

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/jurisdictions")
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
        // TODO: find better way to do that
        jurisdiction.setLevel(newJurisdiction.getLevel());
        jurisdiction.setCourt(newJurisdiction.getCourt());
        jurisdiction.setAmountAwarded(newJurisdiction.getAmountAwarded());
        jurisdiction.setAmountToDispute(newJurisdiction.getAmountToDispute());
        jurisdiction.setResult(newJurisdiction.getResult());
        jurisdiction.setStartDate(newJurisdiction.getStartDate());
        jurisdiction.setEndDate(newJurisdiction.getEndDate());
        jurisdiction.setTarrif(newJurisdiction.getTarrif());
        jurisdiction.setReasonForResult(newJurisdiction.getReasonForResult());
        jurisdiction.setTarrif(newJurisdiction.getTarrif());
        jurisdiction.setOwnCosts(newJurisdiction.getOwnCosts());
        jurisdiction.setThirdPartyCosts(newJurisdiction.getThirdPartyCosts());
        jurisdiction.setOtherCosts(newJurisdiction.getOtherCosts());
        jurisdiction.setNote(newJurisdiction.getNote());
        return jurisdictionRepository.save(jurisdiction);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        jurisdictionRepository.deleteById(id);
    }
}
