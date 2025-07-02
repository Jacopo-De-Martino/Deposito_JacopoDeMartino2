public class StringValidator {
    public static void check(String s) throws Exception {
        if (s.length() < 8) {
            throw new TooShortStringException("Stringa troppo corta " + s.length(), null);
        }
    }
}
