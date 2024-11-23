package com.junitchk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CalculateTest {
	Calculate calculate;

	@BeforeEach
void met() {
	 calculate = new Calculate();
}

@ParameterizedTest
@CsvSource({
	"1,1,2",
	"2,3,5",
	"4,5,9",
	"10,20,30",
	"0,0,0"
})
void TestAdditio(int a,int b , int expectedsum) {
	int actual_value = calculate.add(a, b);
	assertEquals(expectedsum,actual_value,"The sum of "+a+" and "+b+" should be"+expectedsum);
}
}
