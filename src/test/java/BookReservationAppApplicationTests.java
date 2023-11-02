import io.restassured.http.ContentType;
import org.junit.jupiter.api.RepeatedTest;
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
	//@Test()
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
					.statusCode(201)
					.extract().response().jsonPath().getString("name");
		} catch (Exception e) {
			System.out.println("klaida JSON: " + e.getMessage());
		}
	}
}