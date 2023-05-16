/*
Marley Baker
1/30/23
Activity 4
 */
 import core.data.*;
 import java.util.ArrayList;
 import java.util.Scanner;
public class Stats{
      
      private String name;
      private String team;
      private int year;
      private int attempts;
      private double percent;
      private static int date;
      
   public static void main (String args[]){
      DataSource ds = DataSource.connect("Career_Stats_Passing.csv");
      ds.load();
      ArrayList<Stats> allQuarterbacks = ds.fetchList("Stats", "Name", "Team", "Year", "Passes Attempted", "Completion Percentage");
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter year: ");
      int date = keyboard.nextInt();
      Stats bestGuy = getBest(allQuarterbacks, date);
      System.out.println(bestGuy);
   }   

      public Stats(String n, String t, int y, int a, double p){
            this.name = n;
            this.team = t;
            this.year = y;
            this.attempts = a;
            this.percent = p;               
      }
       
      public static Stats getBest(ArrayList<Stats> allQuarterbacks, int date){
          int temp = 0;  
          for(int col = 0; col < allQuarterbacks.size(); col ++){
            if(allQuarterbacks.get(col).attempts >= 100 && allQuarterbacks.get(temp).percent < allQuarterbacks.get(col).percent && allQuarterbacks.get(col).year == date) {
               temp = col;               
            }
         }
         return allQuarterbacks.get(temp);
       }        
                 
      public String toString(){
              return "The Quarterback with the best completion percentage in " + year + " was " + name + " with a completion percent of " + percent + "% on the " + team + ".";
      }
      
      
      
 }

