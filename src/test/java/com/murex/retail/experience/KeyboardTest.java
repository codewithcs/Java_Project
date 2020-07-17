package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import java.security.Key;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyboardTest {

    @Test
    void test_keyboard_class_methods(){
        Keyboard keyboard = new Keyboard.KeyboardBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("Keyboard")
                .name("a")
                .brand("b")
                .dimension("c")
                .colour("d")
                .price(2)
                .quantity(2).build();
        assertEquals(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"), keyboard.getUuid());
        assertEquals("Keyboard", keyboard.getCategory());
        assertEquals("a", keyboard.getName());
        assertEquals("b", keyboard.getBrand());
        assertEquals("c", keyboard.getDimension());
        assertEquals("d", keyboard.getColour());
        assertEquals(2, keyboard.getPrice());
        assertEquals(2, keyboard.getQuantity());
    }
}
