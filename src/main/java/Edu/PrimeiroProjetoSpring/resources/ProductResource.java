
package Edu.PrimeiroProjetoSpring.resources;

import Edu.PrimeiroProjetoSpring.dto.ProductDTO;
import Edu.PrimeiroProjetoSpring.services.ProductService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * 4 - Criado classe de RECURSOS disponibilizados pela CATEGORIA.
 * 
 * 5 - Inserir anotação RestController para controle REST.
 * 
 * 6 - Inserir anotação RequestMapping comtendo o valor da URL para mapeamento.
 * 
 * 7 - Criar o método de busca para TODOS 
 * 
 * 8 - Criar o método de busca para único objeto usando anotação @PathVariable para informar o objeto.
 * 
 * 9 - Criar a classe ProductRepository responsavel pelo acesso aos dados de CATEGORIA
 * 
 * 12 - Injetar a dependência entre o recurso e o repositório pelo @AutoWired criando uma instância do repositório.
 * 
 * 13 - Para testar basta instanciar objetos na classe principal.
 * @author EDU
 */

@RestController
//caminho products
@RequestMapping(value = "/products")
public class ProductResource {
//-12 a- 
    @Autowired
    private ProductService service;
    
//     public List<Product> findAll(){
//        return ProductRepository.findAll();
//    }
    
// -7- Recebendo requisição pelo "/categories" o ResponseEntity devolve uma lista de CATEGORIAS.    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
// -12 b-
        List<ProductDTO> lista = service.findAll();        
        return ResponseEntity.ok().body(lista);
    }
// -8- Recebendo requisição pela variável "/{id}"    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO pdt = service.finById(id);
        return ResponseEntity.ok().body(pdt);
    }
    
    
// Inserindo novo produto.
// @PostMapping para inserção (método POST).    
// @RequestBody para que o produto inserido reconheça e case com o objeto dto.     

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
        dto = service.insert(dto);
 // URI variável java para recurso de internet (URL).       
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
       return ResponseEntity.created(uri).body(dto);
    }
    
    // @PutMapping para atualização (update) recebendo o valor do id.    
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }


    
}
