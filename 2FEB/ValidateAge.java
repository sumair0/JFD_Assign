import java.util.Scanner ;

class ValidateAge{
	public static void main(String[] args) throws AgeInvalidException{
		
		Scanner scan = new Scanner(System.in) ;

		System.out.println("Please Enter your Age before proceeding...") ;

		int ageEntered = scan.nextInt() ;

		final int ALLOWED_AGE = 15 ;

		if ( ageEntered < ALLOWED_AGE ){
			throw new AgeInvalidException() ;
		}

		else{
			System.out.println("Access Granted") ;
		}
	}
}


class AgeInvalidException extends Exception{
	AgeInvalidException(){
		System.out.println("Access Denied") ;
	}
}