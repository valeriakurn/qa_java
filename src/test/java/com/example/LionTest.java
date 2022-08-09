package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    private final String SEX;
    private final boolean MANE;

    public LionTest(String sex, boolean mane) {
        this.SEX = sex;
        this.MANE = mane;
    }

    @Parameterized.Parameters
    public static Object[][] doesHaveManeValues() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @Test
    public void doesHaveManeReturnsCorrectValues() throws Exception {
        Lion lion = new Lion(feline, SEX);
        boolean actualManeExistence = lion.doesHaveMane();
        assertEquals("Wrong answer was received", MANE, actualManeExistence);
    }

    @Test
    public void getKittensShouldReturnAmount() throws Exception {

        Lion lion = new Lion(feline, "Самка");
        int expectedKittensAmount = 3;
        Mockito.when(feline.getKittens()).thenReturn(3);
        int actualKittensAmount = lion.getKittens();

        assertEquals("Unexpected kittens amount was returned: ", expectedKittensAmount, actualKittensAmount);
    }

    @Test
    public void getFoodShouldReturnList() throws Exception {

        Lion lion = new Lion(feline, "Самец");
        List<String> expectedList = List.of("string_1", "string_2");
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(expectedList);
        List<String> actualList = lion.getFood();

        assertEquals("Unexpected list of food was returned: ", expectedList, actualList);
    }

    @Test (expected = Exception.class)
    public void shouldThrowExceptionWhenSexNotExisted() throws Exception {

        Lion lion = new Lion(feline, "Male");
    }

}
