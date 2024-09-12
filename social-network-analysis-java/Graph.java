import java.util.*;

public class Graph {
    private Map<User, List<User>> adjacencyList = new HashMap<>();

    public void addUser(User user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addConnection(User user1, User user2) {
        adjacencyList.putIfAbsent(user1, new ArrayList<>());
        adjacencyList.putIfAbsent(user2, new ArrayList<>());
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);  // Assuming an undirected graph
    }

    public List<User> getConnections(User user) {
        return adjacencyList.getOrDefault(user, new ArrayList<>());
    }

    public Set<User> getAllUsers() {
        return adjacencyList.keySet();
    }
}
