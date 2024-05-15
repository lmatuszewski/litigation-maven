package at.allianz.litigation.domain;

public enum LitigationReason {

    REASON1("Reason 1"),
    REASON2("Reason 2");

    private String value;

    LitigationReason(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
