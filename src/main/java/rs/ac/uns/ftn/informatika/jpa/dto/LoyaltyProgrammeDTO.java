package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;

public class LoyaltyProgrammeDTO {
    private Long Id;
    private Integer Regular;
    private Integer Silver;
    private Integer Gold;
    private Integer PointsForExamination;
    private Integer PointsForCounceling;
   
    public LoyaltyProgrammeDTO(Long id, Integer regular, Integer silver, Integer gold, Integer pointsForExamination,
            Integer pointsForCounceling) {
        Id = id;
        Regular = regular;
        Silver = silver;
        Gold = gold;
        PointsForExamination = pointsForExamination;
        PointsForCounceling = pointsForCounceling;
    }

    public LoyaltyProgrammeDTO(){}

    public LoyaltyProgrammeDTO(LoyaltyProgramme lp){
        this.Id = lp.getId();
        Regular = lp.getRegular();
        Silver = lp.getSilver();
        Gold = lp.getGold();
        PointsForCounceling=lp.getPointsForCounceling();
        PointsForExamination=lp.getPointsForExamination();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getRegular() {
        return Regular;
    }

    public void setRegular(Integer regular) {
        Regular = regular;
    }

    public Integer getSilver() {
        return Silver;
    }

    public void setSilver(Integer silver) {
        Silver = silver;
    }

    public Integer getGold() {
        return Gold;
    }

    public void setGold(Integer gold) {
        Gold = gold;
    }

    public Integer getPointsForExamination() {
        return PointsForExamination;
    }

    public void setPointsForExamination(Integer pointsForExamination) {
        PointsForExamination = pointsForExamination;
    }

    public Integer getPointsForCounceling() {
        return PointsForCounceling;
    }

    public void setPointsForCounceling(Integer pointsForCounceling) {
        PointsForCounceling = pointsForCounceling;
    }

    
}
