package com.murex.retail.experience;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class ComputerComponent {

    public static class Builder
    {

        protected UUID uuid;
        protected String category;
        protected String name;
        protected String brand;
        protected int price;
        protected int quantity;

        public Builder(){
        }
    }
    private static final String NOT_APPLICABLE = "N/A";

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "CATEGORY", nullable = false)
    private String category;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "BRAND", nullable = false)
    private String brand;
    @Column(name = "PRICE", nullable = false)
    private int price;
    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    public ComputerComponent(){

    }
    public ComputerComponent(Builder builder){
        this.uuid = builder.uuid;
        this.category = builder.category;
        this.name = builder.name;
        this.brand = builder.brand;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    public UUID getUuid() {
        return uuid;
    }
    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerComponent)) return false;
        ComputerComponent that = (ComputerComponent) o;
        return price == that.price &&
                quantity == that.quantity &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(category, that.category) &&
                Objects.equals(name, that.name) &&
                Objects.equals(brand, that.brand);
    }

}