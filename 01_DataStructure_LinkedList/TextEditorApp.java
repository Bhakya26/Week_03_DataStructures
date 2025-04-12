class TextState{
    String content;
    TextState next;
    TextState prev;
    public TextState(String content){
        this.content=content;
        this.next=null;
        this.prev=null;
    }
    }
class TextEditor{
    TextState head,tail,current;
    int size=0;
    final int max_history=10;
    public void type(String newText){
        TextState newState=new TextState(newText);
        if(current!=null){
            current.next=null;
            newState.prev=current;
        }
        if(head==null){
            head=newState;
        }else{
            current.next=newState;
        }
        current=newState;
        tail=newState;
        size++;
        if(size>max_history){
            head=head.next;
            head.prev=null;
            size--;
        }
    }
    public void undo(){
        if(current!=null&&current.prev!=null){
            current=current.prev;
        }else{
            System.out.println("Nothing to undoo");
        }
    }
    public void redo(){
        if(current!=null&&current.next!=null){
            current=current.next;
        }else{
            System.out.println("Nothing to redo");
        }
    }
    public void showCurrentState(){
        if(current!=null){
            System.out.println("Current text: "+current.content);
        }else{
            System.out.println("Editor is empty");
        }
    }
}
public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.type("Hello, World");
        editor.type("Hello, World!");

        editor.showCurrentState(); 

        editor.undo();
        editor.showCurrentState(); 

        editor.undo();
        editor.showCurrentState(); 
        editor.redo();
        editor.showCurrentState(); 

        editor.type("Hello again!"); 
        editor.showCurrentState();
        editor.redo(); 
}
}