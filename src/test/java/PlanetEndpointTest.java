import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public final class PlanetEndpointTest extends BaseTest{ 
	private static Planet planet = new Planet();
		
	@BeforeClass
	public static void setUp()
	{	
		Response response = getRequestResponse("planets/1/");	
		planet=response.body().as(Planet.class);
	}

	@Test
	public void planetIsTatooineTest()
	{
		Assert.assertEquals("Tatooine", planet.name);
	}
	
	@Test
	public void diameterIsLessThan20000Test()
	{
		Assert.assertTrue(planet.diameter<20000);
	}
	
	@Test
	public void gravityIsStandardTest()
	{
		Assert.assertEquals("1 standard", planet.gravity);
	}	
	
	//"terrain":, 
	@Test
	public void terrainIsDesertTest()
	{
		Assert.assertEquals( "desert", planet.terrain);
	}}