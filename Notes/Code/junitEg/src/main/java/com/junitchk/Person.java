package com.junitchk;

import java.util.Objects;

public class Person {
private String name;
private int age;
private float loan_eligibility;
public Person(String name, int age, float loan_eligibility) {
	super();
	this.name = name;
	this.age = age;
	this.loan_eligibility = loan_eligibility;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public float getLoan_eligibility() {
	return loan_eligibility;
}
public void setLoan_eligibility(float loan_eligibility) {
	this.loan_eligibility = loan_eligibility;
}

public Person addeligibility(float percent) {
	float multiplier = 1+(percent * 0.01f);
	loan_eligibility = loan_eligibility * multiplier;
	return this;
}
@Override
public int hashCode() {
	return Objects.hash(age, loan_eligibility, name);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	return age == other.age && Float.floatToIntBits(loan_eligibility) == Float.floatToIntBits(other.loan_eligibility)
			&& Objects.equals(name, other.name);
}

}
