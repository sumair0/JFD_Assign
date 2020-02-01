import java.util.Scanner ;

class NumberCheck{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in) ;

		System.out.println("Please enter a number") ;

		int n = scan.nextInt() ;

		// int n =  ;

		System.out.println(calculateDifference(n)) ;
		
	}

	static double calculateDifference(int n){

			return (( n * (n + 1))*( 2 + n - ( 3*n*n) ))/12 ;
	}

}