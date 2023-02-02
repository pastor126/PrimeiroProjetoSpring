
package Edu.PrimeiroProjetoSpring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import Edu.PrimeiroProjetoSpring.services.exceptions.EntityNotFoundException;

// Obs.: import javax não funcionou.
import jakarta.servlet.http.HttpServletRequest;


/**
 * Criando manipulador de exceção na camada de recursos.
 * @author EDU
 */

// Anotação que permite essa classe interceptar a exceção na camada de recurso (controlador).
@ControllerAdvice
public class ResourceExceptionHandler {
 
// Anotação para saber qual tipo de exceção vai interceptar.
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> edu_entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTimestemp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        
    }
}