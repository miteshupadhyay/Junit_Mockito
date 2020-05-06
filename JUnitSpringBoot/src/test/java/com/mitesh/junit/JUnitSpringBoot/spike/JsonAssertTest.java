package com.mitesh.junit.JUnitSpringBoot.spike;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
 
	
	String actualReponse="{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException
	{
		String expectedReponse="{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 100}";
		JSONAssert.assertEquals(expectedReponse, actualReponse, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException
	{
		String expectedReponse="{\"id\": 1,\"name\": \"Ball\",\"price\": 10}";
		JSONAssert.assertEquals(expectedReponse, actualReponse, false);
	}
	
	@Test
	public void jsonAssert_withOutEscapeCharacters() throws JSONException
	{
		String expectedReponse="{id:1,name:Ball,price:10}";
		JSONAssert.assertEquals(expectedReponse, actualReponse, false);
	}
}
