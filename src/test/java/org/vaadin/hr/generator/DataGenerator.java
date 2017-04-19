package org.vaadin.hr.generator;

import org.vaadin.hr.data.Country;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Generates test data.
 * No need to run this.
 * @author miki
 * @since 2017-04-19
 * @deprecated Do not use this file.
 */
@Deprecated
public class DataGenerator {

    private static final String[] FIRST_NAME = new String[] { "Mable", "Tanya", "Russ", "Lorraine", "Delicia", "Jon",
        "Larisa", "Suzi", "Lorelei", "Callie", "Laila", "Bernard", "Meagan", "Antione", "Justine", "Justina", "Olin",
        "Chaya", "Louie", "Krystina", "Hyo", "Ardella", "Lynwood", "Bruna", "Romeo", "Elina", "Daryl", "Treva",
        "Edison", "Sanjuana", "Doreen", "Tynisha", "Neal", "Gretchen", "Sherley", "Reginald", "Sharice", "Marybelle",
        "Lennie", "Allison", "Audria", "Winnifred", "Bee", "Georgia", "Juliane", "Collen", "Donnell", "Fermina", "Otis",
        "Nicholas" };
    private static final String[] LAST_NAME = new String[] { "Leach", "Clarke", "Russo", "Frost", "Nicholson",
        "Mckinney", "Armstrong", "Stephenson", "Mann", "Conner", "Harrison", "Hernandez", "Kidd", "Flowers", "Savage",
        "Bush", "Bradshaw", "Carroll", "Wyatt", "York", "Barrett", "Blackburn", "Scott", "Krause", "Walton", "Dodson",
        "Choi", "Padilla", "Gregory", "Miller", "Shea", "Casey", "Mcintosh", "Lowe", "Ellis", "Gross", "Crawford",
        "Mueller", "Mckenzie", "Cooley", "Pineda", "Hoffman", "Moses", "Garner", "Goodman", "Hull", "Munoz", "Holder",
        "Whitehead", "Stewart" };

    public static void main(String[] args) {
        Random random = new Random(20170419);

        for(String firstName: FIRST_NAME) {
            for(Integer lastNameIndex: randomInts(10, LAST_NAME.length, random))
                System.out.println(String.format("%s,%s,%s,%s", firstName, LAST_NAME[lastNameIndex], getRandom(random), random.nextInt(40)+18));
        }
    }

    private static Collection<Integer> randomInts(int count, int range, Random random) {
        Set<Integer> integers = new HashSet<Integer>();
        while(integers.size() < count)
            integers.add(random.nextInt(range));
        return integers;
    }

    /**
     * Picks a random country, based on the given rng.
     * @param random RNG to use.
     * @return A country.
     */
    private static Country getRandom(Random random) {
        return Country.values()[random.nextInt(Country.values().length)];
    }


}
