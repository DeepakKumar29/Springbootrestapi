package in.nareshit.deepak.handler;

import java.util.Date;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.nareshit.deepak.error.ErrorType;
import in.nareshit.deepak.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class MuCustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorType> handleEmployeeNotfound(EmployeeNotFoundException enfe) {
		return new ResponseEntity<ErrorType>(
				new ErrorType(new Date().toString(), "EMPLOYEE", enfe.getMessage(), "PROCESSING ISSUE"),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
