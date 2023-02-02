
package Edu.PrimeiroProjetoSpring.services;

import Edu.PrimeiroProjetoSpring.dto.CategoryDTO;
import Edu.PrimeiroProjetoSpring.entities.Category;
import Edu.PrimeiroProjetoSpring.repositories.CategoryRepository;
import Edu.PrimeiroProjetoSpring.services.exceptions.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public List<CategoryDTO>findAll() {
      List<Category> list = repository.findAll();
        
       List<CategoryDTO> listDTO = new ArrayList<>();
       for(Category cat : list){
           listDTO.add(new CategoryDTO(cat));
       }
       return listDTO;
    }
    
    @Transactional(readOnly = true)
    public CategoryDTO finById(Long id) {
        Optional<Category> cat = repository.findById(id);
        Category entity = cat.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return new CategoryDTO(entity);
    }
    
}
