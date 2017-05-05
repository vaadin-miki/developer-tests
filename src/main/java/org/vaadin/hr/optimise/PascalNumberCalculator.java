package org.vaadin.hr.optimise;

/**
 * Calculates numbers for pascal's triangle.
 *
 * @author miki
 * @since 2017-05-04
 */
public class PascalNumberCalculator {

    private LongSummator summator = new LongSummator();

    public long getNumber(int row, int offset) {
        if(offset <= 0 || offset == row)
            return 1;
        else
            return summator.aggregate(getNumber(row - 1, offset - 1), getNumber(row - 1, offset));
    }

    public long[] getRow(int index) {
        if(index < 0)
            return new long[0];

        long[] result = new long[index+1];
        for(int offset=0; offset<=index; offset++)
            result[offset] = getNumber(index, offset);

        return result;
    }

}
