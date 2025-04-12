class Student{
    int rollno;
    String name;
    int age;
    char grade;
    Student next;
    public Student(int rollno,String name,int age,char grade){
        this.rollno=rollno;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }
}
 class StudentList{
    Student head;
    public void addAtBeginning(Student newStudent){
        newStudent.next=head;
        head=newStudent;
    }
    public void addAtEnd(Student newStudent){
        if(head==null){
            head=newStudent;
            return;
        }
        Student current=head;
        while(current.next!=null){
            current.next=current;
        }
        current.next=newStudent;
    }
    public void addAtSpecific(Student newStudent,int position){
        if(position==1){
            addAtBeginning(newStudent);
            return;
        }
        Student temp=head;
        for(int i=1;temp!=null&&i<position-1;i++){
            temp=temp.next;
        }
        newStudent.next=temp.next;
        temp.next=newStudent;
    }
    public void deletebyRollNo(int RollNo){
        if(head==null){
            return;
        }
        if(head.rollno==RollNo){
            head=head.next;
            return;
        }
        Student current=head;
        while(current.next!=null){
            if(current.next.rollno==RollNo){
                current.next=current.next.next;
                return;
            }
            current=current.next;
        }
        System.out.println("not found");
}
    public Student searchbyRollNo(int RollNo){
        Student current=head;
        while(current!=null){
        if(current.rollno==RollNo){
            return current;
        }
        current=current.next;
    }
    return null;
}
    public void updateStudentGrade(int RollNo,char newGrade){
        Student student=searchbyRollNo(RollNo);
        if(student!=null){
            student.grade=newGrade;
        }else{
            System.out.println("Not found");
        }
    }
    public void display(){
        if(head==null){
            System.out.println("No student records");
        }
        Student current=head;
        while(current!=null){
            System.out.println("Rollno: "+current.rollno+ "Name: "+current.name+"Age: "+current.age+"Grade: "+current.grade);
            current=current.next;
        }
    }
}
public class StudentLL{
    public static void main(String[] args){
        StudentList list=new StudentList();
        list.addAtBeginning(new Student(1,"Tinbeer",18,'A'));
        list.addAtEnd(new Student(5,"bhaki",18,'B'));
        list.addAtSpecific(new Student(3,"luna",16,'C'),2);
        list.display();
        Student s = list.searchbyRollNo(102);
        if (s != null) {
            System.out.println("Found: " + s.name + ", Grade: " + s.grade);
        }

        
        list.updateStudentGrade(2, 'A');
        list.display();

      
        list.deletebyRollNo(1);
        list.display();
    }
}