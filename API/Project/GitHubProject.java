package Project;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProject {
	//SSH Key to test with GitHub API
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKhwOf9bEW6yl5IrQ81R1LdZRMVGsIfcMT1ha0ACBZNi";
	//Temp variable to hold the SSH Key ID
	int keyID;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		// initialize the Requestspecbuilder
		 requestSpec = new RequestSpecBuilder().
				 setBaseUri("https://api.github.com/user/keys").
				addHeader("Content-Type", "application/json").
				addHeader("Authorization" , "token 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").
				addHeader("X-GitHub-Api-Version", "2022-11-28").
				build();
		 // initialize the ResponseSpecBuilder
		 responseSpec = new ResponseSpecBuilder().
				 expectBody("title", Matchers.equalTo("TestKey")).
				 expectResponseTime(Matchers.lessThanOrEqualTo(7000L)).
				 build();
		 
	}
		@Test(priority = 1)
		public void postRequestTest() {
			// Request Body Hash
			HashMap<String, String> reqBody = new HashMap<>();
			reqBody.put("title", "TestKey");
			reqBody.put("key", sshKey);
			//send request and save response
			Response response = RestAssured.given().
					spec(requestSpec).
					body(reqBody).
					when().
					post();
			//Extract ID from response
			keyID = response.then().extract().path("id");
			//Assertions
			response.then().statusCode(201).spec(responseSpec).log().all();
					
		}
			@Test(priority = 2)
			public void getRequestTest() {
				//send request and save response
				RestAssured.given().
					spec(requestSpec).
					pathParam("keyId", keyID).
				when().
					get("/{keyId}").
				then().
					statusCode(200).spec(responseSpec);
					
			}
			@Test(priority = 3)
			public void deleteRequestTest() {
				//send request and save response
				RestAssured.given().
					spec(requestSpec).
					pathParam("keyId", keyID).
				when().
					delete("/{keyId}").
				then().
					statusCode(204);
					
			}
}
			
