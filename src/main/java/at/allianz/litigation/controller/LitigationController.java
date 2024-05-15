package at.allianz.litigation.controller;

import at.allianz.litigation.domain.Litigation;
import at.allianz.litigation.repository.LitigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LitigationController {

    @Autowired
    LitigationRepository litigationRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/litigations")
    List<Litigation> all() {
        return litigationRepository.findAll();
    }

    @GetMapping("/litigations/{id}")
    Litigation get(@PathVariable String id) {
        return litigationRepository.findById(id).get();
    }

    /*
    @GetMapping(value = {"/customers/{firstName}", "/customers/"})
    public ResponseEntity findByFirstName(@PathVariable(required = false) String firstName) {
        // TODO: proper validation
        if (firstName == null || firstName.isBlank() || firstName.equals("null")) {
            return ResponseEntity.badRequest().body(null);
        }
        Litigation customer = litigationRepository.findByFirstName(firstName);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }
     */

    @PostMapping("/litigations")
    Litigation crate(@RequestBody Litigation litigation) {
        System.out.println("litigation = " + litigation);
        return litigationRepository.save(litigation);
    }

    @GetMapping("/litigations/delete/{id}")
    void delete(@PathVariable String id) {
        litigationRepository.deleteById(id);
    }
}
