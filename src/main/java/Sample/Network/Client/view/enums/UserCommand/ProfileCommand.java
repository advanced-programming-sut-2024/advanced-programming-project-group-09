package Sample.Network.Client.view.enums.UserCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileCommand {
    CHANGE_USERNAME("^\\s*profile\\s+change\\s+-u\\s+(?<newUsername>.+)\\s*$"),
    CHANGE_NICKNAME("^\\s*profile\\s+change\\s+-n\\s+(?<newNickname>.+)\\s*$"),
    CHANGE_PASSWORD("^\\s*profile\\s+change\\s+password\\s+(-o (?<oldPass>\\S+)\\s*|-n (?<newPass>.+)\\s*)*$"),
    CHANGE_EMAIL("^\\s*profile\\s+change\\s+-e\\s+(?<email>.+)\\s*$"),
    CHANGE_SLOGAN("^\\s*profile\\s+change\\s+slogan\\s+-s\\s+(?<slogan>.+)\\s*$"),
    DISPLAY_HIGHSCORE("\\s*profile\\s+display\\s+highscore\\s*"),
    DISPLAY_RANK("\\s*profile\\s+display\\s+rank\\s*"),
    DISPLAY_SLOGAN("\\s*profile\\s+display\\s+slogan\\s*"),
    REMOVE_SLOGAN("\\s*profile\\s+remove\\s+slogan\\s*"),
    PROFILE_INFO("^\\s*profile\\s+display\\s*$"),
    BACK("\\s*back\\s*");
    private final String regex;

    ProfileCommand(String regex) {
        this.regex = regex;
    }

    public static ProfileCommand getCommand(String input) {
        for (ProfileCommand cmd : ProfileCommand.values()) {
            if (input.matches(cmd.regex)) return cmd;
        }
        return null;
    }

    public static Matcher getMatcher(String input, ProfileCommand cmd) {
        Pattern pattern = Pattern.compile(cmd.regex);
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        return matcher;
    }
}
