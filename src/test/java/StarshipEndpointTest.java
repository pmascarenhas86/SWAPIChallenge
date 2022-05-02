import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class StarshipEndpointTest extends BaseTest{ 
	private static Starship ship = new Starship();
	
	@BeforeClass
	public static void setUp()
	{			
		Response response = getRequestResponse("starships/9/");
		ship.name=response.path("name");
		ship.filmCount=response.path("films.size()");
		ship.starship_class=response.path("starship_class");
		ship.model=response.path("model");
	}
		
	@Test
	public void whatIsTheBestStarWarsShip()
	{
		Assert.assertEquals("Death Star",ship.name);
	}

	@Test
	public void shipWereIn1FilmTest()
	{
		Assert.assertTrue(ship.filmCount<=1);
	}
	
	@Test
	public void shipClass()
	{
		Assert.assertEquals("Deep Space Mobile Battlestation",ship.starship_class);
	}
	
	@Test
	public void shipModel()
	{
		Assert.assertEquals("DS-1 Orbital Battle Station",ship.model);
	}
}
	
	