package com.junitchk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class PersonTest {
private Person person;

@BeforeEach
void metbe() {
	person = new Person("name1",34,10000);
}

@Test
void met() {
	//increment eligibility
	Person person_actual = person.addeligibility(10);

//assert after incrementing 10 percent
	assertEquals(11000, person_actual.getLoan_eligibility(), " Checking loan eligibility after incrementing 10 percent");

	Person person_expected = new Person("name1",34,11000);

	assertEquals(person_actual,person_expected,"Directly checking the objects after incrementing salary");

}
}
