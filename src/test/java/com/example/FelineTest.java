package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatShouldReturnList() throws Exception {

        List<String> expectedList = List.of("string_1", "string_2");
        Mockito.doReturn(expectedList).when(feline).getFood(Mockito.anyString());
        List<String> actualList = feline.eatMeat();

        assertEquals("Unexpected list of food was returned: ", expectedList, actualList);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {

        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();

        assertEquals("Family is not correct: ", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnsOneKitten() {

        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();

        assertEquals("More than one kitten was returned: ", expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getKittensReturnsSpecifiedKittensCount() {

        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(5);

        assertEquals("Unexpected kittens amount was returned: ", expectedKittensCount, actualKittensCount);
    }

}
