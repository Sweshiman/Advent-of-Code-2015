import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Solution to day three of Advent of Code 2015
 */
public class Day3 {
    private static class Coordinate{
        public final int X;
        public final int Y;
        public Coordinate(int x,int y){
            this.X = x;
            this.Y = y;
        }
        @Override
        public boolean equals(Object obj) {//Implemented to make sure the ArrayList .contains method works properly
            if(obj.getClass().equals(Coordinate.class)){
                Coordinate o = (Coordinate) obj;
                return o.X == this.X && o.Y == this.Y;
            }
            return false;
        }
    }

    public static void main(String args[]){
        String input = null;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("InputDay3.txt")))) {
            input = br.readLine();
        }catch (IOException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Part 1 answer = " + getHouses(input) + "\nPart 2 answer = " + getHousesWithRoboSanta(input));
    }

    public static int getHouses(String input){
        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();
        coordinateList.add(new Coordinate(0,0));
        Coordinate lastCoordinate = new Coordinate(0,0);
        for(int i = 0; i<input.length(); i++){
            Coordinate newCoordinate = null;
            switch(input.charAt(i)){
                case '^':
                    newCoordinate = new Coordinate(lastCoordinate.X, lastCoordinate.Y + 1);
                    break;
                case 'v':
                    newCoordinate = new Coordinate(lastCoordinate.X, lastCoordinate.Y - 1);
                    break;
                case '>':
                    newCoordinate = new Coordinate(lastCoordinate.X + 1, lastCoordinate.Y);
                    break;
                case '<':
                    newCoordinate = new Coordinate(lastCoordinate.X - 1, lastCoordinate.Y);
                    break;
            }
            lastCoordinate = newCoordinate;
            if(!coordinateList.contains(newCoordinate)){
                coordinateList.add(newCoordinate);
            }
        }
        return coordinateList.size();
    }

    public static int getHousesWithRoboSanta(String input){
        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();
        coordinateList.add(new Coordinate(0, 0));
        Coordinate lastCoordinateSanta = new Coordinate(0,0);
        Coordinate lastCoordinateRoboSanta = new Coordinate(0,0);
        for(int i = 0; i<input.length(); i++){
            Coordinate newCoordinate = null;
            switch(input.charAt(i)){
                case '^':
                    if(i%2==0) {
                        newCoordinate = new Coordinate(lastCoordinateSanta.X, lastCoordinateSanta.Y + 1);
                    }else{
                        newCoordinate = new Coordinate(lastCoordinateRoboSanta.X, lastCoordinateRoboSanta.Y + 1);
                    }
                    break;
                case 'v':
                    if(i%2==0) {
                        newCoordinate = new Coordinate(lastCoordinateSanta.X, lastCoordinateSanta.Y - 1);
                    }else{
                        newCoordinate = new Coordinate(lastCoordinateRoboSanta.X, lastCoordinateRoboSanta.Y - 1);
                    }
                    break;
                case '>':
                    if(i%2==0) {
                        newCoordinate = new Coordinate(lastCoordinateSanta.X + 1, lastCoordinateSanta.Y);
                    }else{
                        newCoordinate = new Coordinate(lastCoordinateRoboSanta.X + 1, lastCoordinateRoboSanta.Y);
                    }
                    break;
                case '<':
                    if(i%2==0) {
                        newCoordinate = new Coordinate(lastCoordinateSanta.X - 1, lastCoordinateSanta.Y);
                    }else{
                        newCoordinate = new Coordinate(lastCoordinateRoboSanta.X - 1, lastCoordinateRoboSanta.Y);
                    }
                    break;
            }
            if(i%2==0) {
                lastCoordinateSanta = newCoordinate;
            }else{
                lastCoordinateRoboSanta = newCoordinate;
            }
            if(!coordinateList.contains(newCoordinate)){
                coordinateList.add(newCoordinate);
            }
        }
        return coordinateList.size();
    }
}
