package org.steps;

import org.junit.Assert;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Jira {
	RequestSpecification r;
	@test
	private void get() {

	r=RestAssured.given();
	r = r.header("Content-type", "application/json");
	r = r.auth().preemptive().basic("saranya.krish2013@gmail.com", "YzyNr5xz2KQ6c6QfGDiYF631");
io.restassured.response.Response response = r.get("https://defectfrom.atlassian.net//rest/api/2/search");
 System.out.println("Response Code:"+ response.getStatusCode());
int rp= response.getStatusCode();
 
	ResponseBody body = response.getBody();
	System.out.println(body.asPrettyString());
	Assert.assertEquals(rp, 200);
		}
	public static void main(String[] args) {
		Jira j=new Jira();
		j.get();
	}


}
