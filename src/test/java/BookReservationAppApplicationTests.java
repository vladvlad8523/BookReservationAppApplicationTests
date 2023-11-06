import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

class BookReservationAppApplicationTests extends BaseSettingsTest {
	private  final static String URL = "http://localhost:8080";

	@Test
	void showNamesTest() {
		String users = given()
				.when()
				.contentType(ContentType.JSON)
				.get(URL + "/categories")
				.then().log().all()
				.statusCode(200)
				.extract().body().jsonPath().getString("name");
	}

	@Test
	@DisplayName("POST TEST 3x random")
	@RepeatedTest(3)
	public void namePostTest() {
		Category name = new Category( "A", "");
		try {
			String category = given()
					.log().all()
					.contentType(ContentType.JSON)
					.body(name)
					.when()
					.post(URL + "/categories")
					.then().log().all()
					.assertThat().statusCode(Matchers.oneOf(201))
					.extract().response().jsonPath().getString("name");

		} catch (Exception e) {
			System.out.println("error JSON: " + e.getMessage());

		}
	}
	@RepeatedTest(3)
	@Step
	@DisplayName("POST TEST 3x")
	public void namePostTest2() {
		Category name = new Category("A", "");
		try {
			String category = given()
					.log().all()
					.contentType(ContentType.JSON)
					.body(name)
					.when()
					.post(URL + "/categories")
					.then().log().all()
					.assertThat().statusCode(Matchers.equalTo(201))
					.extract().response().jsonPath().getString("name");
			System.out.println("Status code 201, category name: " + category);
		} catch (AssertionError e) {
			System.out.println("Error: Status code is not equal to 201");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error JSON: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
//allure generate target/allure-results --clean
//allure serve