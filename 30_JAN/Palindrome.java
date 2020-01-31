import java.util.Scanner ;


class Palindrome{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in) ;

		System.out.println("Please enter a string") ;

		StringBuilder str = new StringBuilder(scan.nextLine()) ;

		StringBuilder strRev = new StringBuilder(str.reverse().toString()) ;


		System.out.println("Reverse String: " + strRev) ;
		System.out.println("Inserted String: " + str.reverse()) ;



		if( strRev.toString().equals(str.toString()) ){
			System.out.println("It's a Palindrome") ;
		}
		else{
			System.out.println("Not a Palindrome") ;
		}


	}
}