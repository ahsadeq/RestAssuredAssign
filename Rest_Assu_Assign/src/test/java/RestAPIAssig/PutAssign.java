package RestAPIAssig;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutAssign {
	
	@Test
	public void PutCallAssign() {
		
		
		Logger logger=Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("**************START Of PUT CALL**************");

		Map<String,Object> Jsonmap=new HashMap<String,Object>();
		Jsonmap.put("firstName", "Ahmad");
		Jsonmap.put("lastName", "Sadeq");
		Jsonmap.put("salary", "9100");
		Jsonmap.put("email", "aaaa@bbbb.com");
		
		RestAssured.given()	
						.baseUri("http://3.85.146.196:8088")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(Jsonmap)
						.when()
						.put("/employees/5")
						.then()
						.statusCode(200)
						.body("firstName", Matchers.equalTo("Ahmad"))
						.body("lastName", Matchers.equalTo("Sadeq"))
						.body("salary", Matchers.equalTo(9100))
						.body("email", Matchers.equalTo("aaaa@bbbb.com"))
						.log()
						.body();
		
	}

}
