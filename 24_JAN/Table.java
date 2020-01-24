class Table{
	public static void main(String[] args) {
		
		int tableOf = Integer.parseInt(args[0]) ;
		int limit = Integer.parseInt(args[1]) ;

		int incremeter = 1 ;

		for( int i = tableOf ; i < limit ; i += tableOf){
			System.out.println(tableOf + " * " + (incremeter++) + " = " + i) ;
		}

	}
}