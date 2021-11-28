package RestAPIAssig;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteAssign {

	@Test
	public void DeleteCallAssign() {
		
		Logger logger=Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("**************START Of DELETE CALL**************");
		RestAssured.given()	
						.baseUri("http://3.85.146.196:8088")
						.when()
						.delete("/employees/6")
						.then()
						.statusCode(200)
						.log()
						.all();
	}
}
