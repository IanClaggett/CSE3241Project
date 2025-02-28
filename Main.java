import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        CommunityMember memberTable = new CommunityMember();
        Equipment equipmentTable = new Equipment();
        while (!exit) {
            System.out.println("-------------------------------------------");
            System.out.println("Select a table to view/edit:");
            System.out.println("[0] Community Member");
            System.out.println("[1] Equipment");
            System.out.println("[q] Quit");
            System.out.println("-------------------------------------------");
            String selection = input.nextLine();

            switch (selection) {
                case "0":
                    memberTable.communityMembers(input);
                    break;
                case "1":
                    equipmentTable.equipmentItems(input);
                    break;
                case "q":
                    exit = !exit;
                    break;
                default:
                    System.out.println("Invalid character: " + selection + ", enter a new value");
                    System.out.println();
                    break;
            }
        }

        input.close();
    }
}
