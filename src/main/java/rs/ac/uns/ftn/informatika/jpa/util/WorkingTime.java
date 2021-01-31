package rs.ac.uns.ftn.informatika.jpa.util;

import java.time.LocalDateTime;

public class WorkingTime {
	private long id;
	private LocalDateTime TimeStart;
	private LocalDateTime TimeEnd;
	
	public WorkingTime(long id, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.id = id;
		TimeStart = timeStart;
		TimeEnd = timeEnd;
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
