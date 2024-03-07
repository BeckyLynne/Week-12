package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(Integer a, Integer b, Integer expected, boolean expectException) {
	if(!expectException) {
		assertThat(testDemo.addPositive(a, b).compareTo(expected) );
	}else {
		assertThatThrownBy(()->testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
	}
	}

	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(2, 4, 6, false), 
				arguments(-1, 4, 0, true), 
				arguments(0, 0, 0, true), 
				arguments(5, 5, 10, false), 
				arguments(2, -3,  5, true)
				);
}

	    @Test
	    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	        testDemo = new TestDemo();
	        
	        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
	        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	        assertThat(testDemo.addPositive(3, 8)).isEqualTo(11);
	        assertThat(testDemo.addPositive(23, 4)).isEqualTo(27);
	
	    }
	
//Test to assert positive numbers multiply correctly
@Test
void assertThatPairsOfPositiveNumbersMultiplyCorrectly() {
	testDemo = new TestDemo();
	
	assertThat(testDemo.multiplyPositive(3, 7)).isEqualTo(21);
	assertThat(testDemo.multiplyPositive(4, 5)).isEqualTo(20);
	assertThat(testDemo.multiplyPositive(5, 5)).isEqualTo(25);
	assertThat(testDemo.multiplyPositive(0, 8)).isEqualTo(0);
	
}
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}


}