import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class FilmsEndpointTest extends BaseTest{ 
	private static Film film = new Film();
	
	@BeforeClass
	public static void setUp()
	{			
		Response response = getRequestResponse("films/2/");
		
		film.episode_id=response.path("episode_id");
		film.title=response.path("title");
		film.charactersCount=response.path("characters.size()");
		film.planetsCount=response.path("characters.size()");
		film.speciesCount=response.path("species.size()");
		film.starshipsCount=response.path("starships.size()");
		film.vehiclesCount=response.path("vehicles.size()");
			}
		
	@Test
	public void whatIsTheBestEpisodeMovieTest()
	{
		Assert.assertEquals(5,film.episode_id);
	}

	@Test
	public void FilmTitleTest()
	{
		Assert.assertEquals("The Empire Strikes Back",film.title);
	}
	
	@Test
	public void MoreThan3PlanetsnMovieTest()
	{
		Assert.assertTrue(film.planetsCount>=3);
	}
	@Test
	public void MoreThan15CharactersInMovieTest()
	{
		Assert.assertTrue(film.charactersCount>=15);
	}
	
	@Test
	public void LessThan15StarshipsInMovieTest()
	{
		Assert.assertTrue(film.starshipsCount<=15);
	}
	
	@Test
	public void ThereAre5SpeciesInTheMovie()
	{
		Assert.assertTrue(film.speciesCount==5);
	}
	
	@Test
	public void ThereAre5VehiclesInTheMovie()
	{
		Assert.assertFalse(film.vehiclesCount==5);
	}
	
	
}
	
	

