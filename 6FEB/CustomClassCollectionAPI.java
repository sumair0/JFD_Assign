import java.util.List ;
import java.util.ArrayList ;
import java.util.Scanner ;

class CustomClassCollectionAPI{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in) ;
 
        Computer first = new Computer("HP", "black", 500, 8);
         
        List list = new ArrayList();
 
        list.add(first);
        list.add(new Computer("HP", "black", 256, 4));
        list.add(new Computer("Sony", "blue", 1024, 16));
 
        

        int choice = 0 ;
        int subChoice = 0 ;



        String []prompt = {     "1. Add a new Computer" , 
                                "2. Display all computers" ,
                                "3. Search for a computer : By Name, Color, HDDSize, RamSize, ID" ,
                                "4. Delete a computer : By ID" ,
                                "5. Update Computer Details: Name, Color, HDDSize, RamSize"    } ;

        final int CHOICE_ONE = 1 , CHOICE_TWO = 2 , CHOICE_THREE = 3 , CHOICE_FOUR = 4 , CHOICE_FIVE = 5  ;



        String brandName = "" , color = "" ;
        int storage = 0 , memory = 0 ;

        int id = 0 ;



        while(true){ 

            System.out.println("\n\n") ;
            

            System.out.println("Press Ctrl - C to exit or Press the corresponding number shown") ;

            for(String str : prompt){
                System.out.println(str) ;
            }


            choice = scan.nextInt() ;

            if( choice == CHOICE_ONE ){

                System.out.println("Enter the details of the Computer to be added below" ) ;
                System.out.println("Enter the Brand name") ;

                brandName = scan.next() ;

                System.out.println("Enter the Color of the computer") ;

                color = scan.next() ;

                System.out.println("Enter the Harddrive Size of the computer ") ;

                storage = scan.nextInt() ;

                System.out.println("Enter the RAM Size of the computer ") ;

                memory = scan.nextInt() ;

                list.add(new Computer(brandName,color,storage,memory)) ;



            }


            else if( choice == CHOICE_TWO ){
                System.out.println("List : " + list);
            }


            else if( choice == CHOICE_THREE ){

                System.out.println("Search By (1) Name, (2) Color, (3) HDDSize, (4) RAMSize, (5) ID") ;

                subChoice = scan.nextInt() ;

                if( subChoice == CHOICE_ONE ){

                    System.out.println("Please enter the name ") ;

                    brandName = scan.next() ;

                    for( Object obj : list ){
                        if( obj instanceof Computer ){
                            if((((Computer)obj).getBrand()).equals(brandName)){
                                System.out.println(((Computer)obj)) ;
                            }
                        }
                    }

                }

                else if( subChoice == CHOICE_TWO ){

                    System.out.println("Please enter the Color ") ;

                    color = scan.next() ;

                    for( Object obj : list ){
                        if( obj instanceof Computer ){
                            if((((Computer)obj).getColor()).equals(color)){
                                System.out.println(((Computer)obj)) ;
                            }
                        }
                    }

                }

                else if( subChoice == CHOICE_THREE ){

                    System.out.println("Please enter the HDDSize ") ;

                    storage = scan.nextInt() ;

                    for( Object obj : list ){
                        if( obj instanceof Computer ){
                            if((((Computer)obj).getHddSize()) == (storage)){
                                System.out.println(((Computer)obj)) ;
                            }
                        }
                    }

                }

                else if( subChoice == CHOICE_FOUR ){

                    System.out.println("Please enter the RAMSize ") ;

                    memory = scan.nextInt() ;

                    for( Object obj : list ){
                        if( obj instanceof Computer ){
                            if((((Computer)obj).getRamSize()) == (memory)){
                                System.out.println((Computer)obj) ;
                            }
                        }
                    }

                }

                else if( subChoice == CHOICE_FIVE ){

                    System.out.println("Please enter the ID ") ;

                    id = scan.nextInt() ;

                    for( Object obj : list ){
                        if( obj instanceof Computer ){
                            if((((Computer)obj).getId()) == (id)){
                                System.out.println(((Computer)obj) );
                            }
                        }
                    }

                }
            }


            else if (choice == CHOICE_FOUR){
                System.out.println("Please enter an ID number you wish to Delete") ;

                id = scan.nextInt() ;

                Computer temp = null;

                boolean flag = false ;

                for( Object obj : list ){
                    if( obj instanceof Computer ){
                        if((((Computer)obj).getId()) == (id)){
                            // System.out.println() ;
                            // obj = null ;
                            temp = (Computer)obj ;
                            flag = true ;

                            break ;
                        }
                    }
                }

                if(flag == false){
                    System.out.println("Please enter a valid ID") ;
                }

                if( temp != null ){
                    list.remove(temp) ;
                    System.out.println("Deleted Success") ;
                    }  


            }

           else if(choice == CHOICE_FIVE){

                System.out.println("Enter the Id number that you want to update, you can search for it first") ;

                boolean flag1 = false ;

                id = scan.nextInt() ;

                for( Object obj : list ){
                        if( obj instanceof Computer ){
                            if((((Computer)obj).getId()) == (id)){

                                flag1 = true ;

                                System.out.println("Update Computer Details: (1)Name, (2)Color, (3)HDDSize, (4)RamSize") ;

                                subChoice = scan.nextInt() ;


                                if( subChoice == CHOICE_ONE ){

                                    brandName = scan.next() ;

                                    ((Computer)obj).setBrand(brandName) ;
                                }


                                else if( subChoice == CHOICE_TWO ){
                                    color = scan.next() ;
                                    ((Computer)obj).setColor(color);

                                }

                                else if( subChoice == CHOICE_THREE ){
                                    storage = scan.nextInt() ;
                                    ((Computer)obj).setHddSize(storage);

                                }

                                else if( subChoice == CHOICE_FOUR ){
                                    memory = scan.nextInt() ;
                                    ((Computer)obj).setRamSize(memory);

                                }
                                
                            }
                        }
                    }

                    if( flag1 == false ){
                    System.out.println("Please enter a valid ID") ;
                }


                


           }










        }


    }
}
 
// 1. Add a new Computer
// 2. Display all computers
// 3. Search for a computer : By Name, Color, HDDSize, RamSize, ID
// 4. Delete a computer : By ID
// 5. UPdate Computer Details: Name, Color, HDDSize, RamSize
 
 
 
class Computer{
    String brand, color;
    int hddSize, ramSize;
    int id ;
    private static int idCounter ;
 
    Computer(String brand, String color, int hddSize, int ramSize){
        this.id = idCounter++ ;
        this.brand = brand;
        this.color = color;
        this.hddSize = hddSize;
        this.ramSize = ramSize;
    }
 
    public String getColor(){
        return this.color;
    }
 
    public String getBrand(){
        return this.brand;
    }
 
    public Integer getHddSize(){
        return this.hddSize;
    }
     
    public Integer getRamSize(){
        return this.ramSize;
    }

     public Integer getId(){
        return this.id;
    }


    public void setColor(String color){
        this.color = color;
    }
 
    public void setBrand(String brand){
        this.brand = brand;
    }
 
    public void setHddSize(Integer storage){
        this.hddSize = storage;
    }
     
    public void setRamSize(Integer memory){
        this.ramSize = memory;
    }

 
    @Override
    public String toString(){
        return "Computer : (" + this.getId() + ", " + this.getBrand()
            + ", " + this.getColor()
            + ", " + this.getHddSize()
            + ", " + this.getRamSize()
            + ")";
    }
 
 
}