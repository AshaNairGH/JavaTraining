package com.junitchk;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArithmeticTest {

   // private final Arithmetic arithmetic = new Arithmetic();
	
	private Arithmetic arithmetic;

    @BeforeAll //Executes once, before all test cases
    static void befallmet() {
    System.out.println("Before All method");	
    }
    
    @BeforeEach
    void befeachmet() {
    	arithmetic = new Arithmetic();
    System.out.println("Before Each method");	
    }
    
    @Disabled
    @Test //Testcase
    void testMet() {
    	System.out.println("Test1");
    	Arithmetic arith = new Arithmetic();
    	//invoke business logic method, with certain parameters
    	int actual_val = arith.add(-3,-5);
    	//cross check return value with expected value using assert
    	assertEquals(-8,  actual_val, "Addition should work for negative values also");
    }
    
    @Test
    @Tag("feature2")
    void meta()
    {
    	int arr[]= {11,22,33,44,55};
    	int []actual_arr = arithmetic.reverse(arr);
    	int []expected_arr = {55,44,33,22,11};
    	assertArrayEquals(expected_arr, actual_arr, "Comparing reversed arrays");
    }
    
    @Test
    @Order(1)
    @Tag("feature2")
    void testAdd() {
    	System.out.println("Test2");
        assertEquals(5, arithmetic.add(2, 3), "Addition should return the sum of two numbers");
    }

    @Test
    @Order(3)
    @Tag("feature1")
    void testSubtract() {
    	System.out.println("Test3");
        assertEquals(1, arithmetic.subtract(5, 4), "Subtraction should return the difference of two numbers");
    }

    @Test
    @Order(2)
    @Tag("feature2")
    void testMultiply() {
    	System.out.println("Test4");
        assertEquals(6, arithmetic.multiply(2, 3), "Multiplication should return the product of two numbers");
    }

   
    @Test
    @Tag("feature1")
    void testDivide() {
    	System.out.println("Test5");
        assertEquals(2, arithmetic.divide(6, 3), "Division should return the quotient of two numbers");
    }

    @Test
    @Tag("feature2")
    void testDivideByZero() {
    	System.out.println("Test6");
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> arithmetic.divide(1, 0), "Division by zero should throw ArithmeticException");
        assertEquals("Cannot divide by zero", thrown.getMessage());
    }
    
    @Test
    @Tag("feature1")
    void testMax() {
    	System.out.println("Test7");
    	assertEquals(6.0, arithmetic.max(3.0,6.0), "Max should be the maximum of 2 numbers");
    }
    
    @Test
    @Tag("feature2")
    void testMaxNeg() {
    	System.out.println("Test8");
    	assertEquals(3.0, arithmetic.max(3.0,-6.0), "Max should work with negative numbers also");
    }
    
    @AfterEach
    void metafter() {
    	arithmetic = null;
    	System.out.println("After Each");
    }
    
    @AfterAll
    static void metafterall() {
    	System.out.println("After All");
    }
}
