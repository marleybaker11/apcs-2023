public class PiDay {
    public static void main(String[] args) {
        System.out.println();
    }
    public static double piday(int n, boolean subract){
        if(n >= 1000){
            return 0;
        }else{
            if(subract == true){
                return -4.0/n + piday(n+2, false);

            }else{
                return 4.0/n + piday(n+2, true);

            }
            
        }
    public static void main(String[] args) {
        double pi = piday(1, false);  
        System.out.println("pi +" + pi);
    
    }
}