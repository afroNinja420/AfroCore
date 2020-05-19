package me.afroninja.afrocore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.afroninja.afrocore.AfroCore;

public class RegexUtil {
    public static final Pattern PLAYER_COUNT_REGEX = Pattern.compile("(%player_count:((?:[a-z][a-z0-9_]*))%)", 34);

    public static int findPlayerCount(String data) {
        Matcher matcher = PLAYER_COUNT_REGEX.matcher(data);
        return matcher.find() ? AfroCore.getInstance().getOnlineCount(matcher.group(2)) : 0;
    }
}
