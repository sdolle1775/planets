/**
 * PlanetsMain- sort and display planet facts
 * CMSY167 Spring 2023
 * @author Samuel Dolle
 * @version 1.0
 *
 */
package planets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Prints facts about planets - practice using Collections methods
 */
public class PlanetsMain {

    public static void main(String[] args) {

        // Source https://nssdc.gsfc.nasa.gov/planetary/factsheet/
        List<Planet> planets = new ArrayList<>(9);
        planets.add(new Planet("Mercury", 0.33, 58));
        planets.add(new Planet("Venus", 4.87, 108));
        planets.add(new Planet("Earth", 5.97, 150));
        planets.add(new Planet("Mars", .642, 228));
        planets.add(new Planet("Jupiter", 1898, 779));
        planets.add(new Planet("Saturn", 568, 1434));
        planets.add(new Planet("Uranus", 86.8, 2873));
        planets.add(new Planet("Neptune", 102, 4495));
        planets.add(new Planet("Pluto", 0.0146, 5906));

        System.out.println("Orignal order:");
        printPlanets(planets);

        // Randomize the order of the planets
        //Used shuffle method
        Collections.shuffle(planets);

        System.out.println("Planets in a random order:");
        printPlanets(planets);

        // Remove pluto
        //for loop to retrieve index of "Pluto Object"
        int i = 0;
        for (Planet planet : planets) {
            i++;
            if (planet.getName().contains("Pluto")) {
                break;
            }
        }
        planets.remove(i-1);


        System.out.println("Removed Pluto:");
        printPlanets(planets);

        // Sort by distance from sun using Natural Ordering (Hint: Implement Planet.compareTo)
        //Used separate Comparator class here, used Natural Ordering in next task
        Collections.sort(planets, new SortDistance());


        System.out.println("Sorted by distance from sun:");
        printPlanets(planets);

        // Sort alphabetically (Hint: you need a Comparator class)
        Collections.sort(planets);

        System.out.println("Sorted alphabetically:");
        printPlanets(planets);

        // Sort by mass (Hint: you need a Comparator class)
        Collections.sort(planets, new SortMass());

        System.out.println("Sorted by mass:");
        printPlanets(planets);

        // Add each planet in your list to a Map (name => Planet)
        Map<String, Planet> planetMap = new HashMap<>();
        //loop adding all objects in array to hashmap
        for (Planet planet : planets) {
            planetMap.put(planet.getName(), planet);
        }

        System.out.println("Earth:" + planetMap.get("Earth"));
        // Retrieve and print Mars
        planetMap.get("Mars");
        System.out.println(planetMap.get("Mars"));

    }

    /**
     * Print the planet list in a table
     */
    private static void printPlanets(List<Planet> planets) {

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-15s%-10s%n%n", "Planet", "Mass", "Distance");

        for (Planet planet : planets) {
            System.out.printf("%-10s%-15.3f%-10d%n", planet.getName(),
                    planet.getMass(), planet.getDistance());
        }

        System.out.println("------------------------------------------------------------\n\n");
    }

}



