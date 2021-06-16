package famous;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import famous.service.FamousFinder;
import famous.service.FamousFinderImpl;
import famous.service.model.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for Famous finder App
 */
public class FamousFinderTest
{
    /**
     * Find success case
     */
    @Test
    public void findOneFamousTest()
    {
        Map<String, Person[]> people = new HashMap<>();

        // Three of four people known Emma Watson
        people.put("Brandon", new Person[]{new Person("Peter"), new Person("Joel"),  new Person("Emma Watson")});
        people.put("Peter", new Person[]{new Person("Emma Watson")});
        people.put("Joel", new Person[]{new Person("Emma Watson"), new Person("Brandon")});
        people.put("Emma Watson", new Person[]{});
        FamousFinder finder = new FamousFinderImpl();

        List<String> result = finder.findFamous(people);
        assertTrue("One famous found", result.size() == 1);
        assertTrue("Emma Watson found", result.contains("Emma Watson"));
    }

    /**
     * Find no famous success case
     */
    @Test
    public void findNoFamousTest()
    {
        Map<String, Person[]> people = new HashMap<>();

        // only two people know Emma Watson
        people.put("Brandon", new Person[]{new Person("Peter"), new Person("Joel")});
        people.put("Peter", new Person[]{new Person("Emma Watson")});
        people.put("Joel", new Person[]{new Person("Emma Watson"), new Person("Brandon")});
        people.put("Emma Watson", new Person[]{});

        FamousFinder finder = new FamousFinderImpl();


        List<String> result = finder.findFamous(people);
        assertTrue("One famous found", result.size() == 0);
    }

    /**
     * Find two famous success case
     */
    @Test
    public void findTwoFamousTest()
    {
        Map<String, Person[]> people = new HashMap<>();

        // There are two famous known by four people
        people.put("Brandon", new Person[]{new Person("Keanu Reeves"), new Person("Peter"), new Person("Joel")});
        people.put("Brandon", new Person[]{new Person("Peter"), new Person("Keanu Reeves"), new Person("Joel"), new Person("Emma Watson")});
        people.put("Peter", new Person[]{new Person("Keanu Reeves"), new Person("Emma Watson")});
        people.put("Joel", new Person[]{new Person("Emma Watson"), new Person("Brandon"), new Person("Keanu Reeves")});
        people.put("Emma Watson", new Person[]{new Person("Keanu Reeves")});
        people.put("Keanu Reeves",  new Person[]{new Person("Emma Watson")});

        FamousFinder finder = new FamousFinderImpl();

        List<String> result = finder.findFamous(people);
        assertTrue("Two famous found", result.size() == 2);
        assertTrue("Emma Watson found", result.contains("Emma Watson"));
        assertTrue("Keanu Reeves found", result.contains("Keanu Reeves"));
    }

    /**
     * Find over empty people list
     */
    @Test
    public void findOverEmptyListTest()
    {
        Map<String, Person[]> people = new HashMap<>();

        FamousFinder finder = new FamousFinderImpl();

        List<String> result = finder.findFamous(people);
        assertTrue("Two famous found", result.size() == 0);
    }
}
