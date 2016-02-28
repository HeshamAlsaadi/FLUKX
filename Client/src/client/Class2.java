package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** JDK 7+. */
public final class Class2 {

  public void findBadLines(String aFileName) {

    Pattern regexp = Pattern.compile("");
    Matcher matcher = regexp.matcher("(?m)^\\s*([^\\(]+)\\([^\\)][^\\)]*\\)");

    Path path = Paths.get(aFileName);
    try (
      BufferedReader reader = Files.newBufferedReader(path, ENCODING);
      LineNumberReader lineReader = new LineNumberReader(reader);
    ){
      String line = null;
      while ((line = lineReader.readLine()) != null) {
        matcher.reset(line); //reset the input
        if (!matcher.find()) {
          String msg = "Line " + lineReader.getLineNumber() + " is bad: " + line;
          throw new IllegalStateException(msg);
        }
      }      
    }    
    catch (IOException ex){
      ex.printStackTrace();
    }
  }

  final static Charset ENCODING = StandardCharsets.UTF_8;
  
  /** Test harness. */
  public static void main(String... arguments) {
    Class2 Class2 = new Class2();
    Class2.findBadLines("url needed");
    System.out.println("Done.");
  }
}
