/**
 * Solution to day ten of Advent of Code 2015
 */
public class Day10 {
    public static void main(String args[]){
        String input = "1113122113";
        for(int i = 0; i<50; i++){
            input = getNewString(input);
            if(i + 1 == 40){
                System.out.println("Answer part one = " + input.length());
            }
        }
        System.out.println("Answer part two = " + input.length());
    }

    public static String getNewString(String oldString){
        StringBuilder newString = new StringBuilder("");
        for(int i = 0; i<oldString.length(); i++){
            int currentCount = 1;
            char currentChar = oldString.charAt(i);
            while(i + 1 < oldString.length() && currentChar == oldString.charAt(i + 1)){
                i++;
                currentCount++;
            }
            newString.append("" + currentCount + currentChar);
        }
        return newString.toString();
    }
}
