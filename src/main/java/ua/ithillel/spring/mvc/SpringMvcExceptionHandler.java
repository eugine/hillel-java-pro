package ua.ithillel.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.ithillel.spring.mvc.exception.ModelNotFoundException;

@ControllerAdvice
public class SpringMvcExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleModelNotFoundException(ModelNotFoundException exception) {
        return "students/404";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleModelNotFoundException(RuntimeException exception) {
        return "students/error";
    }
}
