
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.asynchttpclient.Response;
import org.example.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

class BookReservationAppApplicationTests {
	private  final static String URL = "http://localhost:8080/";

	@Test
	 void contextLoads() {
	}
	@Test
	void checkIdTest() {
		List<UserData> users = given()
		.when()
		.contentType(ContentType.JSON)
		.get(URL+"categories")
		.then().log().all()
		.extract().body().jsonPath().getList("data", UserData.class);
		//tikrinam ar yra vienodi user
//		List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
//		for (int i = 0; i < ids.size(); i++) {
//            Assert.isTrue(ids.get(i).contains(ids.get(i)));
			//validacija patikrint

//        }
	}
	@Test
	 void SuccesRegTest() {
		Integer id = 123;
		String token = "";
		Register user = new Register("Tomas", "1234567889");
		SuccessReg seccessReg = given()
				//.body(user)
				.when()
				.post("categories/")
				.then().log().all()
				.extract().as(SuccessReg.class);
	Assertions.assertNotNull(seccessReg.getId());
	Assertions.assertNotNull(seccessReg.getToken());
	Assertions.assertEquals(id, seccessReg.getId());
	Assertions.assertEquals(token, seccessReg.getToken());
	}
	@Test
	void unSuccessRegTest() {
		Response response = (Response) given()
				.when()
				.get("categories/")
				.then().log().all()
				.body("data.id", notNullValue()) //pradubliuot galim visus korteles duomenys ar yra.
				.extract().response();
		JsonPath jsonPath = JsonPath.given(response.getContentType());
				List<Integer> ids = jsonPath.get("data.id"); //pradubliuot galim visus korteles duomenys ar yra.

	}
}
