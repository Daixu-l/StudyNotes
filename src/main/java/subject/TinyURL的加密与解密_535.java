package subject;

import java.util.HashMap;

public class TinyURL的加密与解密_535 {

    HashMap<String,String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(Integer.toHexString(longUrl.hashCode()),longUrl);
        return Integer.toHexString(longUrl.hashCode());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
       return map.get(shortUrl);
    }
}
