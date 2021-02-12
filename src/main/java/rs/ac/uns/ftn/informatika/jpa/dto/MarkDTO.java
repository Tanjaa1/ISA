package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Mark;

public class MarkDTO {

	private Long Id;
	private Integer Marks;
    private PatientDTO Patient;

    public MarkDTO(){}

    public MarkDTO(Integer mark, PatientDTO patient){
        Marks = mark;
        Patient = patient;
    }

    public MarkDTO(Mark mark){
        Id = mark.getId();
        Marks = mark.getMarks();
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

    public PatientDTO getPatient() {
		return Patient;
	}

	public void setPatient(PatientDTO patient) {
		Patient = patient;
	}
}
