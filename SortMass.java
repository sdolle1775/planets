/**
 * SortMass- comparator for planet mass
 * CMSY167 Spring 2023
 * @author Samuel Dolle
 * @version 1.0
 *
 */
package planets;

import java.util.Comparator;

public class SortMass implements Comparator<Planet> { //compare objects by mass value
    public int compare(Planet o1, Planet o2) {

        return (int) (o2.getMass() - o1.getMass()); //convert double to int
    }
}
