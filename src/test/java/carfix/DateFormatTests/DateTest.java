package carfix.DateFormatTests;

import Visitor_Pattern.Visit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class DateTest {

    private static final Logger LOGGER = LogManager.getLogger(DateTest.class);

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"2020-09-22", "2020.09.22", "09/22/2020", "22.09.2020", "22.09.2020"})
    public void dateFormatTest(final String dateString) {

        try {
            final java.sql.Date dateSQL = Date.valueOf(dateString);

            assertNotNull(dateSQL);

            System.out.println("Correct format of Date -> " + Date.valueOf(dateString));

        } catch (Exception exception) {
            if (exception instanceof IllegalArgumentException) {
                LOGGER.warn(exception);
            } else {
                fail(exception);
            }
        }
    }
}
