class ThreeNumbers{
	public static void main(String[] args) {
		 
		 int num1 = Integer.parseInt(args[0]) ;
		 int num2 = Integer.parseInt(args[1]) ;
		 int num3 = Integer.parseInt(args[2]) ;


		 int sum = num1 + num2 + num3 ;

		 int greater = 40 ;

		 if( (num1 >= 40 && num2 >= 40 && num3 >= 40) && sum >= 125 ){
		 	System.out.println("PASSING") ;
		 }
		 else{
		 	System.out.println("FAILING") ;
		 }
	}
}