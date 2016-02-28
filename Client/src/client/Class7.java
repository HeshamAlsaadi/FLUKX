package client;

import java.io.*;

public class Class7 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("urlscan.07.log");
        BufferedReader br = new BufferedReader(fr);
        String buffer;
        String fulltext="";
        while ((buffer = br.readLine()) != null) {
            System.out.println(buffer);
            fulltext += buffer;
        }
        br.close();
        fr.close();
    }
}