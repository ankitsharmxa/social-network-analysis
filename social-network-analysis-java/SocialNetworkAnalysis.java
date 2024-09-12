import java.util.*;

public class SocialNetworkAnalysis {

    public static List<User> dijkstraShortestPath(Graph graph, User start, User end) {
        Map<User, Integer> distances = new HashMap<>();
        Map<User, User> previous = new HashMap<>();
        PriorityQueue<User> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (User user : graph.getAllUsers()) {
            distances.put(user, Integer.MAX_VALUE);
            previous.put(user, null);
        }
        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            User current = queue.poll();
            int currentDistance = distances.get(current);

            if (current.equals(end)) {
                break;
            }

            for (User neighbor : graph.getConnections(current)) {
                int newDistance = currentDistance + 1; // Assuming each connection has equal weight

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<User> path = new ArrayList<>();
        for (User at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path.size() > 1 ? path : Collections.emptyList();
    }
}
