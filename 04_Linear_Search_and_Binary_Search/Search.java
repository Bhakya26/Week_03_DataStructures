public class Search{
    public static String findWord(String[] sentences,String word){
        for(String sentence:sentences){
            if(sentence.toLowerCase().contains(word.toLowerCase())){
                return sentence;
            }
            
        }
        return "not found";
    }
    public static void main(String[] args){
        String[] sentences={"Java is a powerful programming language.",
            "Linear search is simple and easy.",
            "We are learning data structures.",
            "Let's solve more problems today."};
            String word="problems";
            String result=findWord(sentences,word);
            System.out.println("Found: "+result);
    }
}