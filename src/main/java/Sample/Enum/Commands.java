package Sample.Enum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    UserName("[a-zA-Z0-9-]{3,20}"),
    Password("(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&])(?=.*\\d).{8,}"),
    Nickname("[a-zA-Z0-9-]{3,20}"),
    EMAIL("^[^\\.\\s][\\w\\-]+(\\.[\\w\\-]+)*@([\\w-]+\\.)+[\\w-]{2,}$"),
    ;
    private final String pattern;
    Commands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
