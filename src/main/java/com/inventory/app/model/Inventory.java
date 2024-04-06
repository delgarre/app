package com.inventory.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "vendor")
    @OneToMany(mappedBy = "inventory")
    private List<Vendor> vendor = new ArrayList<>();

    @Column(name = "price")
    private String price;

    @Column(name = "image", length = 1000)
    private byte[] image;

    @Column(name = "unitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "amount")
    private String amount;

    @Column(name = "unitPrice")
    private String unitPrice;

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

    public List<Vendor> getVendor() {
        return vendor;
    }

    public void setVendor(List<Vendor> vendor) {
        this.vendor = vendor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}

