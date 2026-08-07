package vitordev.project.projetoSpring.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public record ExceptionResponse(HttpStatus status, String message, String details){
}