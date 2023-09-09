package ru.netology.AuthorizationService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.netology.AuthorizationService.exeption.InvalidCredentials;
import ru.netology.AuthorizationService.exeption.UnauthorizedUser;

@ControllerAdvice
public class ExeptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.ordinal()).body(ex.getMessage());
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser ex) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}
