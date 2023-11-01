import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.RandomStringUtils;

public class Category {
    
    private String name;

    public Category( String A, String categoryName) {

        categoryName = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
        this.name = A + categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
