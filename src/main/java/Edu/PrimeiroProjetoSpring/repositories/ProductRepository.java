
package Edu.PrimeiroProjetoSpring.repositories;

import Edu.PrimeiroProjetoSpring.entities.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 9 -Criado a classe de acesso a dados de Categoria com anotação @Component para informar que essa classe está sujeita a injeção de dependência.
 * 
 * 10 - Criar métodos Salvar, busca por ID e busca todos os objetos (acesso ao DB).
 * @author EDU
 * 
 * 11 - Ir para os Recursos e trocar o obj instanciado pela classe de acesso aos dados (Repository).
 */

@Component
public class ProductRepository {
    //Para teste inseriu um Map de Categorias (sem BD por enquanto).
    private Map<Long, Product> map = new HashMap<>();
    
    
    public void save(Product obj){
    //Adiciona (put) ao map o objeto recebido (id e o próprio objeto)    
        map.put(obj.getId(), obj);
    }
    
    public Product findById(Long id){
    //Retorna o objeto do map pelo id.    
        return map.get(id);
    }
    
    public List<Product> findAll(){
    //Retorna um ArrayList com os ojetos do map.    
        return new ArrayList<Product>(map.values());
    }

    
    
}
