import java.util.Scanner ;

class Employee{
    int age;
    String firstName;
    String lastName ;
 
    Employee(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
 
    public Integer getAge(){
        return this.age;
    }
 
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
 
    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getLastName() + " aged " + this.getAge() ;
    }
}

 
    // 1. Add New Employee
    //     - Enter name
    //     - ENter Age
    // Do you want to add more(y/n) :n
 
    // Sort by:
    // 1. First name
    // 2. Last name
    // 3. Age

 
 
 
 
 
 
class SortByFirstName implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        return ((Employee)firstObj).getFirstName().compareTo(((Employee)secondObj).getFirstName());
    }
}

class SortByLastName implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        return ((Employee)firstObj).getLastName().compareTo(((Employee)secondObj).getLastName());
    }
}
 
 
class SortByAge implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        return ((Employee)firstObj).getAge().compareTo(((Employee)secondObj).getAge());
    }
}
 
 
class CustomSortByComparator{
    public static void main(String[] args) {
        java.util.List employeeList = new java.util.ArrayList();
 
        // employeeList.add(new Employee("Siddant" , "Sharma", 22));
        // employeeList.add(new Employee("Swati" , "Rashmi", 21));
        // employeeList.add(new Employee("Abhi","Kaur" , 25));
 
        // System.out.println("List before sorting : " + employeeList);
 
        // java.util.Collections.sort(employeeList, new SortByRegId());
 
        // System.out.println("List after sorting : " + employeeList);
 
        Character choice = 'y' ;

        Scanner scan = new Scanner(System.in) ;

        String firstName , lastName ;

        int age = 0 ;

        while(choice.equals('y')){

            System.out.println("1. Add New Employee \n- Enter name \n- Enter Age") ;

            firstName = scan.next() ;
            lastName = scan.nextLine() ;

            age = scan.nextInt() ;

            employeeList.add(new Employee(firstName , lastName , age)) ;

            System.out.println("Do you want to add more(y/n) :n") ;

            choice = scan.next().charAt(0) ;

        }


        System.out.println("Sort by:\n1. First name\n2. Last name\n3. Age") ;

        final int CHOICE_ONE = 1 , CHOICE_TWO = 2 , CHOICE_THREE = 3 ;

        int sortChoice = scan.nextInt() ;



        if( sortChoice == CHOICE_ONE ){
            java.util.Collections.sort(employeeList, new SortByFirstName());
            System.out.println("List : " + employeeList);
        }

        else if( sortChoice == CHOICE_TWO ){
            java.util.Collections.sort(employeeList, new SortByLastName());
            System.out.println("List : " + employeeList);
        }

        else if( sortChoice == CHOICE_THREE){
            java.util.Collections.sort(employeeList, new SortByAge());
            System.out.println("List : " + employeeList);
        }


    }
}