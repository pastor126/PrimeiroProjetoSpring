
package Edu.PrimeiroProjetoSpring.services;

import Edu.PrimeiroProjetoSpring.dto.ProductDTO;
import Edu.PrimeiroProjetoSpring.entities.Product;
import Edu.PrimeiroProjetoSpring.repositories.ProductRepository;
import java.util.ArrayList;
import static java.util.Collections.list;
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

    public Object findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
