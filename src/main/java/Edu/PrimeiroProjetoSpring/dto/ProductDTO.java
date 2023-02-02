
package Edu.PrimeiroProjetoSpring.dto;

import Edu.PrimeiroProjetoSpring.entities.Category;
import Edu.PrimeiroProjetoSpring.entities.Product;
import java.io.Serializable;

/**
 *Criando DTO.
 * @author EDU
 */
public class ProductDTO implements Serializable{
    private static final long serialVersionUID =1L;
    private Long id;
    private String name;
    private Double price;
    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public ProductDTO(Product entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.category = entity.getCategory();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
}
