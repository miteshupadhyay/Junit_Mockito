package com.mitesh.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperTest {

	StringHelper helper=new StringHelper();
	
	String input;
	String expectedOutput;
	
	public StringHelperTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testCondition() {
		String expectedOutputs[][]= {
										{"AACD","CD"},
										{"ACD","CD"}
									};	
		return Arrays.asList(expectedOutputs);
	}
	
	@Test
	public void truncateAInFirst2PositionsTest_first() {		
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}
	@Test
	public void truncateAInFirst2PositionsTest_second() {		
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void truncateAInFirst2PositionsTest() {		
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}
	
	@Test
	public void areFirstAndLastTwoCharactersTheSameTest() {		
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

	public String getInput() {
		return input;
	}

	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}
	

}
