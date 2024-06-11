package at.allianz.litigation.controller;

import at.allianz.litigation.domain.Person;
import at.allianz.litigation.domain.PersonType;
import at.allianz.litigation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    /*
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    List<Person> all() {
        return personRepository.findAll();
    }

    @GetMapping("/by-claim/{claimNumber}")
    List<Person> findByClaimNumber(@PathVariable String claimNumber) {
        return personRepository.findAllByClaimNumber(claimNumber);
    }

    @GetMapping("/by-claim-and-type/{claimNumber}/{personType}")
    List<Person> findByClaimNumber(@PathVariable String claimNumber, @PathVariable String personType) {
        return personRepository.findAllByClaimNumberAndType(claimNumber, PersonType.valueOf(personType));
    }

    @GetMapping("/{id}")
    Person get(@PathVariable String id) {
        return personRepository.findById(id).get();
    }

    @PostMapping("/")
    Person crate(@RequestBody Person litigation) {
        return personRepository.save(litigation);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person update(@PathVariable("id") final String id, @RequestBody final Person newPerson) {
        Person person = personRepository.findById(id).get();
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        personRepository.deleteById(id);
    }
     */
}
