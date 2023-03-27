import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformation {
    int id;
    String name;
    String gender;
    int age;
    String classRoom;
    float score;
    public StudentInformation(){

    }

    public StudentInformation(int id, String name, String gender, int age, String classRoom, float score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classRoom = classRoom;
        this.score = score;
    }
    void outputInformation(){
        System.out.println("Student ID: "+ id);
        System.out.println("Student Name : "+ name );
        System.out.println("Student Gender : "+ gender);
        System.out.println("Student Age : "+ age);
        System.out.println("Student ClassRoom : "+ classRoom);
        System.out.println("Student Score : "+ score);
        System.out.println("--------------------------");
    }
    void inputInformation(Scanner scanner){
        boolean vald = false;
        do {
            String strId;
            System.out.print("Student ID: ");
            try {
                strId = scanner.next();
                id = Integer.parseInt(strId);
                vald=true;
            }catch (Exception e){
                System.out.println("ID Invalid Format !");
            }
        }while (!vald);
        System.out.print("Student Name : ");
        scanner.nextLine();
        name= scanner.nextLine();
        System.out.print("student Gender : ");
        gender = scanner.nextLine();
        do {
            String strAge;
            System.out.print("Student Age : ");
            try{
                strAge = scanner.next();
                age = Integer.parseInt(strAge);
                vald = true;
            }catch (Exception e){
                System.out.print("Age Invalid Format");
            }
        }while (!vald);
        scanner.nextLine();
        System.out.print("Student Class Room : ");
        classRoom = scanner.nextLine();
        do {
            String strScore;
            System.out.print("Student Score : ");
            try{
                strScore = scanner.next();
                score = Float.parseFloat(strScore);
                vald = true;
            }catch (Exception e){
                System.out.println("Age Invalid Format");
            }
        }while (!vald);
    }
    static ArrayList<StudentDemo> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void add(){
        System.out.println("-----Add Student Information -----------");
        StudentDemo newStudent = new StudentDemo();
        newStudent.inputInformation(input);
        students.add(newStudent);
        System.out.println("----------- SuccessFully Add ----------");
        input.nextLine();
    }
    public static void update(){
        System.out.println("------ Update Information student --------");
        System.out.println("Update ID :");
        int upID = input.nextInt();
        for (int i=0; i<students.size(); i++){
            if (students.get(i).id==upID){
                StudentDemo std = new StudentDemo();
                std.id = students.get(i).id;

                System.out.print("Üpdate Name : ");
                input.nextLine();
                std.name = input.nextLine();
                System.out.print("Update Gender : ");
                std.gender = input.nextLine();
                System.out.print("Üpdate Age : ");
                std.age = input.nextInt();
                System.out.print("Update Class Room :");
                input.nextLine();
                std.classRoom = input.nextLine();
                System.out.print("Update Score : ");
                std.score = input.nextFloat();

                students.set(i,std);
            }
        }
    }
    public static void search(){
        int search;
        do {
            System.out.println("------- Search information Student -----------");
            System.out.println("1. Search Student By ID ");
            System.out.println("2. Search Student By Name ");
            System.out.println("3. Search Student By class Room ");
            System.out.println("4. Search student By Gender ");
            System.out.println("5. Exit ");
            System.out.print("Choose Option 1-5 : ");
            search = input.nextInt();
            boolean sch = false;
            switch (search){
                case 1:
                    int searchId;
                    System.out.println("----- search By ID ------");
                    System.out.print("Input ID : ");
                    searchId = input.nextInt();
                    for (int i = 0; i<students.size(); i++){
                        if (searchId == students.get(i).id){
                            sch = true;
                            students.get(i).outputInformation();
                        }
                    }
                    if (!sch){
                        System.out.println("Search Is Error !");
                    }
                    break;
                case 2:
                    String schName;
                    System.out.println("----- search By Name ------");
                    input.nextLine();
                    System.out.print("Input Name : ");
                    schName= input.nextLine();
                    for (StudentDemo students1 : students){
                        if (students1.name.equals(schName)){
                            students1.outputInformation();
                            sch = true;
                        }
                    }
                    if (!sch){
                        System.out.println("Search Is Error !");
                    }
                    break;
                case 3:
                    String schClass;
                    System.out.println("-------- Search By Class Room ---------");
                    input.nextLine();
                    System.out.print("Input Class Room : ");
                    schClass= input.nextLine();
                    for (StudentDemo students1: students){
                        if (students1.classRoom.equals(schClass)){
                            students1.outputInformation();
                            sch=true;
                        }
                    }
                    if (!sch){
                        System.out.println("Search Is Error !");
                    }
                    break;
                case 4:
                    String schGender;
                    System.out.println("-------- Search By Gender ---------");
                    input.nextLine();
                    System.out.print("Input Gender : ");
                    schGender= input.nextLine();
                    for (StudentDemo students1: students){
                        if (students1.gender.equals(schGender)){
                            students1.outputInformation();
                            sch=true;
                        }
                    }
                    if (!sch){
                        System.out.println("Search Is Error !");
                    }
                    break;
                case 5:
                    break;
            }
        }while (search!= 5);
    }
    public static void delete(){
        boolean rm = false;
        System.out.println("----------- Remove Student Information -------------");
        System.out.println("Input ID :");
        int remove = input.nextInt();
        for (int i=0; i<students.size(); i++){
            if (remove == students.get(i).id){
                students.remove(i);
                rm=true;
                System.out.println("--- Remove Success -----");
                break;
            }
        }
        if (!rm){
            System.out.println("Remove Not Found ");
        }
    }
    public static void show(){
        System.out.println("------- show Information student ---------");
        for (int i=0; i< students.size(); i++){
            students.get(i).outputInformation();
        }
    }
}