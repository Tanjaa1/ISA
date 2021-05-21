package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;

public class LoyaltyProgrammeDTO {
    private Long Id;
    private Integer Regular;
    private Integer Silver;
    private Integer Gold;
    private Integer PointsForExamination;
    private Integer PointsForCounceling;
    private Double RegularDiscount;
    private Double SilverDiscount;
    private Double GoldDiscount;
   

    public LoyaltyProgrammeDTO(Long id, Integer regular, Integer silver, Integer gold, Integer pointsForExamination,
            Integer pointsForCounceling, Double regularDiscount, Double silverDiscount, Double goldDiscount) {
        Id = id;
        Regular = regular;
        Silver = silver;
        Gold = gold;
        PointsForExamination = pointsForExamination;
        PointsForCounceling = pointsForCounceling;
        RegularDiscount = regularDiscount;
        SilverDiscount = silverDiscount;
        GoldDiscount = goldDiscount;
    }

    public LoyaltyProgrammeDTO(){}

    public LoyaltyProgrammeDTO(LoyaltyProgramme lp){
        this.Id = lp.getId();
        Regular = lp.getRegular();
        Silver = lp.getSilver();
        Gold = lp.getGold();
        PointsForCounceling=lp.getPointsForCounceling();
        PointsForExamination=lp.getPointsForExamination();
        RegularDiscount=lp.getRegularDiscount();
        SilverDiscount=lp.getSilverDiscount();
        GoldDiscount=lp.getGoldDiscount();
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

    public Double getRegularDiscount() {
        return RegularDiscount;
    }

    public void setRegularDiscount(Double regularDiscount) {
        RegularDiscount = regularDiscount;
    }

    public Double getSilverDiscount() {
        return SilverDiscount;
    }

    public void setSilverDiscount(Double silverDiscount) {
        SilverDiscount = silverDiscount;
    }

    public Double getGoldDiscount() {
        return GoldDiscount;
    }

    public void setGoldDiscount(Double goldDiscount) {
        GoldDiscount = goldDiscount;
    }

    
}
