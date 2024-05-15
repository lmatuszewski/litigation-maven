package at.allianz.litigation.domain;

public enum LitigationType {

    ADMINISTRATIVE_PROCEEDING("ADMINISTRATIVE_PROCEEDING"),
    ALTERNATIVE_DISPUTE_RESOLUTION("ALTERNATIVE_DISPUTE_RESOLUTION"),
    ARBITRATION_PROCEEDING("ARBITRATION_PROCEEDING");

    private String value;

    LitigationType(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
