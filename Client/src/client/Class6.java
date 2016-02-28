package client;

import java.io.*;
import java.util.regex.*;
public class Class6 {
    public static void main(String[] args) {
        String input = "matchingpatterns";
        try {
            FileInputStream fstream = new FileInputStream(" db or txt goes here");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (Pattern.matches(input, strLine)) {
                    Pattern p = Pattern.compile("(?m)^\\s*([^\\(]+)\\([^\\)][^\\)]*\\)");
                    Matcher m = p.matcher(strLine);
                    while (m.find()) {
                        String b = m.group(1);
                        String c = b.toString() + ".*";
                        System.out.println(b);

                        if (Pattern.matches(c, strLine)) {
                            Pattern pat = Pattern.compile("(?m)^\\s*([^\\(]+)\\([^\\)][^\\)]*\\)");
                            Matcher mat = pat.matcher(strLine);
                            while (mat.find()) {
                                System.out.println(m.group(1));

                            }
                        } else {
                            System.out.println("Not found");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}