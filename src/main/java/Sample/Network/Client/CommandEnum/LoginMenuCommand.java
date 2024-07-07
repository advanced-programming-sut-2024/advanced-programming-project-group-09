package Sample.Network.Client.CommandEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuCommand {
    ;
    private final String pattern;

    LoginMenuCommand(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getCommandMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }
}
