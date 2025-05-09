public class NameFormatter {
    private NameFormatter() {
    }


    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {
        String fullName = "";
        if (prefix != null && !prefix.isEmpty()) {
            fullName += prefix + ". ";
        }
        if (firstName != null && !firstName.isEmpty()) {
            fullName += firstName + " ";
        }
        if (middleName != null && !middleName.isEmpty()) {
            fullName += middleName + ", ";
        }
        if (lastName != null && !lastName.isEmpty()) {
            fullName += lastName + ", ";
        }
        if (suffix != null && !suffix.isEmpty()) {
            fullName += suffix;
        }
        return fullName;

    }
}
