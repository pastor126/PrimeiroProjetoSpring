
package Edu.PrimeiroProjetoSpring.resources;

import Edu.PrimeiroProjetoSpring.dto.CategoryDTO;
import Edu.PrimeiroProjetoSpring.services.CategoryService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
 * 9 - Criar a classe CategoryRepository responsavel pelo acesso aos dados de CATEGORIA
 * 
 * 12 - Injetar a dependência entre o recurso e o repositório pelo @AutoWired criando uma instância do repositório.
 * 
 * 13 - Para testar basta instanciar objetos na classe principal.
 * @author EDU
 */

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
//-12 a- 
    @Autowired
    private CategoryService service;
    

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
// -8- Recebendo requisição pela variável "/{id}"    
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        CategoryDTO cat = service.finById(id);
// -12 c-
// No Jpa é necessário o .get() pois o findById retorna um optional e o get busca o que está informado (id).

        return ResponseEntity.ok().body(cat);
    }
    
// Inserindo nova categoria de produto.
// @PostMapping para inserção (método POST).    
// @RequestBody para que a categoria inserida reconheça e case com o objeto dto.     

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
        dto = service.insert(dto);
 // URI variável java para recurso de internet (URL).       
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
       return ResponseEntity.created(uri).body(dto);
    }
    



    
}
