import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class BFS {

    //Calcula los vertices a los que está conectado
    public static List<Integer> adjVertex(int[][] graph, int vertex) {
        List<Integer> lisAdj = new ArrayList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == vertex && graph[i][j] == 1)
                    lisAdj.add(j);
            }
        }
        return lisAdj;
    }

    public static int calculateBFS(int[][] graph, int vertexStart){
        int BFS = 0;
        //Get vertexList

        int[] vertexList = new int[graph.length];

        for (int i = 0; i < graph.length; i++){
                vertexList[i] = i;
        }

        char[] colorList = new char[graph.length];
        int[] distanceList = new int[graph.length];
        int[] predecesorList = new int[graph.length];

        for (int i = 0; i < vertexList.length; i++) {
            colorList[i] = 'w';
            distanceList[i] = 0;
            predecesorList[i] = 0;
        }

        colorList[vertexStart] = 'g';
        predecesorList[vertexStart] = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(vertexStart);

        while (queue.size() > 0){
            int u = queue.poll();

            List<Integer> vertexListSrc = adjVertex(graph, u);

            //Go over vertexList
            for (Integer v : vertexListSrc) {
                if(colorList[v]=='w')
                {
                    colorList[v] = 'g';
                    distanceList[v] = distanceList[u] +1;
                    predecesorList[v] = u;
                    queue.offer(v);
                }
            }
            colorList[u] = 'b';
        }

        System.out.println("Distance List: " +Arrays.toString(distanceList));
        System.out.println("Predecesor List: "+Arrays.toString(predecesorList));
        System.out.println("Vertex List: "+Arrays.toString(vertexList));

        return distanceList[vertexStart];

    }

    public static void main(String[] args) {

        //Matrix Representation Graph

        int numColums = 8;
        int numRows = 8;
        int[][] graph = new int[numRows][numColums];

        graph[0][0] = 0;
        graph[0][1] = 1;
        graph[0][2] = 0;
        graph[0][3] = 0;
        graph[0][4] = 1;
        graph[0][5] = 0;
        graph[0][6] = 0;
        graph[0][7] = 0;

        graph[1][0] = 1;
        graph[1][1] = 0;
        graph[1][2] = 0;
        graph[1][3] = 0;
        graph[1][4] = 0;
        graph[1][5] = 1;
        graph[1][6] = 0;
        graph[1][7] = 0;

        graph[2][0] = 0;
        graph[2][1] = 0;
        graph[2][2] = 0;
        graph[2][3] = 1;
        graph[2][4] = 0;
        graph[2][5] = 1;
        graph[2][6] = 1;
        graph[2][7] = 0;

        graph[3][0] = 0;
        graph[3][1] = 0;
        graph[3][2] = 1;
        graph[3][3] = 0;
        graph[3][4] = 0;
        graph[3][5] = 0;
        graph[3][6] = 1;
        graph[3][7] = 1;

        graph[4][0] = 1;
        graph[4][1] = 0;
        graph[4][2] = 0;
        graph[4][3] = 0;
        graph[4][4] = 0;
        graph[4][5] = 0;
        graph[4][6] = 0;
        graph[4][7] = 0;

        graph[5][0] = 0;
        graph[5][1] = 1;
        graph[5][2] = 1;
        graph[5][3] = 0;
        graph[5][4] = 0;
        graph[5][5] = 0;
        graph[5][6] = 1;
        graph[5][7] = 0;

        graph[6][0] = 0;
        graph[6][1] = 0;
        graph[6][2] = 1;
        graph[6][3] = 1;
        graph[6][4] = 0;
        graph[6][5] = 1;
        graph[6][6] = 0;
        graph[6][7] = 1;

        graph[7][0] = 0;
        graph[7][1] = 0;
        graph[7][2] = 0;
        graph[7][3] = 1;
        graph[7][4] = 0;
        graph[7][5] = 0;
        graph[7][6] = 1;
        graph[7][7] = 0;

        System.out.println(calculateBFS(graph,1));


    }
}
