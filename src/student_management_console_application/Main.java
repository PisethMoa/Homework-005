package student_management_console_application;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main{
    public static void press(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter key to continue...!");
        scanner.nextLine();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int option = 0;
        do{
            boolean isOptionValid = false;
            String optionText;
            System.out.println("=============== Student Management Console Application ===============");
            System.out.println("1. Insert student information into my system.");
            System.out.println("2. Edit student information in my system.");
            System.out.println("3. Search student information in my system.");
            System.out.println("4. Delete student in my system.");
            System.out.println("5. Display all students information.");
            System.out.println("6. Exit the program!!!");
            do{
                try{
                    System.out.print("Please choose your option from (1-6) = ");
                    optionText = scanner.nextLine();
                    option = Integer.parseInt(optionText);
                    isOptionValid = true;
                }catch(Exception e){
                    System.out.println("Error!!! You input invalid...! Please try again can not input text.");
                    press();
                }
            }while(!isOptionValid);
            switch (option) {
                case 1 ->{
                    System.out.println("--------------- Insert Student Information ---------------");
                    Student student = new Student();
                    student.insertStudentInformation();
                    students.add(student);
                    press();
                }
                case 2 ->{
                    int updateStudentId = 0;
                    boolean isStudentFound = false;
                    String idText;
                    System.out.println("--------------- Update Student Information ---------------");
                    do{
                        try{
                            System.out.print("Please enter student id to update = ");
                            idText = scanner.nextLine();
                            updateStudentId = Integer.parseInt(idText);
                            isStudentFound = true;
                        }catch(Exception e){
                            System.out.println("Error!!! You input invalid...! Please try again can not input text.");
                            press();
                        }
                    }while(!isStudentFound);
                    if(students.size() > 0){
                        for(int i=0; i<students.size(); i++){
                            isStudentFound = true;
                            if(updateStudentId == students.get(i).studentId){
                                Student updateStudent = students.get(i);
                                updateStudent.updateStudentInformation();
                                students.set(i, updateStudent);
                                break;
                            }else{
                                isStudentFound = false;
                            }
                        }
                        if(!isStudentFound){
                            System.out.println("The provided student with id of "+updateStudentId+" doesn't exist into my system. Try different one!!!");
                        }else{
                            System.out.println("Congratulations, You have updated student information successfully.");
                        }
                    }else{
                        System.out.println("There aren't have student exist into my system...!");
                    }
                    scanner.nextLine();
                    press();
                }
                case 3 ->{
                    int searchOption = 0;
                    do{
                        String optionString;
                        boolean isOptionString = false;
                        int searchStudent;
                        System.out.println("--------------- Search Student Information ---------------");
                        System.out.println("1. Search student information by id.");
                        System.out.println("2. Search student information by name.");
                        System.out.println("3. Search student information by gender.");
                        System.out.println("4. Search student information by classname.");
                        System.out.println("5. Search student information by score.");
                        System.out.println("6. Exit the program!!!");
                        do{
                            try{
                                System.out.print("==> Please choose your option from (1-6) = ");
                                optionString = scanner.nextLine();
                                searchOption = Integer.parseInt(optionString);
                                isOptionString = true;
                            }catch(Exception e){
                                System.out.println("Error!!! You input invalid...! Please try again can not input text.");
                            }
                        }while(!isOptionString);
                        switch(searchOption){
                            case 1 ->{
                                int searchStudentId = 0;
                                String studentIdText;
                                boolean isSearchStudentIdExist = false;
                                boolean isStudentIdExist = false;
                                System.out.println("############### Search Student Id ###############");
                                do{
                                    try{
                                        System.out.print("Please enter student id to search = ");
                                        studentIdText = scanner.nextLine();
                                        searchStudentId = Integer.parseInt(studentIdText);
                                        isSearchStudentIdExist = true;
                                    }catch(Exception e){
                                        System.out.println("Error!!! You input invalid...! Please try again can not input text.");
                                        press();
                                    }
                                }while(!isSearchStudentIdExist);
                                if(students.size() > 0){
                                    for(Student student : students){
                                        if(searchStudentId == student.studentId){
                                            isStudentIdExist = true;
                                            student.showAllStudentInformation();
                                            break;
                                        }
                                    }
                                    if(!isStudentIdExist){
                                        System.out.println("Student with id is "+searchStudentId+" doesn't exist into my system. Try different one!!!");
                                    }else{
                                        System.out.println("Congratulations, You have search student id successfully.");
                                    }
                                }else{
                                    System.out.println("There aren't have student exist into my system...!");
                                }
                            }
                            case 2 ->{
                                String searchStudentName;
                                boolean isSearchStudentNameExist = false;
                                System.out.println("############### Search Student Name ###############");
                                System.out.print("Please enter student name to search = ");
                                searchStudentName = scanner.nextLine();
                                for(Student student : students){
                                    if (searchStudentName.equalsIgnoreCase(student.studentName)){
                                        isSearchStudentNameExist = true;
                                        student.showAllStudentInformation();
                                        break;
                                    }
                                }
                                if(!isSearchStudentNameExist){
                                    System.out.println("Student with name is "+searchStudentName+" doesn't exist into my system. Try different one!!!");
                                }else{
                                    System.out.println("Congratulations, You have search student name successfully.");
                                }
                            }
                            case 3 ->{
                                String searchStudentGender;
                                boolean isSearchStudentGenderExist = false;
                                System.out.println("############### Search Student Gender ###############");
                                System.out.print("Please enter student gender to search = ");
                                searchStudentGender = scanner.nextLine();
                                for(Student student : students){
                                    if(searchStudentGender.equalsIgnoreCase(student.studentGender)){
                                        isSearchStudentGenderExist = true;
                                        student.showAllStudentInformation();
                                        break;
                                    }
                                }
                                if(!isSearchStudentGenderExist){
                                    System.out.println("Student with gender is "+searchStudentGender+" doesn't exist into my system. Try different one!!");
                                }else{
                                    System.out.println("Congratulations, You have search student gender successfully.");
                                }
                            }
                            case 4 ->{
                                String searchStudentClassname;
                                boolean isSearchStudentClassnameExist = false;
                                System.out.println("############### Search Student Classname ###############");
                                System.out.print("Please enter student classname to search = ");
                                searchStudentClassname = scanner.nextLine();
                                for(Student student : students){
                                    if(searchStudentClassname.equalsIgnoreCase(student.studentClassroom)){
                                        isSearchStudentClassnameExist = true;
                                        student.showAllStudentInformation();
                                        break;
                                    }
                                }
                                if(!isSearchStudentClassnameExist){
                                    System.out.println("Student with classname is "+searchStudentClassname+" doesn't exist into my system. Try different one!!");
                                }else{
                                    System.out.println("Congratulations, You have search student classname successfully.");
                                }
                            }
                            case 5 ->{
                                float searchStudentScore = 0.f;
                                String studentScoreText;
                                boolean isSearchStudentScoreExist = false;
                                boolean isStudentScoreExist = false;
                                System.out.println("############### Search Student Score ###############");
                                do{
                                    try{
                                        System.out.print("Please enter student score to search = ");
                                        studentScoreText = scanner.nextLine();
                                        searchStudentScore = Float.parseFloat(studentScoreText);
                                        isSearchStudentScoreExist = true;
                                    }catch(Exception e){
                                        System.out.println("Error!!! You input invalid...! Please try again can not input text.");
                                        press();
                                    }
                                }while(!isSearchStudentScoreExist);
                                for(Student student : students){
                                    if(searchStudentScore == student.studentScore){
                                        isStudentScoreExist = true;
                                        student.showAllStudentInformation();
                                        break;
                                    }
                                }
                                if(!isStudentScoreExist){
                                    System.out.println("Student with score is "+searchStudentScore+" doesn't exist into my system. Try different one!!");
                                }else{
                                    System.out.println("Congratulations, You have search student score successfully.");
                                }
                            }
                            case 6 -> System.out.println("Exiting the program...!");
                            default -> System.out.println("You choose wrong option!!! Please try again to choose option from (1-6).");
                        }
                        scanner.nextLine();
                        press();
                    }while(searchOption != 6);
                }
                case 4 ->{
                    int deleteStudentId = 0;
                    String deleteIdText;
                    boolean isDeleteStudentIdExist = false;
                    boolean isDeleteIdExist = false;
                    System.out.println("--------------- Delete Student Information ---------------");
                    do{
                        try{
                            System.out.print("Please enter student id to delete = ");
                            deleteIdText = scanner.nextLine();
                            deleteStudentId = Integer.parseInt(deleteIdText);
                            isDeleteStudentIdExist = true;
                        }catch(Exception e){
                            System.out.println("Error!!! You input invalid...! Please try again can not input text.");
                            press();
                        }
                    }while(!isDeleteStudentIdExist);
                    if(students.size() > 0){
                        for(int i=0; i<students.size(); i++){
                            if(deleteStudentId == students.get(i).studentId){
                                isDeleteIdExist = true;
                                students.remove(i);
                                break;
                            }
                        }
                        if(!isDeleteIdExist){
                            System.out.println("Student with id is "+deleteStudentId+" doesn't exist into my system. Try different one!!");
                        }else{
                            System.out.println("Congratulations, You have deleted student information successfully.");
                        }
                    }else{
                        System.out.println("There aren't have student exist into my system...!");
                    }
                    scanner.nextLine();
                    press();
                }
                case 5 ->{
                    System.out.println("--------------- Show All Students Information ---------------");
                    for(Student student : students){
                        student.showAllStudentInformation();
                    }
                    press();
                }
                case 6 ->{
                    System.out.println("Exiting the program...!");
                    press();
                }
                default ->{
                    System.out.println("You choose wrong option!!! Please try again to choose option from (1-6).");
                    press();
                }
            }
        }while(option != 6);
    }
}
