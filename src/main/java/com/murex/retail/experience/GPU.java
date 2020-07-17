package com.murex.retail.experience;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class GPU extends ComputerComponent {

    public GPU(){
    }

    public static class GPUBuilder extends ComputerComponent.Builder
    {

        private String productLine;
        private String numOfCores;
        private String processorClockSpeed;
        private String graphicClockSpeed;

        public GPUBuilder() {
            super();
        }

        public GPU build(){
            return new GPU(this);
        }

        public GPUBuilder uuid(UUID uuid){
            super.uuid=uuid;
            return this;
        }
        public GPUBuilder category(String category){
            super.category=category;
            return this;
        }
        public GPUBuilder name(String name){
            super.name=name;
            return this;
        }
        public GPUBuilder brand(String brand){
            super.brand=brand;
            return this;
        }
        public GPUBuilder price(int price){
            super.price=price;
            return this;
        }
        public GPUBuilder quantity(int quantity){
            super.quantity=quantity;
            return this;
        }

        public GPUBuilder productLine(String productLine){
            this.productLine = productLine;
            return this;
        }
        public GPUBuilder numOfCores(String numOfCores){
            this.numOfCores = numOfCores;
            return this;
        }
        public GPUBuilder processorClockSpeed(String processorClockSpeed){
            this.processorClockSpeed = processorClockSpeed;
            return this;
        }
        public GPUBuilder graphicClockSpeed(String graphicClockSpeed){
            this.graphicClockSpeed = graphicClockSpeed;
            return this;
        }
    }

    @Column(name = "PRODUCTLINE")
    private String productLine;
    @Column(name = "NUMOFCORES")
    private String numOfCores;
    @Column(name = "PROCESSORCLOCKSPEED")
    private String processorClockSpeed;
    @Column(name = "GRAPHICCLOCKSPEED")
    private String graphicClockSpeed;

    public GPU(GPUBuilder gpuBuilder) {
        super(gpuBuilder);
        this.productLine = gpuBuilder.productLine;
        this.numOfCores = gpuBuilder.numOfCores;
        this.processorClockSpeed = gpuBuilder.processorClockSpeed;
        this.graphicClockSpeed = gpuBuilder.graphicClockSpeed;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getNumOfCores() {
        return numOfCores;
    }

    public String getProcessorClockSpeed() {
        return processorClockSpeed;
    }

    public String getGraphicClockSpeed() {
        return graphicClockSpeed;
    }
    @Override
    public String toString(){
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%d\n", getUuid(), getCategory(), getName(), getBrand(), getProductLine(), getNumOfCores(), getProcessorClockSpeed(), getGraphicClockSpeed(), getPrice(), getQuantity());
    }

}
