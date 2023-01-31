
package Edu.PrimeiroProjetoSpring.resources;

import Edu.PrimeiroProjetoSpring.entities.Product;
import Edu.PrimeiroProjetoSpring.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ProductRepository ProductRepository;
    
// -7- Recebendo requisição pelo "/categories" o ResponseEntity devolve uma lista de CATEGORIAS.    
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
// -12 b-
        List<Product> lista = ProductRepository.findAll();
        return ResponseEntity.ok().body(lista);
    }
// -8- Recebendo requisição pela variável "/{id}"    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
// -12 c-
// No Jpa é necessário o .get() pois o findById retorna um optional e o get busca o que está informado (id).
        Product pdt = ProductRepository.findById(id).get();
        return ResponseEntity.ok().body(pdt);
    }
    
    



    
}
