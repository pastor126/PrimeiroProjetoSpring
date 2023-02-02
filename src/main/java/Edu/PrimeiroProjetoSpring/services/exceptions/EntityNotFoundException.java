
package Edu.PrimeiroProjetoSpring.services.exceptions;

/**
 *Tratando exceção para busca de item inexistente.
 * @author EDU
 */
public class EntityNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
    
   
}
