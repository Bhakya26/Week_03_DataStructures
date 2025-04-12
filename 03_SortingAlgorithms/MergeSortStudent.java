import java.util.*;
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
        System.out.println("Student details");
        System.out.println("Roll number: "+rollno);
        System.out.println("Name of the student: "+name);
        System.out.println("Marks scored by the student: "+marks);
    }
}
public class MergeSortStudent{
    public static Student[] mergeSorting(Student[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        Student[] left=mergeSorting(Arrays.copyOfRange(arr,0,mid));
        Student[] right=mergeSorting(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
 }

public static Student[] merge(Student[] left,Student[] right){
    Student[] joined=new Student[left.length+right.length];
    int i=0,j=0,k=0;
    while(i<left.length&&j<right.length){
        if(left[i].marks<right[j].marks){
            joined[k++]=left[i++];
        }else{
            joined[k++]=right[j++];
        }
     }
     while(i<left.length){
        joined[k++]=left[i++];
     }
     while(j<right.length){
        joined[k++]=right[j++];
     }
     return joined;
}

    public static void main(String[] args){
        Student[] students={
            new Student(1,"bhakya",89),
            new Student(2,"ben",78),
            new Student(3,"kris",65)
    };
    System.out.println("List of student details before sorting>>>");
    for(Student s:students){
        s.display();
    }
    students=mergeSorting(students);
    System.out.println("List of students after sorting by marks");
    for(Student s:students){
        s.display();
    }
        
    }
}