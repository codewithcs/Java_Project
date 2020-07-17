package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoryTest {

    @Test
    void test_memory_class_methods(){
        Memory memory = new Memory.MemoryBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("Memory")
                .name("a")
                .brand("b")
                .intrfce("c")
                .size("d")
                .price(2)
                .quantity(2).build();
        assertEquals(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"), memory.getUuid());
        assertEquals("Memory", memory.getCategory());
        assertEquals("a", memory.getName());
        assertEquals("b", memory.getBrand());
        assertEquals("c", memory.getIntrfce());
        assertEquals("d", memory.getSize());
        assertEquals(2, memory.getPrice());
        assertEquals(2, memory.getQuantity());
    }
}
