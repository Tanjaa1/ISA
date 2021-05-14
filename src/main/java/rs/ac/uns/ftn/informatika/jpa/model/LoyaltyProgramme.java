package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.LoyaltyProgrammeDTO;

@Entity
@Table(name="LoyaltyProgramme")
public class LoyaltyProgramme {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="Regular", unique=false, nullable=true)
    private Integer Regular;

    @Column(name="Silver", unique=false, nullable=true)
    private Integer Silver;

    @Column(name="Gold", unique=false, nullable=true)
    private Integer Gold;
    @Column(name="PointsForExamination", unique=false, nullable=true)
    private Integer PointsForExamination;
    @Column(name="PointsForCounceling", unique=false, nullable=true)
    private Integer PointsForCounceling;


  
    public LoyaltyProgramme(Long id, Integer regular, Integer silver, Integer gold, Integer pointsForExamination,
            Integer pointsForCounceling) {
        this.id = id;
        Regular = regular;
        Silver = silver;
        Gold = gold;
        PointsForExamination = pointsForExamination;
        PointsForCounceling = pointsForCounceling;
    }
    public LoyaltyProgramme(LoyaltyProgrammeDTO lpDTO) {
        this.id = lpDTO.getId();
        Regular = lpDTO.getRegular();
        Silver = lpDTO.getSilver();
        Gold = lpDTO.getGold();
        PointsForExamination = lpDTO.getPointsForExamination();
        PointsForCounceling =lpDTO.getPointsForCounceling();
    }
    public LoyaltyProgramme(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
