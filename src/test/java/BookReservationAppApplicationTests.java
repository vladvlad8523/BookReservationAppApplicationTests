import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.List;
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
		Category user = new Category("Romas");
		String category = given()
				.log().all()
				.contentType("application/json")
				.body(user)
				.when()
				.post(URL + "/categories")
				.then().log().all()
				.extract().body().jsonPath().getString("user");
	}
}
