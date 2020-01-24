class DecToBinary{
	public static void main(String[] args) {
		
		int number = Integer.parseInt(args[0]) ;

		for( int i = 31 ; i >= 0 ; i--){
			if(((number & (1 << i)) != 0)){
				System.out.print("1") ;
			}
			else{
				if( number >= (1 << i) )
					System.out.print("0") ;
			}

			
		}
	}
}