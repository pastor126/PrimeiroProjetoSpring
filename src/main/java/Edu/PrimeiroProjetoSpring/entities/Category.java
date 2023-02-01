
package Edu.PrimeiroProjetoSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 1 - Criado a classe de CATEGORIAS de produtos do projeto
 * 
 * 2 - Criado construtores, get/set e hash/equals.
 * 
 * 3 - Implements Serializable e adiciona ID padrão ( private static final long serialVersionUID =1L;)
 * 
 * 4 - Criar classe Resource da CATEGORIA
 * @author EDU
 */
//Fazendo o relacionamento para o DB (***)
//*** Informo que Produto é uma entidade.
@Entity

public class Category implements Serializable {
    
    private static final long serialVersionUID =1L;
    
    // *** Informo que o ID é a chave primária.
    @Id
// *** Informando que será autoincrementável no DB.    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
// Acrescentado a lista de produtos da categoria e evitando ciclo de consulta com a anotação @JsonIgnore.
    @JsonIgnore
// Mapeando a lista de produtos para o DB informandos o relacionamento um pra muitos informando o atributo categoria do produto.   
    @OneToMany(mappedBy = "category")
    private List<Product> produtos = new ArrayList<>();
    

    public Category() {
    }
    
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Product> getProdutos() {
        return produtos;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }



 
    
}
