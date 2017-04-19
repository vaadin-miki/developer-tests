package org.vaadin.hr.data;

import java.util.Random;

/**
 * Enum for various countries.
 * @author miki
 * @since 2017-04-19
 */
public enum Country {

    AUSTRIA, BELGIUM, BULGARIA, CROATIA, CYPRUS, CZECH_REPUBLIC, DENMARK,
    ESTONIA, FINLAND, FRANCE, GERMANY, GREECE, HUNGARY, IRELAND, ITALY,
    LATVIA, LITHUANIA, LUXEMBOURG, MALTA, NETHERLANDS, POLAND, PORTUGAL,
    ROMANIA, SLOVAKIA, SLOVENIA, SPAIN, SWEDEN, UNITED_KINGDOM,
    SAN_MARINO(false), ANDORRA(false), SWITZERLAND(false), LIECHTENSTEIN(false),
    NORWAY(false), RUSSIA(false), BELARUS(false), UKRAINE(false),
    BOSNIA_AND_HERZEGOVINA(false), ALBANIA(false), MACEDONIA(false),
    SERBIA(false), MONTENEGRO(false), MOLDOVA(false), ICELAND(false),
    ARMENIA(false), AZERBAIJAN(false), GEORGIA(false), KAZAKHSTAN(false),
    MONACO(false), VATICAN_CITY(false), TURKEY(false);

    private final boolean eu;

    Country() {
        this(true);
    }

    Country(boolean eu) {
        this.eu = eu;
    }

}
