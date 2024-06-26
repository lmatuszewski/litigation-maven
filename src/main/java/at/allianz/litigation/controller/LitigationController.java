package at.allianz.litigation.controller;

import at.allianz.litigation.domain.Litigation;
import at.allianz.litigation.repository.LitigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/litigations")
public class LitigationController {

    @Autowired
    LitigationRepository litigationRepository;

    @GetMapping("/")
    List<Litigation> all() {
        return litigationRepository.findAll();
    }

    @GetMapping("/by-claim/{claimNumber}")
    List<Litigation> findByClaimNumber(@PathVariable String claimNumber) {
        return litigationRepository.findAllByClaimNumber(claimNumber);
    }

    @GetMapping("/{id}")
    Litigation get(@PathVariable String id) {
        return litigationRepository.findById(id).get();
    }

    @PostMapping("/")
    Litigation create(@RequestBody Litigation litigation) {
        return litigationRepository.save(litigation);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Litigation update(@PathVariable("id") final String id, @RequestBody final Litigation newLitigation) {
        Litigation litigation = litigationRepository.findById(id).get();
        litigation.setCaseNumber(newLitigation.getCaseNumber());
        litigation.setClaimNumber(newLitigation.getClaimNumber());
        litigation.setType(newLitigation.getType());
        litigation.setReason(newLitigation.getReason());
        litigation.setNumberOfJointPlaintiffs(newLitigation.getNumberOfJointPlaintiffs());
        litigation.setResult(newLitigation.getResult());
        litigation.setSentenceYear(newLitigation.getSentenceYear());
        litigation.setSentenceNumber(newLitigation.getSentenceNumber());
        litigation.setOwnCosts(newLitigation.getOwnCosts());
        litigation.setThirdPartyCosts(newLitigation.getThirdPartyCosts());
        litigation.setOtherCosts(newLitigation.getOtherCosts());
        litigation.setNote(newLitigation.getNote());
        return litigationRepository.save(litigation);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        litigationRepository.deleteById(id);
    }

}
