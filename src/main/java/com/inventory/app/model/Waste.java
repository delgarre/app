package com.inventory.app.model;

import jakarta.persistence.*;

import java.util.Date;

//class for determining inventory that has been wasted
@Entity
@Table(name = "waste")
public class Waste {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inventoryName")
    private String inventoryName;

    @Column(name = "unitPrice")
    private String unitPrice;

    @Column(name = "wasteDate")
    private Date wasteDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "totalPrice")
    private String totalPrice;

    @Column(name = "image", length = 1000)
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getWasteDate() {
        return wasteDate;
    }

    public void setWasteDate(Date wasteDate) {
        this.wasteDate = wasteDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

