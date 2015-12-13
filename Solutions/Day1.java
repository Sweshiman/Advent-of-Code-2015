import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Solution to day one of Advent of Code 2015
 */
public class Day1 {
    public static void main(String args[]){
        int floor = 0;
        int currentPosInString = 0;
        Integer basementPosition = null;
        String parenthesis = null;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("InputDay1.txt")))) {
            parenthesis = br.readLine();
        }catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.exit(-1);
        }
        while(!parenthesis.isEmpty()){
            if(floor==-1){
                if(basementPosition == null){
                    basementPosition = currentPosInString;
                }
            }
            floor = parenthesis.charAt(0)=='(' ? floor + 1 : floor - 1;
            parenthesis=parenthesis.substring(1);
            currentPosInString++;
        }
        System.out.println("Answer for part one = " + floor + "\nAnswer for part two = " + basementPosition);
    }
}
