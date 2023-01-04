import java.util.Scanner;

public class PrecinctProgram {
    public static void main (String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Create a new precinct.");

        System.out.println("Name: ");
        String name = keyboard.nextLine();

        System.out.println("Address: ");
        String address = keyboard.nextLine();

        System.out.println("Population: ");
        int pop = keyboard.nextInt();

//        Precinct worcester12;
//        worcester12 = new Precinct("Worcester12", "130 Winter Street", 1673);

        System.out.println(new Precinct(name, address, pop));
    }
}
