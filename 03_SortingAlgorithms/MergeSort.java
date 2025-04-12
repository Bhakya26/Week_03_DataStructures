class Student{
    int rollno;
    String name;
    int marks;
    public class Student(int rollno,String name,int marks){
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
public class MergeSort{
    public static void mergeSorting(int[] arr){
        if(arr.length==1){
            return;
        }
        int mid=arr.length/2;
        int[] left=mergeSorting(Arrays.CopyofRange(arr,0,mid));
        int[] right=mergeSorting(Arrays.CopyofRange(arr,mid,arr.length));
        return merge(left,right);
 }
}
public int[] merge(int[] left,int[] right){
    int[] joined=new int(left.length()+right.length());
    int i=0;j=0;k=0;
    while(i<left.length&&j.right.length){
        if(left[i]<right[j]){
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
public class MergeSortStudent{
    public static void main(String[] args){
        Student[] students={new Student(1,"bhakya",89),
                            new Student(2,"ben",78),
                            new Student(3,"kris",65)
    };
    System.out.println("List of student details before sorting>>>");
    for(Student s:students){
        s.display();
    }
        
    }
}