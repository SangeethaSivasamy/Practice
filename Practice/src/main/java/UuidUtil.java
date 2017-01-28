import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author sparida
 *
 */
public class UuidUtil {

// class variables =============================================================
/** UUID pattern */  
public static final String UUID_PATTERN = "\\{?\\p{XDigit}{8}-\\p{XDigit}" +
  "{4}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{12}\\}?";
// instance variables ==========================================================

// constructors ================================================================
/** Default constructor. */
private UuidUtil() {}

// properties ==================================================================

// methods =====================================================================

/**
 * Adds curly braces {} to a uuid.
 * @param uuid the uuid to modify
 * @return the modified uuid
 */
public static String addCurlies(String uuid) {
  uuid = Val.chkStr(uuid);
  if (uuid.length() == 36) {
    if (!uuid.startsWith("{")) uuid = "{"+uuid;
    if (!uuid.endsWith("}"))   uuid = uuid+"}";
  }
  return uuid;
}

/**
 * Determines if a string is a uuid.
 * @param uuid the uuid to check
 * @return true if the string is a uuid
 */
public static boolean isUuid(String uuid) {
  boolean bIsUuid = false;
  uuid = removeCurlies(uuid);
  if (uuid.length() == 36) {
    String[] aParts = uuid.split("-");
    if (aParts.length == 5) {
      if ((aParts[0].length() == 8) && (aParts[1].length() == 4) &&
          (aParts[2].length() == 4) && (aParts[3].length() == 4) &&
          (aParts[4].length() == 12)) {
        bIsUuid = true;
      }
    }
  }
  return bIsUuid;
}

/**
 * Makes a new uuid (no braces).
 * @return the new uuid
 */
public static String makeUuid() {
  return makeUuid(false);
}

/**
 * Makes a new uuid.
 * @param withCurlies if true, add curly braces {}
 * @return the new uuid
 */
public static String makeUuid(boolean withCurlies) {
  String sUuid = UUID.randomUUID().toString().toUpperCase();
  if (withCurlies) {
    return addCurlies(sUuid);
  } else {
    return sUuid;
  }
}

/**
 * Removes curly braces {} from a uuid.
 * @param uuid the uuid to modify
 * @return the modified uuid
 */
public static String removeCurlies(String uuid) {
  uuid = Val.chkStr(uuid);
  if (uuid.length() > 0) {
    if (uuid.startsWith("{")) uuid = uuid.substring(1);
    if (uuid.endsWith("}"))   uuid = uuid.substring(0,uuid.length()-1);
  }
  return uuid;
}

/**
 * Creates regular expression pattern.
 * @return pattern
 */
public static Pattern createRegexPattern() {
  return Pattern.compile(UUID_PATTERN);
}

/**
 * Creates regular expression pattern.
 * @param flags 
 * (see: {@link java.util.regex.Pattern#compile(String regex, int flags)})
 * @return pattern
 */
public static Pattern createRegexPattern(int flags) {
  return Pattern.compile(UUID_PATTERN, flags);
}
}