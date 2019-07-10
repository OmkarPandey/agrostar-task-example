package agrostar.test.testRunner;

import static org.testng.Assert.assertEquals;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.junit.Test;

import agrostar.base.helper.GitApiHelper;

/**
 * Api test cases class.
 * @author Omkar
 *
 */
public class APITestCases {

	String repoName = "Hello-Test-Agro-World";

	// assign your git repo auth key
	String authKey = "";

	@SuppressWarnings("unchecked")
	//@Test
	public void createRepo() {

		JSONObject bodyJson = new JSONObject();
		bodyJson.put("name", repoName);
		bodyJson.put("description", "This is test repository");
		bodyJson.put("homepage", "https://github.com");
		bodyJson.put("private", false);
		bodyJson.put("has_issues", true);
		bodyJson.put("has_projects", true);
		bodyJson.put("has_wiki", true);

		Response resp = GitApiHelper.postAPI(authKey, "https://api.github.com/user/repos", bodyJson);
		JsonPath jp = new JsonPath(resp.asString());
		System.out.println(jp.toString());
		assertEquals(resp.getStatusCode(), 201);
		assertEquals(jp.get("body.name"), "Hello-Test-Agro-World");
		System.out.println("\n--------Repository created successfully---------\n");

	}

	//@Test
	public void verifyRepo() {

		Response resp = GitApiHelper.getAPI(authKey, "https://api.github.com/repos/:owner/:repo");
		JsonPath jp = new JsonPath(resp.asString());
		System.out.println(jp.toString());

		assertEquals(resp.getStatusCode(), 200);
		assertEquals(jp.get("body.name"), repoName);
	}

}
