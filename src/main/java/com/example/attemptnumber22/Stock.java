package com.example.attemptnumber22;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stocks")
public class Stock implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nameStock;
    private Float priceStock;

    public Stock() {}

    public Stock(String nameStock) {
        this.nameStock = nameStock;
    }

    public String getNameStock() {
        return nameStock;
    }

    public void setNameStock(String nameStock) {
        this.nameStock = nameStock;
    }

    public Float getPriceStock() {
        return priceStock;
    }

    public void setPriceStock(Float priceStock) {
        this.priceStock = priceStock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
