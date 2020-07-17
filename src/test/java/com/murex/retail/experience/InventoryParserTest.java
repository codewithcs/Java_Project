package com.murex.retail.experience;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryParserTest {

    @Test
    void test_create_object_method(){
        List<String> test = (Arrays.asList("dummy, line, test,a,s,d,f,g,h,j,k,l,o,2,2","152d7ce3-3f92-42e6-9b36-e21b2151e593,CPU,c,d,e,f,g,h,i,j,k,l,m,2,3"));
        ComputerComponent cc = new CPU.CPUBuilder()
                .uuid(UUID.fromString("152d7ce3-3f92-42e6-9b36-e21b2151e593"))
                .category("CPU")
                .name("c")
                .brand("d")
                .productLine("e")
                .numOfCores("f")
                .processorClockSpeed("g")
                .graphicClockSpeed("h")
                .price(2)
                .quantity(3)
                .build();
        List<ComputerComponent> expectedResult = new ArrayList<>();
        expectedResult.add(cc);
        InventoryParser inventoryParser= new InventoryParser();
        List<ComputerComponent> actualResult = inventoryParser.createObjects(test);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void test_wrong_number_of_columns_in_csv() {
        List<String> test = (Arrays.asList("dummy, line, test,a,s,d,f,g,j,k,l,o,2,2","b5709966-76a6-48fb-ab72-18be9135230a,CPU,c,d,e"));
        InventoryParser inventoryParser = new InventoryParser();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> inventoryParser.createObjects(test));
    }

}
