package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsCorrectValue() {

        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();

        assertEquals("Sound is not correct: ", expectedSound, actualSound);
    }

    @Test
    public void getFoodShouldReturnList() throws Exception {

        Cat cat = new Cat(feline);
        List<String> expectedList = List.of("string_1", "string_2");
        Mockito.when(feline.eatMeat()).thenReturn(expectedList);
        List<String> actualList = cat.getFood();

        assertEquals("Unexpected list of food was returned: ", expectedList, actualList);
    }

}
