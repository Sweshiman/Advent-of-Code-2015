import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Solution to day six of Advent of Code 2015
 */
public class Day6 {
    private static boolean[][] lightsMatrixOne = new boolean[1000][1000];
    private static int[][] lightsIntenseMatrixTwo = new int[1000][1000];

    public static void main(String args[]){
        try (BufferedReader br = new BufferedReader(new FileReader(new File("InputDay6.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                performInstruction(line);
            }
        }catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.exit(-1);
        }
        int lightsLit = 0;
        int lightsBrightness = 0;
        for(boolean[] lightArray : lightsMatrixOne){
            for(boolean light : lightArray){
                if(light){
                    lightsLit++;
                }
            }
        }
        for(int[] lightArray : lightsIntenseMatrixTwo) {
            for (int light : lightArray){
                lightsBrightness += light;
            }
        }
        System.out.print("Part one answer = " + lightsLit + "\nPart two answer = " +  lightsBrightness);
    }

    public static void performInstruction(String instruction){
        if(instruction.contains("turn on ")){
            instruction = instruction.replace("turn on ", "");
            int[] values = separateValues(instruction);
            turnOn(values[0],values[1],values[2],values[3]);
        }else if(instruction.contains("turn off ")){
            instruction = instruction.replace("turn off ", "");
            int[] values = separateValues(instruction);
            turnOff(values[0], values[1], values[2], values[3]);
        }else if(instruction.contains("toggle ")){
            instruction = instruction.replace("toggle ", "");
            int[] values = separateValues(instruction);
            toggle(values[0], values[1], values[2], values[3]);
        }
    }

    public static void turnOn(int xOne, int yOne, int xTwo, int yTwo){
        for(int i = xOne; i <= xTwo; i++){
            for(int j = yOne; j <= yTwo; j++){
                lightsMatrixOne[i][j] = true;
                lightsIntenseMatrixTwo[i][j]++;
            }
        }
    }

    public static void turnOff(int xOne, int yOne, int xTwo, int yTwo){
        for(int i = xOne; i <= xTwo; i++){
            for(int j = yOne; j <= yTwo; j++){
                lightsMatrixOne[i][j] = false;
                if(lightsIntenseMatrixTwo[i][j] > 0) {
                    lightsIntenseMatrixTwo[i][j]--;
                }
            }
        }
    }

    public static void toggle(int xOne, int yOne, int xTwo, int yTwo){
        for(int i = xOne; i <= xTwo; i++){
            for(int j = yOne; j <= yTwo; j++){
                lightsMatrixOne[i][j] = !lightsMatrixOne[i][j];
                lightsIntenseMatrixTwo[i][j] += 2;
            }
        }
    }

    //Assumes the first part of the instruction (eg "turn on ") is already removed
    public static int[] separateValues(String instruction){
        int xOne = Integer.parseInt(instruction.substring(0,instruction.indexOf(',')));
        instruction = instruction.substring(instruction.indexOf(',') + 1);
        int yOne = Integer.parseInt(instruction.substring(0,instruction.indexOf(' ')));
        instruction = instruction.substring(instruction.indexOf(' ')+1);
        instruction = instruction.replace("through ", "");
        int xTwo = Integer.parseInt(instruction.substring(0,instruction.indexOf(',')));
        instruction = instruction.substring(instruction.indexOf(',') + 1);
        int yTwo = Integer.parseInt(instruction);
        int[] values = {xOne, yOne, xTwo, yTwo};
        return values;
    }
}
