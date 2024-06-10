package Leetcode_75;


//443. String Compression
public class StringCompression {
    public static void main(String[] args) {

    }

    static public int compress(char[] chars) {
        int res=0,i=0,len=chars.length;

        while(i<len){
            int groupLen=0;
            char current=chars[i];
            while(i+groupLen < len && chars[i+groupLen]==current){
                groupLen++;
            }
            chars[res++]=current;
            if(groupLen>1){
                for(char c:Integer.toString(groupLen).toCharArray()){
                    chars[res++]=c;
                }
            }
            i+=groupLen;
        }
        return res;
    }
}
