import java.util.*;

public class CentralityMeasures {

    public static User findMostConnectedUser(Graph graph) {
        User mostConnected = null;
        int maxConnections = -1;

        for (User user : graph.getAllUsers()) {
            int connectionsCount = graph.getConnections(user).size();
            if (connectionsCount > maxConnections) {
                maxConnections = connectionsCount;
                mostConnected = user;
            }
        }
        return mostConnected;
    }
}
