import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solution to day two of Advent of Code 2015
 */
public class Day2 {
    public static void main(String args[]) {
        ArrayList<String> dims= new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File("InputDay2.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                dims.add(line);
            }
        }catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.exit(-1);
        }
        int totalArea = 0;
        int totalLength = 0;
        for(String dim : dims){
            totalArea += getArea(dim);
            totalLength += getLength(dim);
        }
        System.out.println("Answer for part one = " + totalArea);
        System.out.println("Answer for part two = " + totalLength);
    }

    public static int getArea(String dimensions){
        ArrayList<Integer> intList = new ArrayList<Integer>();
        while(dimensions.contains("x")){
            intList.add(Integer.parseInt(dimensions.substring(0, dimensions.indexOf("x"))));
            dimensions = dimensions.substring(dimensions.indexOf("x")+1);
        }
        intList.add(Integer.parseInt(dimensions));
        int sum = 2*intList.get(0)*intList.get(1)+2*intList.get(1)*intList.get(2)+2*intList.get(0)*intList.get(2);
        int maxNumber = Integer.max(intList.get(0),Integer.max(intList.get(1),intList.get(2)));
        intList.remove((Object)maxNumber);
        sum += intList.get(0)*intList.get(1);
        return sum;
    }

    public static int getLength(String dimensions){
        ArrayList<Integer> intList = new ArrayList<Integer>();
        while(dimensions.contains("x")){
            intList.add(Integer.parseInt(dimensions.substring(0, dimensions.indexOf("x"))));
            dimensions = dimensions.substring(dimensions.indexOf("x")+1);
        }
        intList.add(Integer.parseInt(dimensions));
        int sum = intList.get(0)*intList.get(1)*intList.get(2);
        int maxNumber = Integer.max(intList.get(0),Integer.max(intList.get(1),intList.get(2)));
        intList.remove((Object)maxNumber);
        for(Integer i : intList){
            sum += i*2;
        }
        return sum;
    }

}
