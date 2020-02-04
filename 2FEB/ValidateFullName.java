import java.util.Scanner ;

class ValidateFullName {

	public static void main(String[] args) throws LastNameException,FirstNameException {

	  	Scanner scan = new Scanner(System.in) ;

		System.out.println("Please Enter your First Name") ;

		String firstName = scan.nextLine() ;

		System.out.println("Please Enter your Last Name") ;

		String lastName = scan.nextLine() ;

		Person human = new Person(firstName,lastName) ;

		human.display() ;
	}

}


class Person {
	String firstName ;
	String lastName ;

	Person( String first , String last ) throws LastNameException,FirstNameException{
		
		if( first.equals("") ){
			throw new FirstNameException() ;
		}
		else{
			this.firstName = first ;
		}

		if( last.equals("") ){
			throw new LastNameException() ;
		}
		else{
			this.lastName = last ;
		}

		
		
	}

	void display(){
		System.out.println("You entered " + this.firstName + " " + this.lastName) ;
	}
}



class FirstNameException extends Exception{
	FirstNameException(){
		System.out.println("First Name can't be empty");
	}

}

class LastNameException extends Exception{
	LastNameException(){
		System.out.println("Last Name can't be empty"); 
	}

}