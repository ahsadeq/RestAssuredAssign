package RestAPIAssig;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetAssign {
	
	@Test
	public void GetCallAssign () {
		
		
		Logger logger=Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("**************START Of GET CALL**************");
		RestAssured.given()
						.baseUri("http://3.85.146.196:8088/")
						.when()
						.get("employees")
						.then()
						.log()
						.body();
		
	}

}
