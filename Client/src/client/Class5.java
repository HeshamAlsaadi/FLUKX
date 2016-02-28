package client;

import java.util.Scanner;
import java.io.*;
import java.nio.channels.*;
  
  
public class Class5{
 
 
public static void main (String args[]){
int count=0, tot = 0;
String result=null;
try{
//read large text file
File file = new File(".db file here");
FileInputStream fis = new FileInputStream(file);
FileChannel fc = fis.getChannel();
 
Scanner scan = new Scanner(fc);
while(scan.hasNext()){
                        scan.next();  
result = scan.findWithinHorizon("404",0);
if(result!=null) tot++;
count++;
}
scan.close();
fc.close();
fis.close();
 
System.out.println("Results found: " +tot+" in "+count+" words ");
}
catch(Exception e){
System.err.println(e.getMessage());
}
}
}