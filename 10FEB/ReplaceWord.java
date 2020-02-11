import java.io.* ;
import java.util.* ;


class ReplaceWord{
  
    public static void main(String[] args) throws java.lang.Exception {
        
        Scanner s = new Scanner(System.in);

        String originalFilePath = "Count.txt";
        
        String originalFileContent = "";
        
        BufferedReader reader = null;
        
        BufferedWriter writer = null;
        

        System.out.println("Please enter two Lines");

        String str1  = s.nextLine();
        String str2  = s.nextLine();

        
        try {
            
            reader = new BufferedReader(new FileReader(originalFilePath));
            
            String currentLine = reader.readLine();
        
            while (currentLine != null) {
                originalFileContent += currentLine + System.lineSeparator();
                currentLine = reader.readLine();
            }
            
            String modifiedFileContent = originalFileContent.replaceAll( str1 , str2 );
            
            writer = new BufferedWriter(new FileWriter(originalFilePath));
            
            writer.write(modifiedFileContent);

        } catch (IOException e) {
            
        } finally {
            
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("");
            }
        }
    }
}