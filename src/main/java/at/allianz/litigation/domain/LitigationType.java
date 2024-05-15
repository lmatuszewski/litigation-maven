package at.allianz.litigation.domain;

public enum LitigationType {

    ADMINISTRATIVE_PROCEEDING("Administrative proceeding"),
    ALTERNATIVE_DISPUTE_RESOLUTION("Alternative dispute resolution"),
    ARBITRATION_PROCEEDING("Arbitration proceeding");

    private String value;

    LitigationType(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
