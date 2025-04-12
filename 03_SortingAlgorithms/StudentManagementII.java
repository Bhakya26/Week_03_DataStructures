import java.util.*;

public class StudentManagementII {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number of students: ");
        int n=sc.nextInt();
        Student[] students=new Student[n];
        for(int i=1;i<n;i++){
            System.out.println("Enter a rollno: ");
            int rollno=sc.nextInt();
            System.out.println("Enter a Name: ");
            String name=sc.nextLine();
            System.out.println("Enter mark: ");
            int marks=sc.nextInt();
            students[i]=new Student(rollno,name,marks);
        }
        for(int i=0;i<n-1;i++){
            boolean swapped=false;
            for(int j=1;i<n-1;j++){
                swapped =true;
                if(students[j].marks>students[j+1].marks){
                    Student temp=students[j];
                    students[j]=students[j+1];
                    students[j+1]=temp;
                }
            }
            if(!swapped){
                return;
            }
        }
        System.out.println("Enter a name to search");
        String searchname=sc.nextLine();
        for(Student s:students){
            if(s.name.equals(searchname)){
                System.out.println("searched name: "+s);
                s.display();
            }else{
                System.out.println("Student not found");
            }
        }
    }
}
class Student{
    int rollno;
    String name;
    int marks;
    public Student(int rollno,String name,int marks){
        this.rollno=rollno;
        this.name=name;
        this.marks=marks;
    }
    public void display(){
        System.out.println("Roll no: "+rollno);
        System.out.println("Name: "+name);
        System.out.println("Marks: "+marks);
     }


}