/**
 * Solution to day one of Advent of Code 2015
 * Code is very badly optimized, it is possible to finish part two of the problem but it will take hours
 */
public class Day10 {
    public static void main(String args[]){
        String input = "1113122113";
        for(int i = 0; i<50; i++){
            input = getNewString(input);
            if(i == 39){
                System.out.println("Answer part one = " + input.length());
            }
        }
        System.out.println("Answer part two = " + input.length());
    }

    public static String getNewString(String oldString){
        StringBuilder newString = new StringBuilder();
        StringBuilder tempString = new StringBuilder(oldString);
        while(!(tempString.length()==0)){
            amountAndChar(newString,tempString);
        }
        return newString.toString();
    }

    public static void amountAndChar(StringBuilder buildString, StringBuilder deleteString){
        if(deleteString.length()==0){
            return;
        }
        char thisChar = deleteString.charAt(0);
        int oldLength = deleteString.length();
        removeItems(deleteString);
        int amount = oldLength - deleteString.length();
        buildString.append("" + amount + thisChar);
    }

    public static void removeItems(StringBuilder oldString){
        char tempChar = oldString.charAt(0);
        while(!(oldString.length()==0)){
            if(oldString.charAt(0)==tempChar){
                oldString.deleteCharAt(0);
            }else{
                return;
            }
        }
    }
}
