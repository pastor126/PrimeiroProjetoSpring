
package Edu.PrimeiroProjetoSpring.resources;

import Edu.PrimeiroProjetoSpring.entities.Category;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
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
 * 9 - Criar a classe CategoryRepository responsavel pelo acesso aos dados de CATEGORIA
 * @author EDU
 */

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
// -7- Recebendo requisição pelo "/categories" o ResponseEntity devolve uma lista de CATEGORIAS.    
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
// Para teste foi criado um ArrayList de categorias.
        ArrayList<Category> lista = new ArrayList<>();
        lista.add(new Category(1L, "Eletrônicos"));
        lista.add(new Category(2L, "Livros"));
        return ResponseEntity.ok().body(lista);
    }
// -8- Recebendo requisição pela variável "/{id}"    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
// Para teste instancio um objeto cat.
        Category cat = new Category (1L, "Eletrônicos");
        return ResponseEntity.ok().body(cat);
    }
    
    




    
}
