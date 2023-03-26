package student_management_console_application;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Student{
    Scanner scanner = new Scanner(System.in);
    int studentId;
    String studentName;
    String studentGender;
    int studentAge;
    String studentClassroom;
    float studentScore;
    boolean isIdValid = false;
    boolean isAgeValid = false;
    boolean isScoreValid = false;
    public Student(){}
    public Student(int studentId, String studentName, String studentGender, int studentAge, String studentClassroom, float studentScore){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentAge = studentAge;
        this.studentClassroom = studentClassroom;
        this.studentScore = studentScore;
    }
    public void insertStudentInformation(){
        do{
            try{
                System.out.print("Please enter student id        = ");
                studentId = scanner.nextInt();
                isIdValid = true;
            }catch(InputMismatchException inputMismatchException){
                System.out.println("Error!!! Id can only be integer...! Please input again.");
                scanner.nextLine();
            }
        }while(!isIdValid);
        System.out.print("Please enter student name      = ");
        scanner.nextLine();
        studentName = scanner.nextLine();
        System.out.print("Please enter student gender    = ");
        studentGender = scanner.nextLine();
        do{
            try{
                System.out.print("Please enter student age       = ");
                studentAge = scanner.nextInt();
                isAgeValid = true;
            }catch(InputMismatchException inputMismatchException){
                System.out.println("Error!!! Age can only be integer...! Please input again.");
                scanner.nextLine();
            }
        }while(!isAgeValid);
        System.out.print("Please enter student classroom = ");
        scanner.nextLine();
        studentClassroom = scanner.nextLine();
        do{
            try{
                System.out.print("Please enter student score     = ");
                studentScore = scanner.nextFloat();
                isScoreValid = true;
            }catch(InputMismatchException inputMismatchException){
                System.out.println("Error!!! Score can only be integer or float...! Please input again.");
                scanner.nextLine();
            }
        }while(!isScoreValid);
        System.out.println("Congratulations, You have successfully added student information into my system.");
    }
    public void updateStudentInformation(){
        System.out.print("Please enter student name         = ");
        scanner.nextLine();
        studentName = scanner.nextLine();
        System.out.print("Please enter student gender       = ");
        studentGender = scanner.nextLine();
        do{
            try{
                System.out.print("Please enter student age          = ");
                studentAge = scanner.nextInt();
                isAgeValid = true;
            }catch(InputMismatchException inputMismatchException){
                System.out.println("Error!!! Age can only be integer...! Please input again.");
                scanner.nextLine();
            }
        }while(!isAgeValid);
        System.out.print("Please enter student classroom    = ");
        scanner.nextLine();
        studentClassroom = scanner.nextLine();
        do{
            try{
                System.out.print("Please enter student score        = ");
                studentScore = scanner.nextFloat();
                isScoreValid = true;
            }catch(InputMismatchException inputMismatchException){
                System.out.println("Error!!! Score can only be integer or float...! Please input again.");
                scanner.nextLine();
            }
        }while(!isScoreValid);
    }
    public void showAllStudentInformation(){
        System.out.println("______________________________");
        System.out.println("Student id is        = "+studentId);
        System.out.println("Student name is      = "+studentName);
        System.out.println("Student gender is    = "+studentGender);
        System.out.println("Student age is       = "+studentAge);
        System.out.println("Student classroom is = "+studentClassroom);
        System.out.println("Student score is     = "+studentScore);
    }
}
