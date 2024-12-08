package adv2.charactorSet;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMainV1 {
    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset ms949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");

        encoding("A", US_ASCII);
        encoding("A", EUC_KR);
        encoding("A", ms949);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE);
        encoding("가", US_ASCII);
        encoding("가", EUC_KR);
        encoding("가", ms949);
        encoding("가", UTF_8);
        encoding("가", UTF_16BE);
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
