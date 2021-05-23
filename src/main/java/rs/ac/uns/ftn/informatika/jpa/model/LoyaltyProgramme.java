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
    @Column(name="RegularDiscount", unique=false, nullable=true)
    private Double RegularDiscount;

    @Column(name="SilverDiscount", unique=false, nullable=true)
    private Double SilverDiscount;

    @Column(name="GoldDiscount", unique=false, nullable=true)
    private Double GoldDiscount;

    @Column(name="PointsForExamination", unique=false, nullable=true)
    private Integer PointsForExamination;
    @Column(name="PointsForCounceling", unique=false, nullable=true)
    private Integer PointsForCounceling;


  
    public LoyaltyProgramme(Long id, Integer regular, Integer silver, Integer gold, Double regularDiscount,
    Double silverDiscount, Double goldDiscount, Integer pointsForExamination, Integer pointsForCounceling) {
        this.id = id;
        Regular = regular;
        Silver = silver;
        Gold = gold;
        RegularDiscount = regularDiscount;
        SilverDiscount = silverDiscount;
        GoldDiscount = goldDiscount;
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
        RegularDiscount=lpDTO.getRegularDiscount();
        SilverDiscount=lpDTO.getSilverDiscount();
        GoldDiscount=lpDTO.getGoldDiscount();
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
