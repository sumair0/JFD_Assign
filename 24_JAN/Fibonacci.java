class Fibonacci{
	public static void main(String[] args) {
		
		int prev = 1 , curr = 1 ;

		System.out.println(prev);
		System.out.println(curr);


		while(curr < 89){

			curr = curr + prev ;
			prev = curr - prev ;
			System.out.println(curr);

		}

	}
}