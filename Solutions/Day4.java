import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Solution to day four of Advent of Code 2015
 */
public class Day4 {
    public static void main(String args[]){
        String input = "iwrupvqb";
        MessageDigest m=null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(input.getBytes(), 0, input.length());
        String mD5 = new BigInteger(1,m.digest()).toString(16);
        int theIntPartOne = 0;
        int theIntPartTwo = 0;
        while(!(mD5.length()<=26)){
            if((mD5.length()<=27) && theIntPartOne == 0) theIntPartOne = theIntPartTwo;
            theIntPartTwo++;
            m.reset();
            m.update((input + theIntPartTwo).getBytes(), 0, (input + theIntPartTwo).length());
            mD5 = new BigInteger(1,m.digest()).toString(16);
        }
        System.out.println("Answer part one = "+ theIntPartOne);
        System.out.println("Answer part two = "+ theIntPartTwo);
    }
}
