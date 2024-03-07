package com.promineotech;

import java.util.Random;

public class TestDemo {

	
	
	
	public Integer addPositive(Integer a, Integer b) {
	if(a > 0 && b >0) {
	 Integer sum = a + b;
	   return sum;
	}else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
	}
	
	//Method to multiply positive numbers. Has an if statement to check that both numbers are positive
	public Integer multiplyPositive(Integer a, Integer b) {
		if(a >= 0 && b >= 0) {
			Integer difference = a * b;
			return difference;
		}else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	public int randomNumberSquared() {
		int random = getRandomInt();
		return random*random;
		}
		
	

	public int getRandomInt(){
			Random random = new Random();
			return random.nextInt(10) +1;
		}
}
