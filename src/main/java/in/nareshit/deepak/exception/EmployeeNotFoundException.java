package in.nareshit.deepak.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8521977860287455356L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String messsage) {
		super(messsage);
	}

}
