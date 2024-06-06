package at.allianz.litigation.domain;

public enum PersonType {

    PLAINTIFF("PLAINTIFF"),
    DEFENDANT("DEFENDANT"),
    LAWYER("LAWYER");

    private String value;

    PersonType(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
