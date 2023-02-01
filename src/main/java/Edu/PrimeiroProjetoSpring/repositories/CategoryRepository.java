
package Edu.PrimeiroProjetoSpring.repositories;

import Edu.PrimeiroProjetoSpring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Transformando o repositório em uma interface e a implementação dos métodos fica com o JpaRepository informando o tipo do objeto e o tipo do ID.

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { 
    
}