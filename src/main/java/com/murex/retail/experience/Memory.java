package com.murex.retail.experience;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Memory extends ComputerComponent{

    public Memory(){
    }
    public static class MemoryBuilder extends ComputerComponent.Builder
    {


        private String intrfce;
        private String size;
        public MemoryBuilder() {
            super();

        }

        public Memory build(){
            return new Memory(this);
        }


        public Memory.MemoryBuilder uuid(UUID uuid){
            super.uuid=uuid;
            return this;
        }
        public MemoryBuilder category(String category){
            super.category=category;
            return this;
        }
        public MemoryBuilder name(String name){
            super.name=name;
            return this;
        }
        public MemoryBuilder brand(String brand){
            super.brand=brand;
            return this;
        }
        public MemoryBuilder price(int price){
            super.price=price;
            return this;
        }
        public MemoryBuilder quantity(int quantity){
            super.quantity=quantity;
            return this;
        }

        public MemoryBuilder intrfce(String intrfce){
            this.intrfce = intrfce;
            return this;
        }
        public MemoryBuilder size(String size){
            this.size = size;
            return this;
        }

    }
    @Column(name = "INTERFACE")
    private String intrfce;
    @Column(name = "SIZE")
    private String size;


    public Memory(Memory.MemoryBuilder memoryBuilder) {
        super(memoryBuilder);
        this.intrfce = memoryBuilder.intrfce;
        this.size = memoryBuilder.size;

    }

    public String getIntrfce() {
        return intrfce;
    }

    public String getSize() {
        return size;
    }
    @Override
    public String toString(){
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%d\t%d\n", getUuid(), getCategory(), getName(), getBrand(), getIntrfce(), getSize(), getPrice(), getQuantity());
    }

}
