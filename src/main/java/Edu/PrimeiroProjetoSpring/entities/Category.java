/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Edu.PrimeiroProjetoSpring.entities;

import java.io.Serializable;
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
public class Category implements Serializable {
    
    private static final long serialVersionUID =1L;
    
    private Long id;
    private String name;

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
