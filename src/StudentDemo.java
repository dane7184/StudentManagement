import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemo extends StudentInformation{
    public static void main(String[] args) {
        ArrayList<StudentDemo> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean isSrc= false;
        int option=0;
        do {
            System.out.println("1. Add new Student ");
            System.out.println("2. Edit Information Student ");
            System.out.println("3. Search Information student ");
            System.out.println("4. Delete Information Student ");
            System.out.println("5. show Information Student ");
            System.out.println("6. Exit Program ");
            do {
                String stOption;
                System.out.print("Choose Option Information 1-6 : ");

                try {
                    stOption = input.nextLine();
                    option=Integer.parseInt(stOption);
                    isSrc= true;
                }catch (Exception e){
                    option=0;
                    System.out.println("Can not input by alphabet ");
                }
            }while (!isSrc);

            switch (option){
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    show();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Your are Wrong!!!!!!!!");
            }
        }while (option!=6);
    }
}
