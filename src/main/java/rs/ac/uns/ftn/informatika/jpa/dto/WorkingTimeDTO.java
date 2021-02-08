package rs.ac.uns.ftn.informatika.jpa.dto;

import java.time.LocalDateTime;

import rs.ac.uns.ftn.informatika.jpa.util.WorkingTime;

public class WorkingTimeDTO {

	private long id;

	private LocalDateTime TimeStart;

	private LocalDateTime TimeEnd;
	

	
	public WorkingTimeDTO(){}

	public WorkingTimeDTO(long id, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.id = id;
		TimeStart = timeStart;
		TimeEnd = timeEnd;
	}

    public WorkingTimeDTO(WorkingTime WorkingTime) {
		super();
		this.id = WorkingTime.getId();
		TimeStart = WorkingTime.getTimeStart();
		TimeEnd = WorkingTime.getTimeEnd();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getTimeStart() {
		return TimeStart;
	}

	public void setTimeStart(LocalDateTime timeStart) {
		TimeStart = timeStart;
	}

	public LocalDateTime getTimeEnd() {
		return TimeEnd;
	}

	public void setTimeEnd(LocalDateTime timeEnd) {
		TimeEnd = timeEnd;
	}
}
