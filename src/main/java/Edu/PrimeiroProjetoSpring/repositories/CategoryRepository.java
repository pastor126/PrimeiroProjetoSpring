
package Edu.PrimeiroProjetoSpring.repositories;

import Edu.PrimeiroProjetoSpring.entities.Category;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 9 -Criado a classe de acesso a dados de Categoria com anotação @Component para informar que essa classe está sujeita a injeção de dependência.
 * 
 * 10 - Criar métodos Salvar, busca por ID e busca todos os objetos (acesso ao DB).
 * @author EDU
 * 
 * 11 - Ir para os Recursos e trocar o obj instanciado pela classe de acesso aos dados (Repository).
 */

//Transformando o repositório em uma interface e a implementação dos métodos fica com o JpaRepository informando o tipo do objeto e o tipo do ID.

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { 
    
}