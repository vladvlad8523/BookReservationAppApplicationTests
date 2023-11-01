import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

class BookReservationAppApplicationTests {
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
	 void namePostTest() {
		Category name = new Category( "A", "");
		String category = given()
				.log().all()
				.contentType("application/json")
				.body(name)
				.when()
				.post(URL + "/categories/2")
				.then().log().all()
				//.statusCode(201)
				.extract().body().jsonPath().getString("name");
	}
}
