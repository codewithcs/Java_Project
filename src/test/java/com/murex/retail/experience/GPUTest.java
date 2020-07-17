package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GPUTest {

    @Test
    void test_gpu_class_methods(){
        GPU gpu = new GPU.GPUBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("GPU")
                .name("a")
                .brand("b")
                .productLine("c")
                .numOfCores("d")
                .processorClockSpeed("e")
                .graphicClockSpeed("f")
                .price(2)
                .quantity(2).build();
        assertEquals(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"), gpu.getUuid());
        assertEquals("GPU", gpu.getCategory());
        assertEquals("a", gpu.getName());
        assertEquals("b", gpu.getBrand());
        assertEquals("c", gpu.getProductLine());
        assertEquals("d", gpu.getNumOfCores());
        assertEquals("e", gpu.getProcessorClockSpeed());
        assertEquals("f", gpu.getGraphicClockSpeed());
        assertEquals(2, gpu.getPrice());
        assertEquals(2, gpu.getQuantity());
    }
}
