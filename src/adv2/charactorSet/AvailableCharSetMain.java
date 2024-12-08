package adv2.charactorSet;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class AvailableCharSetMain {
    public static void main(String[] args) {
        // 자바 + 운영체제 제공하는 char Set
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        System.out.println("charsets = " + charsets);

        System.out.println(" ========= ");
        Charset ms949 = Charset.forName("MS949");
        System.out.println("ms949 = " + ms949);

        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);

    }
}
