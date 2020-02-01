import java.util.Scanner ;
import java.util.StringTokenizer ;


class SumIntegers{

		//final static String DELIMITER = " " ;

		public static void main(String[] args) {

			Scanner scan = new Scanner(System.in) ;

			System.out.println("Please enter a stream of numbers separated with spaces...") ;

			String str = scan.nextLine() ;

			StringTokenizer tokenSequence = new StringTokenizer(str) ;

			System.out.println("You have entered") ;

			int sum = 0 , temp = 0 ;

			for( ; tokenSequence.hasMoreTokens(); ){
				
				temp = Integer.parseInt(tokenSequence.nextToken()) ;

				System.out.println(temp);

				sum +=  temp;
			}




			System.out.println("Sum of the numbers you entered was : " + sum ) ;



		 	
		 } 
}