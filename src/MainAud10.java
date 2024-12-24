import aud10.AdjacencyListGraph;
import aud10.AdjacencyMatrixGraph;

import java.util.*;

public class MainAud10 {

    static String input =
            """
                    9
                    A B C D E F G H Z
                    13
                    A B
                    B F
                    A E
                    A C
                    C D
                    D F
                    D G
                    C G
                    E F
                    E H
                    H Z
                    Z F
                    Z G
                    
                    E G
                    3
                    """;

    public static void main(String[] args) {
//        matrixGraphTester();
//        adjacencyGraphTester();
        bfsTest();
    }

    private static void bfsTest() {
        Scanner scanner = new Scanner(input);

        AdjacencyListGraph<String> list_graph =
                new AdjacencyListGraph<>();
        scanner.nextLine();
        scanner.nextLine();
        int edges = scanner.nextInt();
        for (int i = 0; i < edges; i++) {
            String from = scanner.next();
            String to = scanner.next();
            list_graph.addEdge(from, to);
        }
        String startingVertex = scanner.next();
        String endVertex = scanner.next();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startingVertex);
        visited.add(startingVertex);
        int rastojanie = 0;
        boolean found = false;
        while (!queue.isEmpty()) {
            int kolku = queue.size();
            for (int i = 0; i < kolku; i++) {
                String nextVertex = queue.poll();
                if (nextVertex.equals(endVertex)) {
                    found = true;
                    break;
                }
                for (String neighbor : list_graph.getNeighbors(nextVertex)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            if (found) break;
            rastojanie++;
        }

        if (found) System.out.println("Rastojanieto e " + rastojanie);
        else System.out.println("Nema pateka");

        int targetDistance = scanner.nextInt();
        DFSUtil(list_graph, startingVertex, new HashSet<>(), 0, targetDistance, new ArrayList<>());

    }

    private static void DFSUtil(AdjacencyListGraph<String> graph, String vertex, Set<String> visited, int distance, int targetDistance, List<String> path) {
        // Mark the current node as visited and print it
        visited.add(vertex);
        path.add(vertex);

        if (distance == targetDistance) {
            System.out.println("Na rastojanie " + targetDistance + " se naogja " + vertex + " the path is " + path);
        } else

            // Recur for all the vertices adjacent to this vertex
            for (String neighbor : graph.getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    DFSUtil(graph, neighbor, visited, distance + 1, targetDistance, path);
                }
            }
        visited.remove(vertex);
        path.removeLast();
    }


    private static void adjacencyGraphTester() {
        Scanner scanner = new Scanner(input);

        AdjacencyListGraph<String> list_graph =
                new AdjacencyListGraph<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
        }
        int edges = scanner.nextInt();
        for (int i = 0; i < edges; i++) {
            String from = scanner.next();
            String to = scanner.next();

            list_graph.addEdge(from, to);
        }
        System.out.println(list_graph);
    }

    private static void matrixGraphTester() {
        Scanner scanner = new Scanner(input);

        AdjacencyMatrixGraph<String> matrix_graph =
                new AdjacencyMatrixGraph<>(9);
        int n = scanner.nextInt();
        Map<String, Integer> name_to_index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            matrix_graph.addVertex(i, name);
            name_to_index.put(name, i);
        }
        int edges = scanner.nextInt();
        for (int i = 0; i < edges; i++) {
            String from = scanner.next();
            String to = scanner.next();
            Integer index_from = name_to_index.get(from);
            Integer index_to = name_to_index.get(to);

            matrix_graph.addEdge(index_from, index_to);
        }

        System.out.println(matrix_graph);
        AdjacencyListGraph<String> list_graph =
                matrixGraphToListGraph(matrix_graph);
        System.out.println(list_graph);

    }

    private static AdjacencyListGraph<String> matrixGraphToListGraph(AdjacencyMatrixGraph<String> matrixGraph) {
        AdjacencyListGraph<String> listGraph = new AdjacencyListGraph<>();
        for (int i = 0; i < matrixGraph.numVertices; i++) {
            String vertex = matrixGraph.getVertex(i);
            listGraph.addVertex(vertex);
        }
        for (int i = 0; i < matrixGraph.numVertices; i++) {
            String vertex = matrixGraph.getVertex(i);
            List<String> neighbors = matrixGraph.getNeighbors(i);
            for (String neighbor : neighbors) {
                listGraph.addEdge(vertex, neighbor);
            }
        }
        return listGraph;
    }

}

class MazeZadaca {
    static String vlez = """
            6,6
            ######
            # # ##
            # # S#
            # # ##
            # E  #
            ######
            """;

    public static void main(String[] args) {
        Scanner sc = new Scanner(vlez);
        String[] strings = sc.nextLine().split(",");
        int n = Integer.parseInt(strings[0]), m = Integer.parseInt(strings[1]);
        char[][] matrica = new char[n][m];
        for (int red = 0; red < n; red++) {
            String linija = sc.nextLine();
            matrica[red] = linija.toCharArray();
        }
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        String start = "", end = "";
        for (int red = 0; red < n; red++) {
            for (int kol = 0; kol < m; kol++) {
                if (matrica[red][kol] == '#') continue;
                if (matrica[red][kol] == 'S') start = red + "," + kol;
                if (matrica[red][kol] == 'E') end = red + "," + kol;
                graph.addVertex(red + "," + kol);
                if (matrica[red - 1][kol] != '#')
                    graph.addEdge(red + "," + kol, (red - 1) + "," + kol);
                if (matrica[red][kol - 1] != '#')
                    graph.addEdge(red + "," + kol, red + "," + (kol - 1));

            }
        }
        System.out.println(graph);
        List<String> result = our_DFS(graph, start, end);
        System.out.println(result);

    }

    private static List<String> our_DFS(AdjacencyListGraph<String> graph, String start, String end) {
        return DFS_r(start, new ArrayList<>(), graph, new HashSet<>(), end);
    }

    private static List<String> DFS_r(String current, List<String> current_path, AdjacencyListGraph<String> graph, Set<String> visited, String target) {
        if (visited.contains(current)) return List.of();
        visited.add(current);
        current_path.add(current);
        if (current.equals(target)) return current_path;
        for (String neighbor : graph.getNeighbors(current)) {
            List<String> result = DFS_r(neighbor, current_path, graph, visited, target);
            if (!result.isEmpty()) return result;
        }
        current_path.remove(current);
        return List.of();
    }
}





