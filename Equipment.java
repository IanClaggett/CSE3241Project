import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Scanner;

public class Equipment {

    public Map<Integer, String[]> equipment = new HashMap<>();
    public int count = 0;

    public void equipmentItems(Scanner input) {
        boolean exit = false;
        while (!exit) {
            System.out
                    .println("--------------------------------------------------------------------------------------");
            System.out.println("Select an action:");
            System.out.println("[0] view equipment");
            System.out.println("[1] add equipment");
            System.out.println("[2] delete equipment");
            System.out.println("[3] search equipment");
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
        String type, model, year, serialNumber, status, location, warranty, droneID, warehouseID, weight, purchase,
                dimensions, manufacturer;
        System.out.println("Enter a type");
        type = input.nextLine();
        System.out.println("Enter a model");
        model = input.nextLine();
        System.out.println("Enter a year");
        year = input.nextLine();
        System.out.println("Enter a serial number");
        serialNumber = input.nextLine();
        System.out.println("Enter status");
        status = input.nextLine();
        System.out.println("Enter a location");
        location = input.nextLine();
        System.out.println("Enter an warranty expiration");
        warranty = input.nextLine();
        System.out.println("Enter a drone ID");
        droneID = input.nextLine();
        System.out.println("Enter a warehouseID");
        warehouseID = input.nextLine();
        System.out.println("Enter a weight");
        weight = input.nextLine();
        System.out.println("Enter a purchase order");
        purchase = input.nextLine();
        System.out.println("Enter dimensions");
        dimensions = input.nextLine();
        System.out.println("Enter a manufacturer");
        manufacturer = input.nextLine();
        String[] answers = { type, model, year, serialNumber, status, location, warranty, droneID, warehouseID, weight,
                purchase, dimensions, manufacturer };
        equipment.put(count, answers);
        count++;
    }

    public void viewMember() {
        if (equipment.size() != 0) {
            equipment.forEach((index, info) -> {
                System.out.println("User ID: " + index + " " + Arrays.toString(info));
            });
        } else {
            System.out.println("There are no members currently");
        }
    }

    public void deleteMember(Scanner input) {
        if (equipment.size() > 0) {
            viewMember();
            System.out.println("Enter the index of the tuple you would like to delete: ");
            String removal = input.nextLine();
            if (Integer.parseInt(removal) < equipment.size()) {
                equipment.remove(Integer.parseInt(removal));
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
        if (equipment.containsKey(Integer.parseInt(query))) {
            System.out.println("Index: " + query + ", " + Arrays.toString(equipment.get(Integer.parseInt(query))));
        } else {
            System.out.println("Invalid index, returning to menu");
        }
    }
}
