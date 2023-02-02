
package Edu.PrimeiroProjetoSpring.services.exceptions;

/**
 *Tratando exceção de integridade do DB.
 * @author EDU
 */
public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }
    
   
}
