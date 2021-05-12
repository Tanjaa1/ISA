package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;

public class LoyaltyProgrammeDTO {
    private Long Id;
    private Integer Regular;
    private Integer Silver;
    private Integer Gold;
    public LoyaltyProgrammeDTO(Long id, Integer regular, Integer silver, Integer gold) {
        this.Id = id;
        Regular = regular;
        Silver = silver;
        Gold = gold;
    }

    public LoyaltyProgrammeDTO(){}

    public LoyaltyProgrammeDTO(LoyaltyProgramme lp){
        this.Id = lp.getId();
        Regular = lp.getRegular();
        Silver = lp.getSilver();
        Gold = lp.getGold();
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

    
}
