import java.io.*;

/**
 * Solution to day five of Advent of Code 2015
 */
public class Day5 {
    public static void main(String args[]){
        try (BufferedReader br = new BufferedReader(new FileReader(new File("InputDay5.txt")))) {
            int amountOne = 0;
            int amountTwo = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if(hasTwoVowels(line)&&hasDoubleLetter(line)&&!hasForbiddenLetters(line)){
                    amountOne++;
                }
                if(hasDoubleLetterWithExtraChar(line) && hasDoublePairOfLetters(line)){
                    amountTwo++;
                }
            }
            System.out.println("Answer part one = " + amountOne + "\nAnswer part two = " + amountTwo);
        }catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static boolean hasTwoVowels(String checkString){
        int vowels = 0;
        for(char c : checkString.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                if(++vowels>=3){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDoubleLetter(String checkString){
        for(int i = 0; i<checkString.length()-1; i++){
            if(checkString.charAt(i)==checkString.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasForbiddenLetters(String checkString){
        if(checkString.contains("ab")||checkString.contains("cd")||checkString.contains("pq")||checkString.contains("xy")){
            return true;
        }
        return false;
    }

    public static boolean hasDoubleLetterWithExtraChar(String checkString){
        for(int i = 0; i<checkString.length()-2; i++){
            if(checkString.charAt(i)==checkString.charAt(i+2)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasDoublePairOfLetters(String checkString){
        for(int i = 0; i<checkString.length()-1; i++){
            String twoLetters = checkString.substring(i,i+2);
            String newString = checkString.replaceAll("(" + twoLetters + ")", "");
            if(newString.length()<=checkString.length()-4){
                return true;
            }
        }
        return false;
    }
}
