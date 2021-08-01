package in.nareshit.deepak.error;

public class ErrorType {
	
	private String date;
	private String eName;
	private String message;
	private String issue;
	
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getIssue() {
		return issue;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}


	public ErrorType() {
		super();
	}


	public ErrorType(String date, String eName, String message, String issue) {
		super();
		this.date = date;
		this.eName = eName;
		this.message = message;
		this.issue = issue;
	}
	
	



}
