import java.util.regex.Pattern;

public class Dubstep {
    public static String SongDecoder(String song) {
        return song.replace("WUB", " ").trim().replaceFirst("\\s{2,}", " ");
    }
}