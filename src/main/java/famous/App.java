package famous;

import famous.service.FamousFinder;
import famous.service.FamousFinderImpl;
import famous.service.model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Famous finder App
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Building list of people...");

        Map<String, Person[]> people = new HashMap<>();

        // Create a list where three of four people known Emma Watson
        people.put("Brandon", new Person[]{new Person("Peter"), new Person("Joel"),  new Person("Emma Watson")});
        people.put("Peter", new Person[]{new Person("Emma Watson")});
        people.put("Joel", new Person[]{new Person("Emma Watson"), new Person("Brandon")});
        people.put("Emma Watson", new Person[]{});
        FamousFinder finder = new FamousFinderImpl();

        List<String> result = finder.findFamous(people);
        System.out.println("Famous People found " + result.size());
        result.forEach(name -> System.out.println(name));

    }
}
