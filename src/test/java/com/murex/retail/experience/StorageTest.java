package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTest {

    @Test
    void test_memory_class_methods(){
        Storage storage = new Storage.StorageBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("Storage")
                .name("a")
                .brand("b")
                .dimension("c")
                .intrfce("d")
                .size("e")
                .price(2)
                .quantity(2).build();
        assertEquals(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"), storage.getUuid());
        assertEquals("Storage", storage.getCategory());
        assertEquals("a", storage.getName());
        assertEquals("b", storage.getBrand());
        assertEquals("c", storage.getDimension());
        assertEquals("d", storage.getIntrfce());
        assertEquals("e", storage.getSize());
        assertEquals(2, storage.getPrice());
        assertEquals(2, storage.getQuantity());
    }
}
