package at.allianz.litigation.domain;

public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


}
