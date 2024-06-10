package at.allianz.litigation.domain;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Person {

    @Id
    @UuidGenerator
    private String id;

    @NotNull
    private String claimNumber;
    private PersonType type;

    private String firstName;
    private String lastName;

    @Embedded
    private Address address;

    public Person() {
    }

    public Person(String claimNumber, PersonType type, String firstName, String lastName) {
        this.claimNumber = claimNumber;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @NotNull String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(@NotNull String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
