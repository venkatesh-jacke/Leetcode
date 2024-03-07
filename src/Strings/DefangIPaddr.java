package Strings;


//1108. Defanging an IP Address
public class DefangIPaddr {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr2(address));
    }


    //TC O(N)
    //Sc O(N)
    static public String defangIPaddr(String s) {
        StringBuilder sb= new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.'){
                sb.append("[.]");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    //TC O(1)
    //Sc O(1)
    static public String defangIPaddr2(String s) {

        return s.replace(".","[.]");
    }


}
