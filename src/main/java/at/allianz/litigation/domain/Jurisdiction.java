package at.allianz.litigation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Jurisdiction {

    @Id
    @UuidGenerator
    private String id;
//    @NotNull
    private String litigationId;
//    @NotNull
    private JurisdictionLevel level;
    private String court;
    private Double amountToDispute;
    private String result;
    private Double amountAwarded;
    private Date startDate;
    private Date endDate;
    private String tariff;
    private String reasonForResult;
    private Double ownCosts;
    private Double thirdPartyCosts;
    private Double otherCosts;
    private String note;
    private String assignmentNumber;
    private String courtRefSign;
    private String ownLawyer;
    private String ownLawyerRefSign;
    private String thirdPartyLawyer;
    private String thirdPartyLawyerRefSign;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Jurisdiction() {}

    public Jurisdiction(String litigationId, JurisdictionLevel level, String court) {
        this.litigationId = litigationId;
        this.level = level;
        this.court = court;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLitigationId() {
        return litigationId;
    }

    public void setLitigationId(String litigationId) {
        this.litigationId = litigationId;
    }

    public JurisdictionLevel getLevel() {
        return level;
    }

    public void setLevel(JurisdictionLevel level) {
        this.level = level;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public Double getAmountToDispute() {
        return amountToDispute;
    }

    public void setAmountToDispute(Double amountToDispute) {
        this.amountToDispute = amountToDispute;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Double getAmountAwarded() {
        return amountAwarded;
    }

    public void setAmountAwarded(Double amountAwarded) {
        this.amountAwarded = amountAwarded;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tarrif) {
        this.tariff = tarrif;
    }

    public String getReasonForResult() {
        return reasonForResult;
    }

    public void setReasonForResult(String reasonForResult) {
        this.reasonForResult = reasonForResult;
    }

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

    public Double getOwnCosts() {
        return ownCosts;
    }

    public void setOwnCosts(Double ownCosts) {
        this.ownCosts = ownCosts;
    }

    public Double getThirdPartyCosts() {
        return thirdPartyCosts;
    }

    public void setThirdPartyCosts(Double thirdPartyCosts) {
        this.thirdPartyCosts = thirdPartyCosts;
    }

    public Double getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(Double otherCosts) {
        this.otherCosts = otherCosts;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(String assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

    public String getCourtRefSign() {
        return courtRefSign;
    }

    public void setCourtRefSign(String courtRefSign) {
        this.courtRefSign = courtRefSign;
    }

    public String getOwnLawyer() {
        return ownLawyer;
    }

    public void setOwnLawyer(String ownLawyer) {
        this.ownLawyer = ownLawyer;
    }

    public String getOwnLawyerRefSign() {
        return ownLawyerRefSign;
    }

    public void setOwnLawyerRefSign(String ownLawyerRefSign) {
        this.ownLawyerRefSign = ownLawyerRefSign;
    }

    public String getThirdPartyLawyer() {
        return thirdPartyLawyer;
    }

    public void setThirdPartyLawyer(String thirdPartyLawyer) {
        this.thirdPartyLawyer = thirdPartyLawyer;
    }

    public String getThirdPartyLawyerRefSign() {
        return thirdPartyLawyerRefSign;
    }

    public void setThirdPartyLawyerRefSign(String thirdPartyLawyerRefSign) {
        this.thirdPartyLawyerRefSign = thirdPartyLawyerRefSign;
    }
}
