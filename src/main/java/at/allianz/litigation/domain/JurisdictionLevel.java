package at.allianz.litigation.domain;

public enum JurisdictionLevel {

    FIRST("FIRST"),
    SECOND("SECOND"),
    THIRD("THIRD"),
    FOURTH("FOURTH"),
    FIFTH("FIFTH"),
    SIXTH("SIXTH");

    private String value;

    JurisdictionLevel(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
