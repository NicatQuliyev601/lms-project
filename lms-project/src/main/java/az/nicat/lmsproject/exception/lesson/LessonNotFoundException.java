package az.nicat.lmsproject.exception.lesson;

import az.nicat.lmsproject.exception.handler.ErrorCodes;
import lombok.Getter;

@Getter
public class LessonNotFoundException extends RuntimeException {

    public final ErrorCodes errorCode;
    public final transient Object[] arguments;


    public LessonNotFoundException(ErrorCodes errorCode, Object... args) {
        this.errorCode = errorCode;
        this.arguments = args == null ? new Object[0] : args;
    }
}
