//Student's Full name: Tasfique Enam
//Student's ID: 5886429
//Modification Date: 16/05/17
//Purpose of this file: driver class.
package assignment2;
/**
 *
 * @author Tasfique
 */
import java.io.*;
import java.util.Scanner;


public class driver {
    
    private static int size; //size is the static variable used for counter loop...

    public static void main(String args[])throws IOException{
        
        int i;
        int choiceentry;
        Student [] students = new Student[30]; //creating an array of 30 objects.
        Scanner read = new Scanner(System.in);
        for(i= 0;i<30;i++){
            students[i] = new Student();//the objects
        }
        do{
    System.out.println();        //display of menu
    System.out.println("1. Read data from the file ");
    System.out.println("2. Write data to the file ");
    System.out.println("3. Display all student's information ");
    System.out.println("4. Change student's data ");
    System.out.println("5. Display student with the highest and the lowest nark ");
    System.out.println("6. Display all the grades. ");
    System.out.println("7. Display the average mark for the subject ");
    System.out.println("0. To exit the program ");
    System.out.println();
    System.out.println("Please enter the number from your selection ");
    choiceentry = read.nextInt(); 
    switch(choiceentry){ //switch statement is used for the selection of the menu, to know which method to execute.
        case 1: ReadFile(students);
        break;
            case 2: WriteFile(students);
            break;
            case 3: DisplayAll(students);
            break;
            case 4: ChangeData(students);
            break;
            case 5: DisplayHighLow(students);
            break;
            case 6: DisplayAllGrades(students);
            break;
            case 7: DisplayAvgMark(students);
            break;
    }
    
    }while(choiceentry!=0);  
  } 
    public static int ReadFile(Student students [])throws IOException{ //it is used to read student data from the text file.
        String student_name;
        int i = 0;
        int student_id;
        double practicalmark,exammark,assignmentmark;
        
        File creating = new File("data.txt"); //filewriter avoids erasing a file that already exist.
        Scanner read = new Scanner(creating); //creating is the file data.txt, it is directing to the txt file
        while(read.hasNext()){
            student_name = read.next(); //reading text as name
            student_id = read.nextInt();//reading the text as id
            students[i].setDetails(student_name, student_id); 
            
            practicalmark = read.nextDouble();
            students[i].setPractical(practicalmark); 
            
            for(int y=0; y<4; y++){
                assignmentmark = read.nextDouble();
                students[i].setAssignment(assignmentmark, y); //it will read the next 4 lines as assignments marks
            }
            exammark = read.nextDouble(); //reading text for exam mark
            students[i].setExam(exammark);
            i++;
            size++; //counter
        }
        System.out.println();
        System.out.println("Your files has been read.");
        System.out.println();
        return size;
        
    }
    
    public static void WriteFile(Student[]array) throws IOException{ //void is used for not returning any values.
        PrintWriter pw = new PrintWriter("data.txt"); // it writes new data to the txt file, and also overwrites.
        for(int x=0; x<size; x++){
            pw.println(array[x].getName());
            pw.println(array[x].getID()); 
            pw.println(array[x].getPracticalMark());
            for(int y = 0; y<4; y++){
                pw.println(y);
                pw.println(array[x].getAsgMark(y)); //print writer for the new assignment mark
            }
                
                pw.println(array[x].getExamMark()); //print writer for the new exam mark
            
        }
        System.out.println();
        System.out.println("Your data has been written ");
        System.out.println();
    }
    
