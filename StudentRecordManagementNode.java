package com.day1.level1;
 class Student {

    int roll_number;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int roll_number, String name, int age, char grade) {
        this.roll_number = roll_number;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentList{
     private Student head;
    public void addStudentAtBeginning(int roll_number,String name,int age,char grade){
        Student student=new Student(roll_number,name,age,grade);
        student.next=head;
        head=student;

    }
    public void addStudentAtEnd(int roll_number,String name,int age,char grade){
        Student student=new Student(roll_number,name,age,grade);
        Student temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=student;
        student.next=null;

    }
    public void addStudentAtIndex(int position,int roll_number,String name,int age,char grade){
        if(position<=0){
            System.out.println("Wrong position");
        }
        if(position==1){
            addStudentAtBeginning(roll_number,name,age,grade);
        }
        Student student=new Student(roll_number,name,age,grade);
        Student temp=head;
        for(int i=1;i<position-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Wrong position");
        }
        student.next=temp.next;
        temp.next=student;

    }
    public void deleteStudent(int roll_number){
        if(head.roll_number==roll_number){
            head=head.next;
            System.out.println("deleted");
        }
        Student temp=head;
        while(temp.next!=null&&temp.next.roll_number!=roll_number){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("no student");
        }
        temp.next=temp.next.next;
        System.out.println("deleted");
    }
    public Student searchStudent(int roll_number){
        if(head.roll_number==roll_number){
            return head;
        }
        Student temp=head;
        while(temp.next!=null&&temp.next.roll_number!=roll_number){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("no student");
        }
       return temp.next;
    }
    public void displayStudent(){
        if(head==null){
            System.out.println("there are no students");
        }
        Student temp=head;
        while(temp.next!=null){
            System.out.println("Roll No "+temp.roll_number+" Student name "+temp.name+" Student age "+temp.age+" Student grade "+temp.grade);
            temp=temp.next;
        }
    }
    public void updateStudentGrade(int roll_number,char grade){
        if(head.roll_number==roll_number){
            head.grade=grade;

        }
        Student temp=head;
        while(temp.next!=null&&temp.next.roll_number!=roll_number){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("no student");
        }
        temp.next.grade=grade;
    }


}


    public class StudentRecordManagementNode {
        public static void main(String[] args) {
    // 1->2->3->4->5
            StudentList list=new StudentList();
            list.addStudentAtBeginning(1,"ab",15,'A');
            list.displayStudent();
            list.addStudentAtBeginning(2,"cd",16,'Z');
            list.displayStudent();
            list.addStudentAtBeginning(3,"ef",18,'B');
            list.displayStudent();
            list.addStudentAtEnd(4,"fv",12,'W');
            list.displayStudent();
            list.addStudentAtIndex(3,6,"ui",15,'A');
            list.deleteStudent(4);
            list.displayStudent();
            list.updateStudentGrade(2,'C');
            list.displayStudent();

        }
}
