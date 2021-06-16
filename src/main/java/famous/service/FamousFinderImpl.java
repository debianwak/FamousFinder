package famous.service;

import famous.service.model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Implement famous finder algorithm
 * */
public class FamousFinderImpl implements  FamousFinder {
    @Override
    public List<String> findFamous(Map<String, Person[]> persons) {
        Map<String, Integer> ratingCounts = new HashMap<>();

        // for each people in map
        for (Map.Entry<String, Person[]> person: persons.entrySet()) {
            Person []knownPeople =  person.getValue();
                for (int i = 0; i < knownPeople.length; i++) {
                    // count known people
                    ratingCounts.put(knownPeople[i].getName(),
                            ratingCounts.getOrDefault(knownPeople[i].getName(), 0) + 1);
                }
        }
        /* filter result list */
        return ratingCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == persons.size() - 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