    public static void DisplayAll(Student[]array)throws IOException{ //to display all the student's data
        for(int j=0;j<size;j++){
            System.out.println();
            System.out.println("Student name: "+array[j].getName()); 
            System.out.println("Student ID: "+array[j].getID());
            System.out.println("Practical Marks: "+array[j].getPracticalMark());
            for(int i=0;i<4;i++){ //for loop for 4 different assignments.
                System.out.println("Assignment mark " + (i+1) + " : "+array[j].getAsgMark(i));
            }
                System.out.println("Total Assignment Marks: " + array[j].getTotalAsgMark());
                System.out.println("Exam mark: " + array[j].getExamMark());
                System.out.println("Overall mark: " + array[j].getOvarallMark());
                System.out.println("The Grade is : " + array[j].getGrade());
                if(array[j].isTechnicalFail()){ //to check if the student has technically failed or not?
                    System.out.println("This student has Technically Failed. ");
                }else{
                    System.out.println("This Student has passed. ");
                }
                    
            
        }
    }
     public static void ChangeData(Student[]array){ //method for changing the data for students data
         String student;
        int option,assignment_num;
        double practical_mark,assignment_mark,exam_mark;
        Scanner read = new Scanner(System.in);
        System.out.println("Enter name of the student, whose data you would like to change? ");
        student = read.next();
        for(int x=0;x<size;x++){
            if(student.equals(array[x].getName())){
                System.out.println("Which data would you like to change? "); //asking for which mark the user likes to change
                System.out.println("1. Practical Mark ");
                System.out.println("2. Assignment Mark ");
                System.out.println("3. Exam Mark ");
                System.out.println("0. Exit");
                option = read.nextInt();
                switch(option){ //switch statement for excuteting the option the user selected.
                    case 1:
                        System.out.println("Enter the new practical mark you like to change: ");
                        practical_mark = read.nextDouble();
                        array[x].setPractical(practical_mark);
                        break;
                    case 2:
                        System.out.println("Enter assignment number you would like to change: ");
                        assignment_num = read.nextInt();
                        assignment_num = assignment_num - 1;
                        System.out.println("Enter the Assignment " + assignment_num + " mark you would like to change: ");
                        assignment_mark = read.nextDouble();
                        array[x].setAssignment(assignment_mark, assignment_num);
                        break;
                    case 3:
                        System.out.println("Please enter the new exam marks: ");
                        exam_mark = read.nextDouble();
                        array[x].setExam(exam_mark);
                        break;
                    case 0:
                        return;      
                }
            }else{
                System.out.println("New data successfully written ");
                return;
            }
        }
     }
     
     public static void DisplayHighLow(Student[]array){ //method for displaying high and low
        
        double low = 1000;
        double high = 0;
        String namelow = null;
        String namehigh = null;
        for(int i=0;i<size;i++){
            if( array[i].getOvarallMark()<array[i+1].getOvarallMark()){
               if(array[i].getOvarallMark()<(low-array[i].getOvarallMark())){
                   low = array[i].getOvarallMark();
                   namelow = array[i].getName();
               } 
            }
            
        }
        for(int j=0;j<size;j++){
            if( array[j].getOvarallMark()>array[j+1].getOvarallMark()){
               if(array[j].getOvarallMark()-high>0){
                   high = array[j].getOvarallMark();
                   namehigh = array[j].getName();
               } 
            }
            
        }System.out.println("The lowest mark is "+ namelow +" "+ low );
        System.out.println("The highest mark is "+ namehigh +" "+ high );
        
     }
     
     public static void DisplayAllGrades(Student[]array){ //displaying all the grades for the student
         for(int i=0;i<size; i++){
             array[i].getOvarallMark();//get ovarallmark for students, it is connected to each other because the grades needs ovarall mark.
             System.out.println("The Grade for the Students " + array[i].getName()+ " are " + array[i].getGrade());
         }
     }
     
      public static void DisplayAvgMark(Student[]array){ //displaying avg marks for the students.
         double average;
         double total=0;
         for(int y=0;y<size;y++){
             total = total + array[y].getOvarallMark(); //for loop for checkiong the overall mark.
         }
         average = total/size; 
         System.out.println("The average mark for all the students is " + average);//displays out the avg mark
     }    
    
    

    
            
}
           
            
           
            
     
    

