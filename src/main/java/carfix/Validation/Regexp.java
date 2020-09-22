package carfix.Validation;

public class Regexp {

    public final static String EMAIL = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

    public final static String INVALID_EMAIL = "Invalid e-mail entered";


    public final static String PHONE_NUMBER = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$";

    public final static String INVALID_PHONE_NUMBER = "Invalid phone number enterred";


    public final static String NAME_LASTNAME = "\\S+";

    public final static String INVALID_NAME_LASTNAME = "Invalid name or last name entered";


    public final static String ID = "\\d+";

    public final static String INVALID_ID = "Invalid ID entered";

}
