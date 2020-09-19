package carfix.datetime.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;   // Jupiper == JUnit5
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class DateTimeFormatTest {

    private static final Logger LOGGER = LogManager.getLogger(DateTimeFormatTest.class);

    @Order(1)
    @ParameterizedTest
    // Date format choice
    @ValueSource( strings = { "2020-09-19", "2020-10-23", "2020.10.23", "09/12/2020", "09.12.2020" } )
    public void dateFormatTests(final String date) {

        try {
            final java.sql.Date dateToSet = Date.valueOf(date);
            assertNotNull(dateToSet);

            System.out.println( "Correct form of Date:" + Date.valueOf( date ) );

        } catch ( Exception e ) {

            if ( e instanceof IllegalArgumentException ) {
                LOGGER.warn(e);
            } else  {
                fail( e );
            }
        }
    }


    @Order(1)
    @ParameterizedTest
    // Date format choice
    @ValueSource( strings = { "2020-09-19", "2020-10-23", "2020.10.23", "09/12/2020", "09.12.2020" } )
    public void datetimeFormatTests(final String date) {

        try {
            final java.sql.Date dateToSet = Date.valueOf(date);
            assertNotNull(dateToSet);

            System.out.println( "Correct form of Date:" + Date.valueOf( date ) );

        } catch ( Exception e ) {

            if ( e instanceof IllegalArgumentException ) {
                LOGGER.warn(e);
            } else  {
                fail( e );
            }
        }
    }


    // TODO: TEST the same in DAO
}
