import java.io.*;
 
public class CountLines {
    
    public static void main(String[] args){
        BufferedReader br = null;
        int count = 1;
        Stextng strLine = "";
        
        try {

            br = new BufferedReader( new FileReader("anotherFile.txt"));

            while( (textLine = br.readLine()) != null){

                System.out.println(count +" "+ textLine);
                count++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
     }
}