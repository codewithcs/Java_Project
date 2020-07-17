package com.murex.retail.experience;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.UUID;

public class ComputerComponentFactory {



    public static ComputerComponent createComputerComponent(String [] componentType){
        switch (componentType[1]){
            case "CPU" : {
                return createCPUComponent(componentType);
            }
            case "Monitor" : {
                return createMonitorComponent(componentType);
            }
            case "Keyboard" :  {
                return createKeyboardComponent(componentType);
            }
            case "Mouse" : {
                return createMouseComponent(componentType);
            }
            case "GPU" : {
                return createGPUComponent(componentType);
            }
            case "Memory" : {
                return createMemoryComponent(componentType);
            }
            case "Storage" : {
                return createStorageComponent(componentType);
            }
            default:
                break;
        }
    throw new InvalidCategoryException(componentType[1] + "is not a valid category.");
    }

    private static ComputerComponent createStorageComponent(String[] componentType) {
        return new Storage.StorageBuilder()
                .uuid(UUID.fromString(componentType[0]))
                .category(componentType[1])
                .name(componentType[2])
                .brand(componentType[3])
                .dimension(componentType[8])
                .intrfce(componentType[11])
                .size(componentType[12])
                .price(Integer.parseInt(componentType[13]))
                .quantity(Integer.parseInt(componentType[14])).build();
    }

    private static ComputerComponent createMemoryComponent(String[] componentType) {
        return new Memory.MemoryBuilder()
                .uuid(UUID.fromString(componentType[0]))                .category(componentType[1])
                .name(componentType[2])
                .brand(componentType[3])
                .intrfce(componentType[11])
                .size(componentType[12])
                .price(Integer.parseInt(componentType[13]))
                .quantity(Integer.parseInt(componentType[14])).build();
    }

    private static ComputerComponent createGPUComponent(String[] componentType) {
        return new GPU.GPUBuilder()
                .uuid(UUID.fromString(componentType[0]))                .category(componentType[1])
                .name(componentType[2])
                .brand(componentType[3])
                .productLine(componentType[4])
                .numOfCores(componentType[5])
                .processorClockSpeed(componentType[6])
                .graphicClockSpeed(componentType[7])
                .price(Integer.parseInt(componentType[13]))
                .quantity(Integer.parseInt(componentType[14])).build();
    }

    private static ComputerComponent createMouseComponent(String[] componentType) {
        return new Mouse.MouseBuilder()
                .uuid(UUID.fromString(componentType[0]))                .category(componentType[1])
                .name(componentType[2])
                .brand(componentType[3])
                .dimension(componentType[8])
                .colour(componentType[10])
                .price(Integer.parseInt(componentType[13]))
                .quantity(Integer.parseInt(componentType[14])).build();
    }

    private static ComputerComponent createKeyboardComponent(String[] componentType) {
        return new Keyboard.KeyboardBuilder()
                .uuid(UUID.fromString(componentType[0]))                .category(componentType[1])
                .name(componentType[2])
                .brand(componentType[3])
                .dimension(componentType[8])
                .colour(componentType[10])
                .price(Integer.parseInt(componentType[13]))
                .quantity(Integer.parseInt(componentType[14])).build();
    }

    private static ComputerComponent createMonitorComponent(String[] componentType) {
        return new Monitor.MonitorBuilder()
                .uuid(UUID.fromString(componentType[0]))                .category(componentType[1])
                .name(componentType[2])
                .brand(componentType[3])
                .dimension(componentType[8])
                .resolution(componentType[9])
                .colour(componentType[10])
                .price(Integer.parseInt(componentType[13]))
                .quantity(Integer.parseInt(componentType[14])).build();
    }

    private static ComputerComponent createCPUComponent(String[] componentType) {
        return new CPU.CPUBuilder()
                .uuid(UUID.fromString(componentType[0]))                .category(componentType[1])
                .name(componentType[2])
                .brand(componentType[3])
                .productLine(componentType[4])
                .numOfCores(componentType[5])
                .processorClockSpeed(componentType[6])
                .graphicClockSpeed(componentType[7])
                .price(Integer.parseInt(componentType[13]))
                .quantity(Integer.parseInt(componentType[14])).build();
    }


}
