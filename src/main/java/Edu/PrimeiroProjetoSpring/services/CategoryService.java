
package Edu.PrimeiroProjetoSpring.services;

import Edu.PrimeiroProjetoSpring.entities.Category;
import Edu.PrimeiroProjetoSpring.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EDU
 */
// Construindo a camada de serviços independente dos recursos e repositórios.
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    @Transactional(readOnly = true)
    public List<Category>findAll() {
       return repository.findAll();
    }
    
}
