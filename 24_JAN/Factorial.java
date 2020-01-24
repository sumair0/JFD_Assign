class Factorial{
	public static void main(String[] args) {
		
	

	int n = Integer.parseInt(args[0]) ;
	//int n = 4 ;

	for( int i = n - 1 ; i >= 1 ; i--){
		n = n * i ;
	}

	System.out.println(n) ;
}
}