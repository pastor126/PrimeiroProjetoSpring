
package Edu.PrimeiroProjetoSpring.services;

import Edu.PrimeiroProjetoSpring.entities.Product;
import Edu.PrimeiroProjetoSpring.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EDU
 */
// Construindo a camada de serviços independente dos recursos e repositórios.
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public List<Product>findAll() {
       return repository.findAll();
    }
}
