package client;

import java.io.IOException;

// Import io so we can use file objects
import java.io.*;
 
public class Class3 {
    public static void main(String args[]) {
        try {
            // Open the file c:\test.txt as a buffered reader
            BufferedReader bf = new BufferedReader(new FileReader(" "));
             
            // Start a line count and declare a string to hold our current line.
            int linecount = 0;
                String line;
 
            // Let the user know what we are searching for
            System.out.println("Searching for " + args[0] + " in file...");
 
            // Loop through each line, stashing the line into our line variable.
            while (( line = bf.readLine()) != null)
            {
                    // Increment the count and find the index of the word
                    linecount++;
                    int indexfound = line.indexOf(args[0]);
 
                    // If greater than -1, means we found the word
                    if (indexfound > -1) {
                         System.out.println("Word was found at position " + indexfound + " on line " + linecount);
                    }
            }
 
            // Close the file after done searching
            bf.close();
        }
        catch (IOException e) {
            System.out.println("IO Error Occurred: " + e.toString());
        }
    }
}

