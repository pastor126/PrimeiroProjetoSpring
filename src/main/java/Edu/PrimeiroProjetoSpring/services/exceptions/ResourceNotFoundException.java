
package Edu.PrimeiroProjetoSpring.services.exceptions;

/**
 *Tratando exceção para busca de item inexistente.
 * @author EDU
 */
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
    
   
}
