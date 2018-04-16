package edu.ap.spring.model;

import java.io.Serializable;
import java.time.LocalDate;

public class InhaalExamen implements Serializable {
	
	/*
	 * Een aanvraag bestaat uit de naam van de student (String), het examen (String), een reden (String) 
	 * en de datum van indienen (automatisch gegenereerd). Bij het indienen, wordt de aanvraag weggeschreven 
	 * in een Redis database (4 punten). Er wordt eerst gecontroleerd of de aanvraag (combinatie van student, examen en reden) 
	 * al bestaat en indien dit het geval is, wordt ze niet weggeschreven (3 punten).
	 */
	
	private static final long serialVersionUID = 1L;

	private long id;
    private String student;
    private String exam;
 	private String date;
	private String reason;
 
    public InhaalExamen() {
    		this.date = LocalDate.now().toString();
    }
    
    public InhaalExamen(Long id, String student, String exam, String reason, String date) {
    		this.id = id;
    		this.student = student;
    		this.exam = exam;
    		this.reason = reason;
    	    this.date = date;
    }
    
    public InhaalExamen(Long id, String student, String exam, String reason) {
    	this.id = id;
		this.student = student;
		this.exam = exam;
		this.reason = reason;
		this.date = LocalDate.now().toString();
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "InhaalExamen [id=" + id + ", student=" + student + ", exam=" + exam + ", date=" + date + ", reason="
				+ reason + "]";
	}
	
}
