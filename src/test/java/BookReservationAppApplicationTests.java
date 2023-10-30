
import io.restassured.http.ContentType;
import org.example.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
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
	 void SuccesRegTest() {
		Integer id = 123;
		String token = "";
		Category user = new Category("Menulis");
		SuccessReg seccessReg = given()
				.body(user)
				.when()
				.post(URL + "/categories")
				.then().log().all()
				.extract().as(SuccessReg.class);
	Assertions.assertNotNull(seccessReg.getId());
	Assertions.assertNotNull(seccessReg.getToken());
	Assertions.assertEquals(id, seccessReg.getId());
	Assertions.assertEquals(token, seccessReg.getToken());
	}
}
