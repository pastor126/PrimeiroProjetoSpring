
package Edu.PrimeiroProjetoSpring.resources.exceptions;

import Edu.PrimeiroProjetoSpring.services.exceptions.DatabaseException;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import Edu.PrimeiroProjetoSpring.services.exceptions.ResourceNotFoundException;
import javax.servlet.http.HttpServletRequest;



/**
 * Criando manipulador de exceção na camada de recursos.
 * @author EDU
 */

// Anotação que permite essa classe interceptar a exceção na camada de recurso (controlador).
@ControllerAdvice
public class ResourceExceptionHandler {
 
// Anotação para saber qual tipo de exceção vai interceptar.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> edu_entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTimestemp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);       
    }
    
        @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTimestemp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Database exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);       
    }
}
