//Student's Full name: Tasfique Enam
//Student's ID: 5886429
//Modification Date: 16/05/17
//Purpose of this file: Student class
package assignment2;
/**
 *
 * @author Tasfique
 */
public class Student {
    //declaring attributes.
    private String name;
    private int id;
    private double practical_mark, exam_mark;
    private double [] assignment_mark = new double [4];
    double total_assignment;
    
    
    //default constructor for setting default values.
    public Student(){
        name = "";
        id = 0;
        practical_mark = 0;
        assignment_mark[0]=0;
        assignment_mark[1]=0;
        assignment_mark[2]=0;
        assignment_mark[3]=0;
        exam_mark = 0;
    }
    //accessor methods
    public void setDetails(String name, int id){
        this.name = name;
        this.id = id;
    }
       
   
    public void setPractical(double practical_mark){
  this.practical_mark = practical_mark; //assigning practical marks.
        while (practical_mark>10){ // if the mark is greater than 10, it will set the mark to 0
              this.practical_mark = 0;
        }
              
    } 
    public void setAssignment(double assignment_mark, int assignment_number){//assignment method
      this.assignment_mark[assignment_number] = assignment_mark;
      if(this.assignment_mark[assignment_number]>10 || this.assignment_mark[assignment_number]<1){
        this.assignment_mark[assignment_number] = 0; 
    }
      

    }
    public void setExam(double exam_mark){ //set exam method
        this.exam_mark = exam_mark;
        if(exam_mark>100 || exam_mark <0){
            this.exam_mark = 0;
        }
        
    } //mutator methods.
    String getName(){ //get name method
        return name;
    }
    
    int getID(){ //get ID method
        return id;
    }
    
    double getPracticalMark(){ //get practical method
        return practical_mark;
    }
    
    double getAsgMark(int i){ //get assignment mark method
        return this.assignment_mark[i];
    }
        
    double getTotalAsgMark(){ //total assignment mark method
       double total_assignment = 0;
        for(int y=0;y<4;y++){
           total_assignment = total_assignment + this.assignment_mark[y];
       }
       return total_assignment;
    }
    
    double getExamMark(){ //get exam mark method
        return exam_mark;
    }
    
    double getOvarallMark(){ //get overall mark method
       double ovarall = practical_mark + getTotalAsgMark() + (exam_mark*(0.5));
        return ovarall;
    }
    
    String getGrade(){ //get grade method
        String grade = null; //followed UOW grading scheme.
        if(getOvarallMark()>=85 && getOvarallMark()<=100){
            grade = "HD";
        }
        else if(getOvarallMark()>=75 && getOvarallMark()<=84){
            grade = "D";
        }
        else if(getOvarallMark()>=65 && getOvarallMark()<=74){
            grade = "C";
        }
        else if(getOvarallMark()>=50 && getOvarallMark()<=64){
            grade = "P";
        }
        else if(getOvarallMark()<=49){
            grade = "F";
        }
        return grade;
    }
    boolean isTechnicalFail(){ //technical fail method.
        if(getOvarallMark()>=50 && exam_mark<40){ //if the overall mark is greater than 50 but exam is less than 40
            return true;
        }
        else{
            return false;
        }
    }
}
