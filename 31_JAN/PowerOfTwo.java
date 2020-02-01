// Exercise 12

import java.util.Scanner ;


class PowerOfTwo{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in) ;

		System.out.println("Please enter a number") ;

		int n = scan.nextInt() ;

		// int n = 4 ;

		System.out.println(checkNumber(n)) ;

		
	}

	static boolean checkNumber(int n){
		 boolean result = false ;

		 if( (n & (n - 1)) == 0 ){
		 	result = true ;
		 }
		 else{
		 	result = false ;
		 }

		 return result ;
	}

}