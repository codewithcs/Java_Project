package com.murex.retail.experience;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Keyboard extends ComputerComponent {

    public Keyboard(){
    }
    public static class KeyboardBuilder extends ComputerComponent.Builder
    {

        private String dimension;
        private String colour;

        public KeyboardBuilder() {
            super();

        }

        public Keyboard build(){
            return new Keyboard(this);
        }

        public KeyboardBuilder uuid(UUID uuid){
            super.uuid=uuid;
            return this;
        }
        public KeyboardBuilder category(String category){
            super.category=category;
            return this;
        }
        public KeyboardBuilder name(String name){
            super.name=name;
            return this;
        }
        public KeyboardBuilder brand(String brand){
            super.brand=brand;
            return this;
        }
        public KeyboardBuilder price(int price){
            super.price=price;
            return this;
        }
        public KeyboardBuilder quantity(int quantity){
            super.quantity=quantity;
            return this;
        }

        public KeyboardBuilder dimension(String dimension){
            this.dimension = dimension;
            return this;
        }
        public KeyboardBuilder colour(String colour){
            this.colour = colour;
            return this;
        }

    }
    @Column(name = "DIMENSION")
    private String dimension;
    @Column(name = "COLOUR")
    private String colour;

    public Keyboard(Keyboard.KeyboardBuilder keyboardBuilder) {
        super(keyboardBuilder);
        this.dimension = keyboardBuilder.dimension;
        this.colour = keyboardBuilder.colour;

    }
    public String getDimension() {
        return dimension;
    }

    public String getColour() {
        return colour;
    }
    @Override
    public String toString(){
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%d\t%d\n", getUuid(), getCategory(), getName(), getBrand(), getDimension(), getColour(), getPrice(), getQuantity());
    }


}
