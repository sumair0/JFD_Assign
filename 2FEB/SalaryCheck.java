import java.util.Scanner ;
import com.cg.eis.Exception ;

class SalaryCheck{
	public static void main(String[] args) throws EmployeeException{
		
		Scanner scan = new Scanner(System.in) ;

		System.out.println("Enter employee's salary") ;

		int salary = nextInt() ;

		final int SALARY_LIMIT = 3000 ;

		if( salary < SALARY_LIMIT ){
			throw new EmployeeException() ;
		}
		else{
			System.out.println("Eligible Salary") ;
		}
	}
}