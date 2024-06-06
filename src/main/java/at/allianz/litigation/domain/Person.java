package at.allianz.litigation.domain;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UuidGenerator;

//@Entity
public class Person {

    @Id
    @UuidGenerator
    private String id;

    @NotNull
    private String claimNumber;


    private String firstName;
    private String lastName;

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
}
