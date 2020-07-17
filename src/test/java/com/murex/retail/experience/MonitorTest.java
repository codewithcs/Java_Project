package com.murex.retail.experience;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonitorTest {

    @Test
    void test_monitor_class_methods(){
        Monitor monitor = new Monitor.MonitorBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("Monitor")
                .name("a")
                .brand("b")
                .dimension("c")
                .resolution("d")
                .colour("e")
                .price(2)
                .quantity(2).build();
        assertEquals(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"), monitor.getUuid());
        assertEquals("Monitor", monitor.getCategory());
        assertEquals("a", monitor.getName());
        assertEquals("b", monitor.getBrand());
        assertEquals("c", monitor.getDimension());
        assertEquals("d", monitor.getResolution());
        assertEquals("e", monitor.getColour());
        assertEquals(2, monitor.getPrice());
        assertEquals(2, monitor.getQuantity());
    }
}
