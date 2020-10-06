package ua.com.javatraining;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenUtils {
    private static final Pattern TOKEN_PATTERN = Pattern
            .compile("(?<sso>[^;]+);(?<tenant>[^/]+)/((?<subTenant>[^/]+)(?:/))?(?<user>[^/]+)");
    public static final String SPECIAL_CHARACTERS = "~!@#$%^&*-=+;:,";

    public static boolean isValidUserToken(String encodedData) {
        String decodedToken = decodeToken(encodedData);
        return decodedToken.matches(TOKEN_PATTERN.pattern());
    }

    public static String extractSsoToken(String encodedData) {
        if (!isValidUserToken(encodedData)) {
            throw new RuntimeException("INVALID_TOKEN_MESSAGE");
        }
        String decodedToken = decodeToken(encodedData);
        Matcher tokenMatcher = TOKEN_PATTERN.matcher(decodedToken);
        if (tokenMatcher.find()) {
            return tokenMatcher.group("sso");
        }
        throw new RuntimeException("INVALID_TOKEN_MESSAGE");
    }

    private static String decodeToken(String encodedData) {
        if (StringUtils.isEmpty(encodedData)) {
            return "";
        }
        return new String(Base64.decodeBase64(encodedData));
    }

    public static String generatePassword() {
        final char[] chars = SPECIAL_CHARACTERS.toCharArray();
        String upperCaseLetters = RandomStringUtils.random(4, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(4, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(3);
        String specialChar = RandomStringUtils.random(3, 1, chars.length - 1, false, false, chars);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChar)
                .concat(totalChars);
        List<Character> characters = getShuffleCharacters(combinedChars);
        return getPasswordResult(characters);
    }

    private static String getPasswordResult(List<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character pwdChar : characters) {
            stringBuilder.append(pwdChar);
        }
        return stringBuilder.toString();
    }

    private static List<Character> getShuffleCharacters(String combinedChars) {
        List<Character> characters = new ArrayList<>();
        for (char character : combinedChars.toCharArray()) {
             characters.add(character);
        }
        Collections.shuffle(characters);
        return characters;
    }

    //    @Test
    /*public void testIsValidMappedTenant() {

        String decodedToken = "AQIC5wM2LY4Sfcy3KuV8rhV5O-CINjVfaW2-frZU3LfklxQ.*AAJTSQACMDEAAlNLABQtMTU4NDQ3MDY2MDIwOTAwMzgyNAACUzEAAA..*;TENANT_ID/SUBTENANT_ID/USER_ID";
        String encodedData = Base64.encodeBase64String(decodedToken.getBytes());
        boolean isValidMappedTenant = ImpersonationUtils.isImpersonatedUserToken(encodedData);
//        assertTrue(isValidMappedTenant);
    }*/

    //    @Test
    /*public void testGeneratePassword() {
        int iterationNumber = Integer.parseInt(RandomStringUtils.randomNumeric(4));
        for (int i = 0; i < iterationNumber; i++) {
            final String password = ImpersonationUtils.generatePassword();
            Pattern pattern = Pattern.compile(PASSWORD_REGEX);
            Matcher matcher = pattern.matcher(password);
//            Assert.assertTrue(matcher.matches());
        }
    }*/

    String decodedToken = "SSO_TOKEN;TENANT_ID/USER_ID";
    String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*-=+;:,]).{16})";

}
