import java.util.Scanner ;

class FindChar{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in) ;

		System.out.println("Please enter a string") ;

		String str = scan.nextLine() ;

		System.out.println("Please enter a Character to be found ") ;

		char c = scan.next().charAt(0) ;

		for( int i = 0 ; i < str.length() ; i++ ){
			if ( c == str.charAt(i)){
				System.out.println("Char Found") ;
			}

		}



	}

}