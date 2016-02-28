package client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Class1 {

public static void main(String[] args)
{
    double count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    String filePath = ".TXT";
    BufferedReader br;
    String inputSearch = " GET ";
    String line = "";

    try {
        br = new BufferedReader(new FileReader(filePath));
        try {
            while((line = br.readLine()) != null)
            {
                countLine++;
                //System.out.println(line);
                String[] words = line.split(" GET ");

                for (String word : words) {
                  if (word.equals(inputSearch)) {
                    count++;
                    countBuffer++;
                  }
                }

                if(countBuffer > 0)
                {
                    countBuffer = 0;
                    lineNumber += countLine + ",";
                }

            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Times found at--"+count);
    System.out.println("Word found at--"+lineNumber);
}
}