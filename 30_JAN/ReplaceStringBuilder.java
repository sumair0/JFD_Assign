class ReplaceStringBuilder{

	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("Hello") ;

		str.replace(0,str.length(),"World") ;

		System.out.println(str) ;

	}

}