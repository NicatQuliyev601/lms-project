package az.nicat.lmsproject.exception.password;

import az.nicat.lmsproject.exception.handler.ErrorCodes;
import lombok.Getter;

@Getter
public class InvalidPasswordException extends RuntimeException {

    public final ErrorCodes errorCode;

    public InvalidPasswordException(ErrorCodes errorCode) {
        this.errorCode = errorCode;
    }
}
