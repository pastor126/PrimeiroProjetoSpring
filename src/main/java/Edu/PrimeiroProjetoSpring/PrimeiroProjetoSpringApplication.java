package Edu.PrimeiroProjetoSpring;
//Primeiro projeto da aula do DevSuperior
import Edu.PrimeiroProjetoSpring.entities.Category;
import Edu.PrimeiroProjetoSpring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//14 - Implementar a interface CommandLineRuner (inicia junto com o start)


@SpringBootApplication
public class PrimeiroProjetoSpringApplication implements CommandLineRunner {
    // 14 - Injetar dependência para instanciar o categoryRepository com o @Autowired.
        @Autowired
        private CategoryRepository categoryRepository;
        

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(1L, "Eletrônicos");
        Category cat2 = new Category(2L, "Livros");
        Category cat3 = new Category(3L, "Roupa de cama");
        
    //Salvando as instancias.
        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        
        
    }

}
