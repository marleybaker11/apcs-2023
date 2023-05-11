/*
Marley Baker
1/30/23
Activity 4
 */
 import core.data.*;
 import java.util.ArrayList;
public class Stats{
      
      private String name;
      private String team;
      private int year;
      private int attempts;
      private double percent;
      
   public static void main (String args[]){
      DataSource ds = DataSource.connect("Career_Stats_Passing.csv");
      ds.load();
      ArrayList<Stats> allQuarterbacks = ds.fetchList("Stats", "Name", "Team", "Year", "Passes Attempted", "Completion Percentage");
      System.out.println(allQuarterbacks.size());
      Stats bestGuy = getBest(allQuarterbacks);
      System.out.println(bestGuy);
     }   
      public Stats(String n, String t, int y, int a, double p){
            this.name = n;
            this.team = t;
            this.year = y;
            this.attempts = a;
            this.percent = p;               
      }
       public static Stats getBest(ArrayList<Stats> allQuarterbacks){
            for(int col = 0; col < allQuarterbacks.size(); col ++){
            if(allQuarterbacks.get(col).percent == 100) {
                 return allQuarterbacks.get(col);
           
            //if (attempts > 100){
                //return allQuarterbacks;
              
            }
         }
         return null;
       }        
              
      
      
      public String toString(){
              return "The Quarterback with the best completion rate is " + name + "in " + year + " with a completion percent of " + percent + "%.";
      }
      
      
      
 }

