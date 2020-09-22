package carfix.Validation;

public class Regexp {

    public final static String EMAIL = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

    public final static String INVALID_EMAIL = "Invalid e-mail entered";

    public final static String PHONE_NUMBER = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$";

    public final static String INVALID_PHONE_NUMBER = "Invalid phone number enterred";
}
