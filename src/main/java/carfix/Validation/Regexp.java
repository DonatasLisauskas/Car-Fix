package carfix.Validation;

public class Regexp {

    public final static String EMAIL = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    public final static String INVALID_EMAIL = "Invalid e-mail entered";


    public final static String PHONE_NUMBER = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$";
    public final static String INVALID_PHONE_NUMBER = "Invalid PHONE_NUMBER entered";


    public final static String NAME_LASTNAME = "\\S+";
    public final static String INVALID_NAME_LASTNAME = "Invalid NAME_LASTNAME entered";


    public final static String ID_OR_NUMBER = "\\d+";
    public final static String INVALID_ID_OR_NUMBER = "Invalid ID_OR_NUMBER entered";


    public final static String SERIES_NAME = "\\[A-Za-z0-9]+";
    public final static String INVALID_SERIES_NAME = "Invalid SERIES_NAME entered";


    public final static String MANUFACTURE_YEAR = "\\(1[8-9][0-9][0-9]).(0[1-9]|1[0-2])";
    public final static String INVALID_MANUFACTURE_YEAR = "Invalid MANUFACTURE_YEAR entered";


    public final static String ENGINE_DISPLACEMENT = "\\d.[0-9]";
    public final static String INVALID_ENGINE_DISPLACEMENT = "Invalid ENGINE_DISPLACEMENT entered";






}
