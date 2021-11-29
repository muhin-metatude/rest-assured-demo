package api.test.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

public class apiTest
{
	@Test
	@DisplayName("Ensures that the use API call returns status code 200")
	public void ensureThatUserAPICallReturnStatusCode200()
	{
		given().when().get("https://api.github.com/users/vogella").then().assertThat().statusCode(200);
	}

	@Test
	@DisplayName("Ensures that the content type starts with application/json")
	public void ensureThatJsonIsReturnedAsContentType()
	{
		given().when().get("https://api.github.com/users/vogella").then().assertThat().contentType(ContentType.JSON);
	}

	@Test // Just for print request and response
	public void logRequestAndResponseDetails()
	{
		given().log().all().when().get("https://api.github.com/users/vogella").then().log().body();
	}

	@Test
	@DisplayName("Ensure that the JSON for the user vogella contains a reference to the Twitter user")
	void ensureJsonContainsTwitterHandler()
	{
		given().when().get("https://api.github.com/users/vogella").then().assertThat().body("twitter_username", equalTo("vogella"));
	}
}
