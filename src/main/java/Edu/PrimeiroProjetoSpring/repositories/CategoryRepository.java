
package Edu.PrimeiroProjetoSpring.repositories;

import Edu.PrimeiroProjetoSpring.entities.Category;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 9 -Criado a classe de acesso a dados de Categoria com anotação @Component
 * 
 * 10 - Criar métodos Salvar, busca por ID e busca todos os objetos (acesso ao DB).
 * @author EDU
 */

@Component
public class CategoryRepository {
    //Para teste inseriu um Map de Categorias (sem BD por enquanto).
    private Map<Long, Category> map = new HashMap<>();
    
    
    public void save(Category obj){
    //Adiciona (put) ao map o objeto recebido (id e o próprio objeto)    
        map.put(obj.getId(), obj);
    }
    
    public Category findById(Long id){
    //Retorna o objeto do map pelo id.    
        return map.get(id);
    }
    
    public List<Category> findAll(Long id){
    //Retorna um ArrayList com os ojetos do map.    
        return new ArrayList<Category>(map.values());
    }
    
}
