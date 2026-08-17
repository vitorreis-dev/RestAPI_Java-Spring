package vitordev.project.projetoSpring.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

public record ExceptionResponse(LocalDateTime localDateTime, HttpStatus status, String message, String details){
}