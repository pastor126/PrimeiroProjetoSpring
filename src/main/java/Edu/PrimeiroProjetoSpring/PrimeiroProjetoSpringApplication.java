package Edu.PrimeiroProjetoSpring;
//Primeiro projeto da aula do DevSuperior
import Edu.PrimeiroProjetoSpring.entities.Category;
import Edu.PrimeiroProjetoSpring.entities.Product;
import Edu.PrimeiroProjetoSpring.repositories.CategoryRepository;
import java.util.Arrays;
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
        
        Product p1 = new Product(1L, "TV LB5600", 3000.00, cat1);
        Product p2 = new Product(2L, "SunTzu", 40.00, cat2);
        Product p3 = new Product(3L, "IPHONE X", 6000.00, cat1);
        Product p4 = new Product(4L, "Xeque-Mate", 55.00, cat2);
        Product p5 = new Product(5L, "Lençol TEKA", 85.00, cat3);
    
    // Referenciar os produtos de cada categoria criando uma lista.
        cat1.getProdutos().addAll(Arrays.asList(p1,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2,p4));
        cat3.getProdutos().addAll(Arrays.asList(p5));
        
    //Salvando as instancias.
        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        
        
    }

}
