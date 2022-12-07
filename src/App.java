import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        String naughtyNiceList[][] = {
            {"LoGaN", "may", "Naughty", "7730 Whitemarsh Court", "deOdeRant"},
            {"Cecilia", "bOYer", "Nice", "8686 Elm St.", "PUddle"},
            {"lorElAi", "moRsE", "Naughty", "8529 Birchpond St.", "TOMAto"},
            {"rory", "black", "Naughty", "39 Fairfield Ave.", "lamp ShaDe"},
            {"Denzel", "SancHez", "", "961 Hanover Ave.", "shOEs"},
            {"maNUEL", "Lambert", "Nice", "698 Arrowhead Rd.", "chArgEr"},
            {"Trinity", "FISHER", "Nice", "49 Arlington Avenue", "winDow"},
            {"maTthiAs", "hayEs", "Nice", "23 Woodside Ave.", "LOTION"},
            {"Sophia", "SToUT", "Naughty", "7640 Andover Dr.", "teddY beAr"},
            {"keNNedy", "Dunlap", "", "63 Cypress Rd.", "pAnts"},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""}
        };

        space(1);

        naughtyNiceList =  formatList(naughtyNiceList);
        printList(naughtyNiceList, "ALL");

        space(1);

        // Accept new comma-delimited entries
        Scanner in = new Scanner(System.in);
        boolean enter = true;
        String[] newEntry;

        while (enter) {

            System.out.println("\nEnter data for a new child separated by commas. (Type \"STOP\" to exit)");

            // Prompt user for new input, store into a String array to be evaluated
            newEntry = updateList(in.nextLine().split(","), naughtyNiceList[0].length);

            // Incorrect length entry
            if (newEntry[0].equals("INVALID")) {
                System.out.println(Colors.ANSI_YELLOW + "Please enter a list of " + naughtyNiceList[0].length + " items." + Colors.ANSI_RESET);
            }

            // Enter data
            else if (newEntry.length == naughtyNiceList[0].length) {
                for (int i = 0; i < naughtyNiceList.length; i++) {
                    // Enter on the first available row
                    if (naughtyNiceList[i][0] == "") {
                        // Store formatted data
                        for (int j = 0; j < naughtyNiceList[i].length; j++) {
                            naughtyNiceList[i][j] = newEntry[j];
                        }
                        // Stop once data has been entered
                        // Prevents filling in every available space
                        break;
                    }
                }
                System.out.println(Colors.ANSI_GREEN + "Data stored." + Colors.ANSI_RESET);
            }

            // Stop data entry
            else if (newEntry[0].toUpperCase().equals("STOP")) {
                System.out.println(Colors.ANSI_BLUE + "Exiting data entry." + Colors.ANSI_RESET);
                enter = false;
            }

        }
        
        space(1);
        printList(naughtyNiceList, "ALL");
        space(1);
        printList(naughtyNiceList, "NAUGHTY");
        space(1);
        printList(naughtyNiceList, "NICE");
        space(1);

        in.close();

    }

    // Naughty/nice list printing method
    // Color coding for naughty, nice, and undetermined
    public static String[][] printList(String[][] list, String listGroup) {

        if (listGroup.equals("ALL")) {

            // Loop through rows
            for (int i = 0; i < list.length; i++) {

                // Check if naughty, nice, or undetermined
                // Looks at the 3rd element of current row
                if (list[i][2].equals("NICE")) {
                    // Green for NICE
                    System.out.print(Colors.ANSI_GREEN);
                }
                else if (list[i][2].equals("NAUGHTY")) {
                    // Red for NAUGHTY
                    System.out.print(Colors.ANSI_RED);
                }
                else {
                    // Yellow for undetermined
                    System.out.print(Colors.ANSI_YELLOW);
                }

                // Loop through columns
                for (int j = 0; j < list[i].length; j++) {

                    System.out.print(list[i][j]);

                    // Printing comma separated elements
                    if (j < list[i].length - 1) {
                        System.out.print(", ");
                    }
                    else {
                        // Close ANSI color
                        System.out.println(Colors.ANSI_RESET);
                    }

                }

            }

        }

        else if (listGroup.equals("NAUGHTY")) {

            // Red for NAUGHTY
            System.out.print(Colors.ANSI_RED);

            // Loop through rows
            for (int i = 0; i < list.length; i++) {
                
                if (list[i][2].equals("NAUGHTY")) {

                    // Loop through columns
                    for (int j = 0; j < list[i].length; j++) {
                        System.out.print(list[i][j]);

                        // Printing comma separated elements
                        if (j < list[i].length - 1) {
                            System.out.print(", ");
                        }
                        else {
                            System.out.println();
                        }

                    }

                }

            }

            System.out.print(Colors.ANSI_RESET);

        }

        else if (listGroup.equals("NICE")) {

            // Green for nice
            System.out.print(Colors.ANSI_GREEN);

            // Loop through rows
            for (int i = 0; i < list.length; i++) {
                
                if (list[i][2].equals("NICE")) {

                    // Loop through columns
                    for (int j = 0; j < list[i].length; j++) {

                        System.out.print(list[i][j]);

                        // Printing comma separated elements
                        if (j < list[i].length - 1) {
                            System.out.print(", ");
                        }
                        else {
                            System.out.println();
                        }

                    }

                }

            }

            System.out.print(Colors.ANSI_RESET);

        }

        return list;

    }
    
    // Formats list with all uppercase letters
    public static String[][] formatList(String[][] list) {

        String formatList[][] = new String[list.length][list[0].length];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                formatList[i][j] = list[i][j].toUpperCase();
            }
        }

        return formatList;

    }
    
    // Enter new data into the list
    public static String[] updateList(String[] entry, int entryLength) {

        String[] formatEntry = new String[entry.length];

        // Proper length entry has been input, return new formatted data row
        if (entryLength == entry.length) {
            for (int i = 0; i < entry.length; i++) {
                // Change gift to coal before storing if naughty
                if (i == 2 && entry[2].toUpperCase().equals("NAUGHTY")) {
                    entry[4] = "COAL";
                }
                // Otherwise, store all other data as normal
                else {
                    formatEntry[i] = entry[i].toUpperCase();
                }
            }
            return formatEntry;
        }

        // Stop data entry, return single element array
        else if (entry[0].toUpperCase().equals("STOP")) {
            return entry;
        }

        // Incorrect length entry
        else {
            String badEntry[] = {"INVALID"};
            return badEntry;
        }
        
    }

    // Print a certain number of newline characters
    public static void space(int numSpaces) {
        for (int i = 1; i <= numSpaces; i++) {
            System.out.println();
        }
    }
    
}
