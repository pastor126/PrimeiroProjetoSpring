package Edu.PrimeiroProjetoSpring.services;

import Edu.PrimeiroProjetoSpring.dto.CategoryDTO;
import Edu.PrimeiroProjetoSpring.dto.ProductDTO;
import Edu.PrimeiroProjetoSpring.entities.Category;
import Edu.PrimeiroProjetoSpring.entities.Product;
import Edu.PrimeiroProjetoSpring.repositories.CategoryRepository;
import Edu.PrimeiroProjetoSpring.repositories.ProductRepository;
import Edu.PrimeiroProjetoSpring.services.exceptions.ResourceNotFoundException;
import static java.util.Collections.list;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EDU
 */
// Construindo a camada de serviços independente dos recursos e repositórios.
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository catRepos;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Pageable pageable) {
       Page<Product> list = repository.findAll(pageable);
       return list.map(x -> new ProductDTO(x));
    }
    
    @Transactional(readOnly = true)
    public ProductDTO finById(Long id) {
        Optional<Product> pdt = repository.findById(id);
        Product entity = pdt.orElseThrow(() -> new ResourceNotFoundException("Requisição não emcontrada."));
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        converterDtoParaEntity(entity, dto);
        
        repository.save(entity);
        return new ProductDTO(entity);
    }
    
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            converterDtoParaEntity(entity, dto);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }
    
    private void converterDtoParaEntity(Product entity, ProductDTO dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
        entity.setDate(dto.getDate());
        
        entity.getCategories().clear();
        for (CategoryDTO catDto : dto.getCategories()) {
            Category category = catRepos.getReferenceById(catDto.getId());
            entity.getCategories().add(category);
        }
    }
    
}
