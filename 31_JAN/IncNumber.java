import java.util.Scanner ;

class IncNumber{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in) ;

		System.out.println("Please enter a number") ;

		String n = scan.nextLine() ;

		// String n = "1234" ;

		System.out.println(checkNumber(n)) ;

	}

	static boolean checkNumber(String number){

		boolean result = true ;

		for( int i = 1 ; i < number.length() ; i++ ){

			if( Integer.parseInt(number.substring(i,i+1)) > Integer.parseInt(number.substring(i - 1,i)) ){
				continue;
			}
			else{
				result = false ;
			}
		}

		return result ;
	}
}