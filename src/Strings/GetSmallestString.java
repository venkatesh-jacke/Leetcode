package Strings;


//3106. Lexicographically Smallest String After Operations With Constraint
public class GetSmallestString {
    public static void main(String[] args) {
        String s= "xaxcd";
        int k=3;
        System.out.println(getSmallestString(s,k));
    }
    static  public String getSmallestString(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;

        for (int i = 0; i < n; i++) {
            int distance = charArray[i] - 'a';
            int minChange = Math.min(distance, 26 - distance);
            if(k>0){
                if (minChange <= k) {
                    charArray[i] = 'a';
                }
                else{
                    charArray[i] = (char) ( charArray[i]-k);
                }
                k -= minChange;
            }


        }

        return new String(charArray);
    }
}
/*
Pseudo-Code Explanation:-

distance = charArray[i] - 'a'  will give the distance between current character and a
min-distance = Min(distance, 26-distance) gives us the min-distance forward or backward since its a cyclic order
If K > 0 alone we will change the characters
    if(min-distance <= k)
        we change the character to a which is lexically small
    else
        we change the character to character - k(remaining value) which will place the nearest value to its cost
    k-=minchange  we are reducing the cost


Dry Run
str=xaxcd     k=4

cur='x'
min-distance = 3
k>0
    3<4 so change 'x' to 'a' str=aaxcd k-=3 k=1

cur='a'
min-distance = 0
k>0
    0<4 so change 'a' to 'a' str=aaxcd k-=0 k=1

cur='x'
min-distance = 3
k>0
    3<1 No
    change 'x' to ('x' -1) = 'w' str=aawcd k-=3 k=-2

cur='c'
min-distance = 2 str=aawcd k-=3 k=-2
k>0 no so no change

cur='d'
min-distance = 3 str=aawcd k-=3 k=-2
k>0 no so no change



*/
