package com.plazoleta.identity.infra.driving.in.util;

public class UserConstantsAdapter {

    private UserConstantsAdapter() {
        throw new IllegalStateException("Utility class");
    }

    public static final String DNI_REQUIRED = "DNI is required";
    public static final String DNI_NUMERIC = "DNI must be numeric";
    public static final String FIRST_NAME_REQUIRED = "First name is required";
    public static final String LAST_NAME_REQUIRED = "Last name is required";
    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String EMAIL_INVALID = "Invalid email format";
    public static final String PASSWORD_REQUIRED = "Password is required";
    public static final String PHONE_REQUIRED = "Phone number is required";
    public static final String PHONE_FORMAT = "Phone number must start with '+' and include country code (max 16 characters)";
    public static final String REGEX_NUMERIC = "\\d+";
    public static final String REGEX_PHONE = "\\+\\d{1,15}";
    public static final String DATE_PAST ="La fecha de nacimiento debe ser en el pasado.";

}
