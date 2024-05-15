package at.allianz.litigation.domain;

public enum LitigationReason {

    REASON1("REASON1"),
    REASON2("REASON2");

    private String value;

    LitigationReason(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
