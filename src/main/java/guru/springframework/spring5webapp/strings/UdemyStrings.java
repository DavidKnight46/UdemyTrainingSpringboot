package guru.springframework.spring5webapp.strings;

import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

public class UdemyStrings {
    public static void main(String[] args) {
        String s1 = new String("hello").intern();//add to string pool

        String s2 = "hello";//s1, s2 same reference in pool

        if(s1 == s2){
            out.println("True");
        }

        ///
        final byte[] bytes = "hello".getBytes();

        final String s = new String(bytes, 1, 3, StandardCharsets.UTF_8);

        out.println(s);

        int i = 0;
        int y = 10;
        int z = 11;

        out.println(i + y + "=" + y + z);
        out.println(i + y + "=" + (y + z));

    }
}
