package com.murex.retail.experience;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ComputerComponentFactoryTest {
    static UUID uuid;
    static String randomUUIDString;
    @BeforeAll
    public static void setUp(){
        uuid = UUID.randomUUID();
        randomUUIDString = uuid.toString();
    }

    @Test
    void test_having_unknown_category(){
        String csvList[] = {randomUUIDString, "TEST", "c", "d", "e", "f", "g", "h", "N/A", "N/A", "N/A", "N/A", "N/A","2", "3"};
        Assertions.assertThrows(InvalidCategoryException.class, () -> ComputerComponentFactory.createComputerComponent(csvList));

    }

    @Test
    void test_CPU_class(){
        String[] csvList = {randomUUIDString, "CPU", "c", "d", "e", "f", "g", "h", "N/A", "N/A", "N/A", "N/A", "N/A","2", "3"};
        ComputerComponent cc = ComputerComponentFactory.createComputerComponent(csvList);
       assertEquals(CPU.class ,cc.getClass());
    }
    @Test
    void test_GPU_class() {
        String[] csvList = {randomUUIDString, "GPU", "c", "d", "e", "f", "g", "h", "N/A", "N/A", "N/A", "N/A", "N/A","2", "3"};
        ComputerComponent cc = ComputerComponentFactory.createComputerComponent(csvList);
        assertEquals(GPU.class ,cc.getClass());
    }

    @Test
    void test_Monitor_class() {
        String[] csvList = {randomUUIDString, "Monitor", "c", "d","N/A", "N/A", "N/A", "N/A", "e", "f", "g", "N/A", "N/A","2", "3"};
        ComputerComponent cc = ComputerComponentFactory.createComputerComponent(csvList);
        assertEquals(Monitor.class ,cc.getClass());
    }

    @Test
    void test_Keyboard_class() {
        String[] csvList = {randomUUIDString, "Keyboard", "c", "d","N/A", "N/A", "N/A", "N/A", "e", "N/A", "g", "N/A", "N/A","2", "3"};
        ComputerComponent cc = ComputerComponentFactory.createComputerComponent(csvList);
        assertEquals(Keyboard.class ,cc.getClass());
    }
    @Test
    void test_Mouse_class() {
        String[] csvList = {randomUUIDString, "Mouse", "c", "d","N/A", "N/A", "N/A", "N/A", "e", "N/A", "g", "N/A", "N/A","2", "3"};
        ComputerComponent cc = ComputerComponentFactory.createComputerComponent(csvList);
        assertEquals(Mouse.class ,cc.getClass());
    }
    @Test
    void test_Memory_class() {
        String[] csvList = {randomUUIDString, "Memory", "c", "d","N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A","e","f","2", "3"};
        ComputerComponent cc = ComputerComponentFactory.createComputerComponent(csvList);
        assertEquals(Memory.class ,cc.getClass());
    }
    @Test
    void test_Storage_class() {
        String[] csvList = {randomUUIDString, "Storage", "c", "d","N/A", "N/A", "N/A", "N/A", "e", "N/A", "N/A","f","g","2", "3"};
        ComputerComponent cc = ComputerComponentFactory.createComputerComponent(csvList);
        assertEquals(Storage.class ,cc.getClass());
    }
}
