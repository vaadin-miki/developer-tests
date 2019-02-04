package org.vaadin.miki.hr.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Basic calculator test.
 * @author miki
 * @since 2019-01-30
 */
public class CalculatorTest {

    // TODO next-level: once level 1 is complete, increase this to test the additional requirements
    private static final int LEVEL = 1;

    // *** DO NOT MODIFY THIS FILE UNLESS INSTRUCTED *** //

    private static final Map<String, Long> VALID_DATA = new LinkedHashMap<>();
    private static final Collection<String> INVALID_INPUT = new ArrayList<>();

    private Calculator calculator;

    /**
     * Helper method that reads a file.
     * @param fileName Name of the file.
     * @return A file read.
     */
    private static File getFile(String fileName) {
        File file;
        try {
            file = new File(Objects.requireNonNull(CalculatorTest.class.getClassLoader().getResource(fileName)).getFile());
        }
        catch(NullPointerException npe) {
            // if you imported this project as a Java project (not maven), the line above will fail
            // and you will end up in this place
            // please provide an absolute path to [valid_data_1.csv] so that everything works fine

            // and of course comment out the exception in the line below:
            throw new IllegalArgumentException(String.format("cannot load the resource file [%s] (is project imported as Maven?) - please supply direct path to the file", fileName));

            // and uncomment the following line:
            // file = new File("replace/this/with/a/direct/path/to/src/main/resources/"+fileName);
        }
        return file;
    }

    @BeforeClass
    public static void prepareData() throws IOException {
        File file = getFile(String.format("valid_data_%d.csv", LEVEL));
        // file is loaded, populate the valid data map
        Files.lines(file.toPath()).forEach(line -> {
            String[] parts = line.trim().split(",");
            VALID_DATA.put(parts[0], Long.valueOf(parts[1]));
        });
        file = getFile(String.format("invalid_data_%d.txt", LEVEL));
        Files.lines(file.toPath()).map(String::trim).forEach(INVALID_INPUT::add);
    }

    @Before
    public void setUp() {
        this.calculator = CalculatorProvider.getCalculator();
    }

    @Test
    public void testValidData() {
        VALID_DATA.forEach(this::checkReferenceOperation);
    }

    @Test
    public void testInvalidData() {
        Assert.assertTrue(INVALID_INPUT.stream().allMatch(this::checkInvalidOperation));
    }

    private boolean checkInvalidOperation(String input) {
        try {
            long result = this.calculator.calculate(input);
            Assert.fail(String.format("operation %s resulted in %d, but should fail instead", input, result));
            return false;
        }
        catch(IllegalArgumentException iae) {
            // that is correct behaviour! calculator should throw an exception here
            return true;
        }
    }

    private void checkReferenceOperation(String input, Long expected) {
        long result = this.calculator.calculate(input);
        Assert.assertEquals(String.format("operation %s failed", input), expected.longValue(), result);
    }

}