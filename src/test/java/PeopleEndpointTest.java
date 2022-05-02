import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class PeopleEndpointTest extends BaseTest{ 
private static People people = new People();
	
	@BeforeClass
	public static void setUp()
	{			
		Response response = getRequestResponse("people/4/");
		people.name=response.path("name");
		people.filmCount=response.path("films.size()");
		people.gender=response.path("gender");
		people.homeworld=response.path("homeworld");
		people.eye_color=response.path("eye_color");
		
	}
		
	@Test
	public void theLordVadertest()
	{
		Assert.assertEquals("Darth Vader",people.name);
	}

	@Test
	public void MoreThan1FilmsTest()
	{
		Assert.assertTrue(people.filmCount>=1);
	}
	
	@Test
	public void theEyesColortest()
	{
		Assert.assertEquals("yellow",people.eye_color);
	}
	@Test
	public void theHomeWorldPagetest()
	{
		Assert.assertEquals("https://swapi.dev/api/planets/1/",people.homeworld);
	}
}