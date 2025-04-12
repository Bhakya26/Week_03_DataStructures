import java.util.Stack;
public class QueueusingStacks{
    Stack<Integer>stack1;
    Stack<Integer>stack2;
    public QueueusingStacks(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    public void enqueue(int val){
        stack1.push(val);
    }
    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
         return stack2.pop();
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
     public boolean isEmpty(){
        return stack1.isEmpty()&&stack2.isEmpty();
     }
     public int size(){
        return stack1.size() + stack2.size();
     }
     public static void main(String[] args){
        QueueusingStacks obj=new QueueusingStacks();
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        System.out.println("Dequeued: "+obj.dequeue());
        obj.enqueue(40);
        System.out.println("Peek: "+obj.peek());
        System.out.println("Dequeued: "+obj.dequeue());
        System.out.println("Dequeued: "+obj.dequeue());
        System.out.println("Dequeued: "+obj.dequeue());
    

     }
}