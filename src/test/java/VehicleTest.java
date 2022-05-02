import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class VehicleTest extends BaseTest{ 
	private static Vehicle vehicle = new Vehicle();
	
	@BeforeClass
	public static void setUp()
	{			
		Response response = getRequestResponse("vehicles/7/");
		vehicle.name=response.path("name");
		vehicle.filmCount=response.path("films.size()");
		vehicle.length=response.path("length");
		vehicle.vehicle_class=response.path("vehicle_class");
		vehicle.model=response.path("model");
	}
		
	@Test
	public void vehicleNameTest()
	{
		Assert.assertEquals("X-34 landspeeder",vehicle.name);
	}

	@Test
	public void vehicleInMoreThan3FilmsExpectFailTest()
	{
		Assert.assertFalse(vehicle.filmCount>=3);
	}
	
	@Test
	public void vehicleClassExpectFailTest()
	{
		Assert.assertNotEquals("repulsor craft",vehicle.vehicle_class);
	}
	
	@Test
	public void vehicleModel()
	{
		Assert.assertEquals("X-34 landspeeder",vehicle.model);
	}
	
	
	@Test
	public void vehicleLenght()
	{
		Assert.assertEquals("3.4 ",vehicle.length);
	}
	//length
}
	
	