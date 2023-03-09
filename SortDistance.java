/**
 * SortDistance- comparator for planet distance
 * CMSY167 Spring 2023
 * @author Samuel Dolle
 * @version 1.0
 *
 */
package planets;

import java.util.Comparator;

public class SortDistance implements Comparator<Planet> //compare objects by distance value
{
    public int compare(Planet o1, Planet o2)
    {
        return o2.getDistance() - o1.getDistance();
    }
}
