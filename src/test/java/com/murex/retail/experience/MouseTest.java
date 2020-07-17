package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MouseTest {

    @Test
    void test_mouse_class_methods(){
        Mouse mouse = new Mouse.MouseBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("Mouse")
                .name("a")
                .brand("b")
                .dimension("c")
                .colour("d")
                .price(2)
                .quantity(2).build();
        assertEquals(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"), mouse.getUuid());
        assertEquals("Mouse", mouse.getCategory());
        assertEquals("a", mouse.getName());
        assertEquals("b", mouse.getBrand());
        assertEquals("c", mouse.getDimension());
        assertEquals("d", mouse.getColour());
        assertEquals(2, mouse.getPrice());
        assertEquals(2, mouse.getQuantity());
    }
}
