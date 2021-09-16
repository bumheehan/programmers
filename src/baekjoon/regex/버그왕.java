package baekjoon.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class 버그왕 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        Pattern pa = Pattern.compile(".*BUG.*");
        while ((line = br.readLine()) != null) {
            String bugLine = line;
            while (pa.matcher(bugLine).matches()) {
                bugLine = bugLine.replace("BUG", "");
            }
            System.out.println(bugLine);
        }

    }
}
