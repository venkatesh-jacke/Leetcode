package Strings;

public class GoalParserInterpret {
    public static void main(String[] args) {
        String s="G()(al)";
        System.out.println(interpret(s));
    }
   static public String interpret(String s) {
        String str="";
        for(int i=0;i<s.length();i++){
            if(s.substring(i).startsWith("G")) {
                str+="G";
                continue;
            }
            if(s.substring(i).startsWith("()"))  {
                str+="o";
                continue;
            }
            if(s.substring(i).startsWith("(al)"))  {
                str+="al";
            }
        }
        return str;
    }
    public static String interpret2(String s){
        return s.replace("(al)","al").replace("()","o");
    }
}
