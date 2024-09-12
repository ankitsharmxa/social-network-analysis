import java.util.Scanner;

public class SocialNetworkCLI {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        // Sample user addition
        User alice = new User("1", "Alice");
        User bob = new User("2", "Bob");
        User charlie = new User("3", "Charlie");
        graph.addUser(alice);
        graph.addUser(bob);
        graph.addUser(charlie);
        graph.addConnection(alice, bob);
        graph.addConnection(bob, charlie);

        while (true) {
            System.out.println("\nSocial Network CLI:");
            System.out.println("1. Find shortest path between two users");
            System.out.println("2. Find most connected user");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (option == 1) {
                System.out.println("Enter the names of two users to find the shortest path between them:");
                String name1 = scanner.nextLine();
                String name2 = scanner.nextLine();

                User user1 = graph.getAllUsers().stream().filter(u -> u.getName().equals(name1)).findFirst().orElse(null);
                User user2 = graph.getAllUsers().stream().filter(u -> u.getName().equals(name2)).findFirst().orElse(null);

                if (user1 != null && user2 != null) {
                    List<User> path = SocialNetworkAnalysis.dijkstraShortestPath(graph, user1, user2);
                    System.out.println("Shortest path: " + path);
                } else {
                    System.out.println("One or both users not found.");
                }
            } else if (option == 2) {
                User mostConnected = CentralityMeasures.findMostConnectedUser(graph);
                if (mostConnected != null) {
                    System.out.println("Most connected user: " + mostConnected);
                } else {
                    System.out.println("No users found.");
                }
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
