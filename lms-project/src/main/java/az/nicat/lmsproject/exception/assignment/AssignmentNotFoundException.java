package az.nicat.lmsproject.exception.assignment;

import az.nicat.lmsproject.exception.handler.ErrorCodes;
import lombok.Getter;

@Getter
public class AssignmentNotFoundException extends RuntimeException {

    public final ErrorCodes errorCode;
    public final transient Object[] arguments;


    public AssignmentNotFoundException(ErrorCodes errorCode, Object... args) {
        this.errorCode = errorCode;
        this.arguments = args == null ? new Object[0] : args;
    }
}
