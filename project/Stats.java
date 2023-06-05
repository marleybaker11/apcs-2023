package project;
 import core.data.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
 import java.util.Scanner;
public class Stats{
      
      private String name;
      private String team;
      private int year;
      private int attempts;
      private double percent;
      private static int date;
      
   public static void main (String args[]) throws IOException{
      DataSource ds = DataSource.connect("Career_Stats_Passing.csv");
      ds.load();
      ArrayList<Stats> allQuarterbacks = ds.fetchList("Stats", "Name", "Team", "Year", "Passes Attempted", "Completion Percentage");
           // find earliest and latest year
           int earliest = allQuarterbacks.get(0).year;
           int latest = allQuarterbacks.get(0).year;
           for (Stats qb : allQuarterbacks) {
              if (qb.year < earliest)
                 earliest = qb.year;
              if (qb.year > latest)
                 latest = qb.year;
           }
     
           // find best QB for each year
           ArrayList<Stats> bestGuys = new ArrayList<Stats>();
           for (int year = earliest; year <= latest; year++) {
              Stats bestGuy = getBest(allQuarterbacks, year);
              if(bestGuy != null){
               bestGuys.add(bestGuy);
              }
           }
           // duymp the data to a csv file
           FileWriter csvWriter = new FileWriter("best.csv");
           csvWriter.append("Name");
           csvWriter.append(",");
           csvWriter.append("Team");
           csvWriter.append(",");
           csvWriter.append("Year");
           csvWriter.append(",");
           csvWriter.append("Attempts");
           csvWriter.append(",");
           csvWriter.append("Percent");
           csvWriter.append("\n");
     
           for (Stats guy : bestGuys) {
              csvWriter.append("\"" + guy.name + "\"");
              csvWriter.append(",");
              csvWriter.append(guy.team);
              csvWriter.append(",");
              csvWriter.append(String.valueOf(guy.year));
              csvWriter.append(",");
              csvWriter.append(String.valueOf(guy.attempts));
              csvWriter.append(",");
              csvWriter.append(String.valueOf(guy.percent));
              csvWriter.append("\n");
           }
     
           csvWriter.flush();
           csvWriter.close();
      // Scanner keyboard = new Scanner(System.in);
      // System.out.print("Enter year: ");
      // int date = keyboard.nextInt();
      // Stats bestGuy = getBest(allQuarterbacks, date);
      // System.out.println(bestGuy);
   }   

      public Stats(String n, String t, int y, int a, double p){
            this.name = n;
            this.team = t;
            this.year = y;
            this.attempts = a;
            this.percent = p;               
      }
       
      public static Stats getBest(ArrayList<Stats> allQuarterbacks, int date){
          int temp = -1;  
          for(int col = 0; col < allQuarterbacks.size(); col ++){
            if(allQuarterbacks.get(col).attempts >= 100 && (temp == -1 || allQuarterbacks.get(temp).percent < allQuarterbacks.get(col).percent) && allQuarterbacks.get(col).year == date) {
               temp = col; 
            }
         }
         if(temp == -1){
            return null;
         }
         else {
            return allQuarterbacks.get(temp);
         }
      }        
                 
      public String toString(){
              return "The Quarterback with the best completion percentage in " + year + " was " + name + " with a completion percent of " + percent + "% on the " + team + ".";
      }
      
      
      
 }

