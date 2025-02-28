import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Scanner;

public class CommunityMember {

    public Map<Integer, String[]> community = new HashMap<>();
    public int count = 0;

    public void communityMembers(Scanner input) {
        boolean exit = false;
        while (!exit) {
            System.out
                    .println("--------------------------------------------------------------------------------------");
            System.out.println("Select an action:");
            System.out.println("[0] view members");
            System.out.println("[1] add members");
            System.out.println("[2] delete member");
            System.out.println("[3] search members");
            System.out.println("[r] return");
            System.out
                    .println("--------------------------------------------------------------------------------------");
            String selection = input.nextLine();
            switch (selection) {
                case "0":
                    viewMember();
                    break;
                case "1":
                    addMember(input);
                    break;
                case "2":
                    deleteMember(input);
                    break;
                case "3":
                    searchMember(input);
                    break;
                case "r":
                    exit = !exit;
                    break;
                default:
                    System.out.println("Invalid character: " + selection + ", enter a new value");
                    System.out.println();
                    break;
            }
        }
        return;
    }

    public void addMember(Scanner input) {
        String fname, lname, address, phoneNumber, totalRentals, status, email, startDate, warehouseDistance;
        System.out.println("Enter a first name");
        fname = input.nextLine();
        System.out.println("Enter a last name");
        lname = input.nextLine();
        System.out.println("Enter an address");
        address = input.nextLine();
        System.out.println("Enter a phone number");
        phoneNumber = input.nextLine();
        System.out.println("Enter total rentals");
        totalRentals = input.nextLine();
        System.out.println("Enter a status");
        status = input.nextLine();
        System.out.println("Enter an email");
        email = input.nextLine();
        System.out.println("Enter a start date");
        startDate = input.nextLine();
        System.out.println("Enter a warehouse distance");
        warehouseDistance = input.nextLine();
        String[] answers = { fname, lname, address, phoneNumber, totalRentals, status, email, startDate,
                warehouseDistance };
        community.put(count, answers);
        count++;
    }

    public void viewMember() {
        if (community.size() != 0) {
            community.forEach((index, info) -> {
                System.out.println("User ID: " + index + " " + Arrays.toString(info));
            });
        } else {
            System.out.println("There are no members currently");
        }
    }

    public void deleteMember(Scanner input) {
        if (community.size() > 0) {
            viewMember();
            System.out.println("Enter the index of the tuple you would like to delete: ");
            String removal = input.nextLine();
            if (Integer.parseInt(removal) < community.size()) {
                community.remove(Integer.parseInt(removal));
            } else {
                System.out.println("Invalid index, returning to menu");
            }
        } else {
            System.out.println("There are no members that can be deleted.");
        }

    }

    public void searchMember(Scanner input) {
        System.out.println("Enter an index to search for: ");
        String query = input.nextLine();
        if (community.containsKey(Integer.parseInt(query))) {
            System.out.println("Index: " + query + ", " + Arrays.toString(community.get(Integer.parseInt(query))));
        } else {
            System.out.println("Invalid index, returning to menu");
        }
    }
}
