import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class SpeciesEndpointTest extends BaseTest{ 
private static Species specie = new Species();
	
	@BeforeClass
	public static void setUp()
	{			
		Response response = getRequestResponse("species/7/");
		specie.name=response.path("name");
		specie.filmCount=response.path("films.size()");
		specie.classification=response.path("classification");
		specie.designation=response.path("designation");
		specie.language=response.path("language");
		specie.homeworld=response.path("homeworld");
	}
		
	@Test
	public void theLordVadertest()
	{
		Assert.assertEquals("Trandoshan",specie.name);
	}

	@Test
	public void lessThan3FilmsExpectFailTest()
	{
		Assert.assertFalse(specie.filmCount>=3);
	}
	
	@Test
	public void languageOfSpecieTest()
	{
		Assert.assertEquals("Dosh",specie.language);
	}
	
	
	@Test
	public void designationOfSpecieTest()
	{
		Assert.assertEquals("sentient",specie.designation);
	}
	
	@Test
	public void classificationOfSpecieTest()
	{
		Assert.assertEquals("reptile",specie.classification);
	}
	
	
	@Test
	public void specieHomeWorldPageExpectFailTest()
	{
		Assert.assertNotEquals("https://swapi.dev/api/planets/2/",specie.homeworld);
	}
}