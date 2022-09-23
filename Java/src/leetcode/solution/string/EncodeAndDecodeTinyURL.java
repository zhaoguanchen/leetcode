package leetcode.solution.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 */
public class EncodeAndDecodeTinyURL {


    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        EncodeAndDecodeTinyURL encodeAndDecodeTinyURL = new EncodeAndDecodeTinyURL();
        String ans1 = encodeAndDecodeTinyURL.encode(url);
        System.out.println(ans1);
        String ans2 = encodeAndDecodeTinyURL.decode(ans1);
        System.out.println(ans2);
    }


    Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
