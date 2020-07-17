package com.murex.retail.experience;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidCategoryExceptionTest {

    @Test
    void test_invalid_category_exception_method(){
        InvalidCategoryException invalidCategoryException = new InvalidCategoryException();
        Assertions.assertEquals(InvalidCategoryException.class ,invalidCategoryException.getClass());
    }
}
