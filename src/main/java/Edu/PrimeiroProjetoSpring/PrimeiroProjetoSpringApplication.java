package Edu.PrimeiroProjetoSpring;
//Primeiro projeto da aula do DevSuperior
import Edu.PrimeiroProjetoSpring.entities.Category;
import Edu.PrimeiroProjetoSpring.entities.Product;
import Edu.PrimeiroProjetoSpring.repositories.CategoryRepository;
import Edu.PrimeiroProjetoSpring.repositories.ProductRepository;
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
    // Inserindo o ProductRepository.    
        @Autowired
        private ProductRepository ProductRepository;
        

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//*** Deixando os ID nulos para que o DB incremente.
        Category cat1 = new Category(null, "Eletrônicos");
        Category cat2 = new Category(null, "Livros");
        Category cat3 = new Category(null, "Roupa de cama");
        
        Product p1 = new Product(null, "TV LB5600", 3000.00, cat1);
        Product p2 = new Product(null, "SunTzu", 40.00, cat2);
        Product p3 = new Product(null, "IPHONE X", 6000.00, cat1);
        Product p4 = new Product(null, "Xeque-Mate", 55.00, cat2);
        Product p5 = new Product(null, "Lençol TEKA", 85.00, cat3);
    
    // Referenciar os produtos de cada categoria criando uma lista.
        cat1.getProdutos().addAll(Arrays.asList(p1,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2,p4));
        cat3.getProdutos().addAll(Arrays.asList(p5));
        
    //Salvando as instancias.
        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        
    //Salvando as instâncias de Produtos.    
        ProductRepository.save(p1);
        ProductRepository.save(p2);
        ProductRepository.save(p3);
        ProductRepository.save(p4);
        ProductRepository.save(p5);
        
    }

}
