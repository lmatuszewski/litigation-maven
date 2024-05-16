package at.allianz.litigation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Litigation {

    @Id
    @UuidGenerator
    private String id;

    private String claimNumber;
    private LitigationType type;
    private LitigationReason reason;

    @JsonIgnore
    private String result;

    @JsonIgnore
    private String caseNumber;

    @JsonIgnore
    private LocalDate serviceOfProcessDate;

    @JsonIgnore
    private Integer numberOfJointPlaintiffs;

    @JsonIgnore
    private Integer sentenceYear;

    @JsonIgnore
    private String sentenceNumber;
//    @OneToOne
//    private User plaintiff;
//    @OneToOne
//    private User defendand;
//    @OneToOne
//    private User createdBy;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Litigation() {}

    public Litigation(String claimNumber, LitigationType type, LitigationReason reason) {
        this.claimNumber = claimNumber;
        this.type = type;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Litigation{" +
                "id='" + id + '\'' +
                ", claimNumber='" + claimNumber + '\'' +
                ", type=" + type +
                ", reason=" + reason +
                ", result='" + result + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                ", serviceOfProcessDate=" + serviceOfProcessDate +
                ", numberOfJointPlaintiffs=" + numberOfJointPlaintiffs +
                ", sentenceYear=" + sentenceYear +
                ", sentenceNumber='" + sentenceNumber + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public LitigationType getType() {
        return type;
    }

    public void setType(LitigationType type) {
        this.type = type;
    }

    public LitigationReason getReason() {
        return reason;
    }

    public void setReason(LitigationReason reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public LocalDate getServiceOfProcessDate() {
        return serviceOfProcessDate;
    }

    public void setServiceOfProcessDate(LocalDate serviceOfProcessDate) {
        this.serviceOfProcessDate = serviceOfProcessDate;
    }

    public Integer getNumberOfJointPlaintiffs() {
        return numberOfJointPlaintiffs;
    }

    public void setNumberOfJointPlaintiffs(Integer numberOfJointPlaintiffs) {
        this.numberOfJointPlaintiffs = numberOfJointPlaintiffs;
    }

    public Integer getSentenceYear() {
        return sentenceYear;
    }

    public void setSentenceYear(Integer sentenceYear) {
        this.sentenceYear = sentenceYear;
    }

    public String getSentenceNumber() {
        return sentenceNumber;
    }

    public void setSentenceNumber(String sentenceNumber) {
        this.sentenceNumber = sentenceNumber;
    }

//    public User getPlaintiff() {
//        return plaintiff;
//    }
//
//    public void setPlaintiff(User plaintiff) {
//        this.plaintiff = plaintiff;
//    }
//
//    public User getDefendand() {
//        return defendand;
//    }
//
//    public void setDefendand(User defendand) {
//        this.defendand = defendand;
//    }

//    public User getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(User createdBy) {
//        this.createdBy = createdBy;
//    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
