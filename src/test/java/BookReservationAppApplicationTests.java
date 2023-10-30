

import io.restassured.http.ContentType;
import org.example.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.given;

class BookReservationAppApplicationTests {
	private  final static String URL = "http://localhost:8080";

	@Test
	void showNamesTest() {
		List<UserData> users = given()
				.when()
				.contentType(ContentType.JSON)
				.get(URL + "/categories")
				.then().log().all()
				.extract().body().jsonPath().getList("name", UserData.class);
	}
	@Test
	 void namePostTest() {

		Category user = new Category("Menulis");
		Category category = given()
				.log().all()
				.contentType("application/json")
				.body(user)
				.when()
				.post(URL + "/categories")
				.then().log().all()
				.extract().response().as(Category.class);


	}
}
