public class Enc {
    static char[] charsToSlash = {'\\','1','2','3', '4','5','6','7','8','9','0' };
    public static void main(String[] args) {
        String strToEncode1 = "AAAaaBbbD\\12";

        System.out.println(strToEncode1);

        System.out.println(getEncodedString(strToEncode1));

    }

    public static String getEncodedString(String strToEncode) {
        if (strToEncode == null || strToEncode.isEmpty()) return strToEncode;
        StringBuilder result = new StringBuilder();
        char[] chars = strToEncode.toCharArray();

        for (int i = 0; i < strToEncode.length(); i+=2) {
            int charCount = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                charCount++;
                i++;
            }
            result.append(charCount).append(addSlash(chars[i]));
        }
        return result.toString();
    }

    private static String addSlash( char charToSlash){
        StringBuilder result = new StringBuilder();
        for (char c: charsToSlash){
            if (c == charToSlash){
                result.append('\\');
            }
        }
        return result.append(charToSlash).toString();
    }
}


