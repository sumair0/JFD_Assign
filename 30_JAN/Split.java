class Split{
	public static void main(String[] args) {

		String s = "Javaaaaa andaaa Cpp aaa php" ;
		String b = "aaa" ;

		String []strArr = new String[s.length()] ;

		strArr = tokenizer(s,b) ;

		for(String str : strArr){
			if( str.equals(null)){
				continue;
			}
			else{
				System.out.println(str) ;
			}
			// System.out.println(str) ;
		}
		
	}

	public static String[] tokenizer(String input , String breakstr) {

		String tempStr = new String() ;

		String []strArr = new String[input.length()] ;

		int currIndex = 0 ;

		for( int i = 0 ; i < input.length() - breakstr.length() + 1; i++ ){

			if( input.substring(i , i + breakstr.length() ).equals(breakstr) ){
				strArr[currIndex] = tempStr;
				tempStr = "" ;
				currIndex++ ;
				i += breakstr.length() - 1 ;
			}
			else{
				tempStr += input.substring(i , i + 1) ;
			}
			


		}	
			tempStr += input.substring( input.length() - breakstr.length() + 1 , input.length());
			strArr[currIndex] = tempStr;
			

		return strArr; 
	}
}