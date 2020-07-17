package com.murex.retail.experience;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;
import java.util.UUID;

@Entity
public class CPU extends ComputerComponent {

    public CPU(){
    }

    public static class CPUBuilder extends ComputerComponent.Builder
    {
        private String productLine;
        private String numOfCores;
        private String processorClockSpeed;
        private String graphicClockSpeed;

        public CPUBuilder() {
            super();
        }

        public CPU build(){
            return new CPU(this);
        }

        public CPUBuilder uuid(UUID uuid){
            super.uuid=uuid;
            return this;
        }
        public CPUBuilder category(String category){
            super.category=category;
            return this;
        }
        public CPUBuilder name(String name){
            super.name=name;
            return this;
        }
        public CPUBuilder brand(String brand){
            super.brand=brand;
            return this;
        }
        public CPUBuilder price(int price){
            super.price=price;
            return this;
        }
        public CPUBuilder quantity(int quantity){
            super.quantity=quantity;
            return this;
        }

        public CPUBuilder productLine(String productLine){
            this.productLine = productLine;
            return this;
        }
        public CPUBuilder numOfCores(String numOfCores){
            this.numOfCores = numOfCores;
            return this;
        }
        public CPUBuilder processorClockSpeed(String processorClockSpeed){
            this.processorClockSpeed = processorClockSpeed;
            return this;
        }
        public CPUBuilder graphicClockSpeed(String graphicClockSpeed){
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

    public CPU(CPUBuilder cpuBuilder) {
        super(cpuBuilder);

        this.productLine = cpuBuilder.productLine;
        this.numOfCores = cpuBuilder.numOfCores;
        this.processorClockSpeed = cpuBuilder.processorClockSpeed;
        this.graphicClockSpeed = cpuBuilder.graphicClockSpeed;
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

    public String toString(){
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%d\n", getUuid(), getCategory(), getName(), getBrand(), getProductLine(), getNumOfCores(), getProcessorClockSpeed(), getGraphicClockSpeed(), getPrice(), getQuantity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPU)) return false;
        if (!super.equals(o)) return false;
        CPU cpu = (CPU) o;
        return Objects.equals(productLine, cpu.productLine) &&
                Objects.equals(numOfCores, cpu.numOfCores) &&
                Objects.equals(processorClockSpeed, cpu.processorClockSpeed) &&
                Objects.equals(graphicClockSpeed, cpu.graphicClockSpeed);
    }

}
