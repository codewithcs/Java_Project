package com.murex.retail.experience;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Monitor extends ComputerComponent {

    public Monitor(){
    }


    public static class MonitorBuilder extends ComputerComponent.Builder
    {


        private String dimension;
        private String colour;
        private String resolution;

        public MonitorBuilder() {
            super();

        }

        public Monitor build(){
            return new Monitor(this);
        }

        public Monitor.MonitorBuilder uuid(UUID uuid){
            super.uuid=uuid;
            return this;
        }
        public MonitorBuilder category(String category){
            super.category=category;
            return this;
        }
        public MonitorBuilder name(String name){
            super.name=name;
            return this;
        }
        public MonitorBuilder brand(String brand){
            super.brand=brand;
            return this;
        }
        public MonitorBuilder price(int price){
            super.price=price;
            return this;
        }
        public MonitorBuilder quantity(int quantity){
            super.quantity=quantity;
            return this;
        }

        public MonitorBuilder dimension(String dimension){
            this.dimension = dimension;
            return this;
        }
        public MonitorBuilder colour(String colour){
            this.colour = colour;
            return this;
        }
        public MonitorBuilder resolution(String resolution){
            this.resolution = resolution;
            return this;
        }

    }

    @Column(name = "DIMENSION")
    private String dimension;
    @Column(name = "COLOUR")
    private String colour;
    @Column(name = "RESOLUTION")
    private String resolution;

    public Monitor(Monitor.MonitorBuilder monitorBuilder) {
        super(monitorBuilder);
        this.dimension = monitorBuilder.dimension;
        this.colour = monitorBuilder.colour;
        this.resolution = monitorBuilder.resolution;

    }

    public String getDimension() {
        return dimension;
    }
    public String getColour() {
        return colour;
    }
    public String getResolution() {
        return resolution;
    }

    @Override
    public String toString(){
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%d\n", getUuid(), getCategory(), getName(), getBrand(), getDimension(), getResolution(), getColour(), getPrice(), getQuantity());
    }

}
