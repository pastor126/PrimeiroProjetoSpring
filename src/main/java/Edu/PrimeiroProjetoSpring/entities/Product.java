
package Edu.PrimeiroProjetoSpring.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criando Classe Produto.
 * @author EDU
 */
public class Product implements Serializable{
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Double price;
    private Category categoria;

    public Product() {
    }

    public Product(Long id, String name, Double price, Category categoria) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoria = categoria;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return Objects.equals(this.categoria, other.categoria);
    }
    
    
    
}
