package agrostar.base.helper;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;
import io.restassured.response.Response;

/**
 * API'S methods
 * @author Omkar
 *
 */
public class GitApiHelper {

	/**
	 * perform GET request and verify status code
	 * @param URL
	 */
	public static Response getAPI(String authKey, String URL) {
		return given().config(config().sslConfig(sslConfig().allowAllHostnames()))
				.headers("Authorization", "token " + authKey)
				.headers("Content-Type", "application/json").when().get(URL).andReturn();
	}

	/**
	 * perform post request
	 * @param authKey
	 * @param URL
	 * @param body
	 */
	public static Response postAPI(String authKey, String URL, Object body) {
		return given().config(config().sslConfig(sslConfig().allowAllHostnames()))
				.headers("Authorization", "token " + authKey)
				.headers("Content-Type", "application/json").body(body).when().post(URL).thenReturn();
	}

}
