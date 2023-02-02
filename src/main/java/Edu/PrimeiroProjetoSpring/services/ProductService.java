
package Edu.PrimeiroProjetoSpring.services;

import Edu.PrimeiroProjetoSpring.dto.ProductDTO;
import Edu.PrimeiroProjetoSpring.entities.Product;
import Edu.PrimeiroProjetoSpring.repositories.ProductRepository;
import Edu.PrimeiroProjetoSpring.services.exceptions.EntityNotFoundException;
import java.util.ArrayList;
import static java.util.Collections.list;
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
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true)
    public List<ProductDTO>findAll() {
       List<Product> list = repository.findAll();
       List<ProductDTO> listDTO = new ArrayList<>();
       for(Product pdt : list){
           listDTO.add(new ProductDTO(pdt));
       }
       return listDTO;
    }

    @Transactional(readOnly = true)
    public ProductDTO finById(Long id) {
        Optional<Product> pdt = repository.findById(id);
        Product entity = pdt.orElseThrow(() -> new EntityNotFoundException("Requisição não emcontrada."));
        return new ProductDTO(entity);
    }
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        repository.save(entity);
        return new ProductDTO(entity);
    }
}
