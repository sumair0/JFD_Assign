import java.io.* ;
import java.util.Scanner ;





class Details{
	
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		String string = input.nextLine();
		
		File file = new File(string);	
		
		System.out.println("Name:" + file.getName());
		
		System.out.println("Path:" + file.getPath());
				
		System.out.println("Eligible file:" + file.isFile());
		
		System.out.println("Readable:" + file.canRead());
		
		System.out.println("Writable:" + file.canWrite());
		
		System.out.println("Size:" + file.length() + "bytes");
		
	}
}