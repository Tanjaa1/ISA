package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.ac.uns.ftn.informatika.jpa.dto.MarkDTO;

@Entity
@Table(name="Mark")
public class Markk {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

    @Column(name="Marks", unique=false, nullable=true)
	private Integer Marks;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Patient Patient;

    public Markk(){}

    public Markk(Integer mark, Patient patient){
        Marks = mark;
        Patient = patient;
    }

    public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public Integer getMarks() {
		return Marks;
	}

	public void setMarks(Integer marks) {
		Marks = marks;
	}

    public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient patient) {
		Patient = patient;
	}

    public Markk(MarkDTO markDTO){
        Id = markDTO.getId();
        Marks = markDTO.getMarks();
        Patient = new Patient(markDTO.getPatient());
    }
}
