package famous.service;

import famous.service.model.Person;

import java.util.List;
import java.util.Map;

/**
 * FamousFinder.
 * Define a method to get a list of most known people by everyone of the list
 * */
public interface FamousFinder {

    List<String> findFamous(Map<String, Person[]> persons);
}
