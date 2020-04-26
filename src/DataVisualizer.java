import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class to get data from the user and then display it in two ways
 */
public class DataVisualizer {

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); //scanner object

        ArrayList<String> inputStrings = new ArrayList<String>(); //arrayList inputStings
        ArrayList<Integer> inputInt = new ArrayList<Integer>(); //arrayList inputInt
        String userInString = "";
        int userInt;
        String userString;

        System.out.println("Enter a title for the data:");
        String dataTitle = scnr.nextLine(); //get Title for the data
        System.out.println("You entered: " + dataTitle);
        System.out.println("\nEnter the column 1 header:");
        String colOneH = scnr.nextLine(); //get the column header
        System.out.println("You entered: " + colOneH);
        System.out.println("\nEnter the column 2 header:");
        String colTwoH = scnr.nextLine(); //get second column header
        System.out.println("You entered: " + colTwoH);

        /**
         * The user is asked to input data until they are done. Then they enter -1 to stop inputting and print the data.
         * The user is asked to input in a specific format. string, int
         */
        while (!userInString.equals("-1")) {
            System.out.println("\nEnter a data point (-1 to stop input):");
            userInString = scnr.nextLine(); //get user input

            if(userInString.equals("-1")){
                break;
            }

            int indexOne = userInString.indexOf(","); //get the index of the comma

            if (indexOne == -1) { //make sure there is a comma
                System.out.println("Error: No comma in string.");
                continue;
            } else { //break the string in two parts (before and after comma)
                userString = userInString.substring(0, indexOne);
                userInString = userInString.substring(indexOne + 1).trim();
            }

            int indexTwo = userInString.indexOf(","); //make sure there are no more commas

            if (indexTwo != -1) {
                System.out.println("Error: Too many commas in input.");
                continue;
            } else if (userInString.matches(".*[a-z].*")) { //see what is after the comma. Want a number (digits) error if contains letters
                System.out.println("Error: Comma not followed by an integer.");
                continue;
            } else {
                userInt = Integer.parseInt(userInString); //change the string to an int

                inputStrings.add(userString);
                inputInt.add(userInt);

                System.out.println("Data string: " + userString);
                System.out.println("Data integer: " + userInt);
            }
        }

        /**
         * Print data in table form
         */
        System.out.printf("\n%33s\n", dataTitle);
        System.out.printf("%-20s|%23s\n", colOneH, colTwoH);
        System.out.println("--------------------------------------------");
        for(int i = 0; i < inputInt.size(); i++){
            System.out.printf("%-20s|%23s\n", inputStrings.get(i), inputInt.get(i));

            //  if(i < inputInt.size() -1){
            //     System.out.printf("%-20s|%23s\n", inputStrings.get(i), inputInt.get(i));
            //  }else{
            //     System.out.printf("%-20s|%23s", inputStrings.get(i), inputInt.get(i));
            //  }
        }

        System.out.println();

        /**
         * Print data in histogram form
         */
        for(int i = 0; i < inputStrings.size(); i++) {
            System.out.printf("%20s ", inputStrings.get(i));
            for(int j = 0; j < inputInt.get(i); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
