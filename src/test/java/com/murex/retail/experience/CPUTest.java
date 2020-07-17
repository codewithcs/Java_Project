package com.murex.retail.experience;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CPUTest {

    @Test
    void test_cpu_class_methods(){
        CPU cpu = new CPU.CPUBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("CPU")
                .name("a")
                .brand("b")
                .productLine("c")
                .numOfCores("d")
                .processorClockSpeed("e")
                .graphicClockSpeed("f")
                .price(2)
                .quantity(2).build();
        assertEquals(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"), cpu.getUuid());
        assertEquals("CPU", cpu.getCategory());
        assertEquals("a", cpu.getName());
        assertEquals("b", cpu.getBrand());
        assertEquals("c", cpu.getProductLine());
        assertEquals("d", cpu.getNumOfCores());
        assertEquals("e", cpu.getProcessorClockSpeed());
        assertEquals("f", cpu.getGraphicClockSpeed());
        assertEquals(2, cpu.getPrice());
        assertEquals(2, cpu.getQuantity());
    }
}
