package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

    static class QueueEntry{
        int vertex;
        int distance;
    }

    static int minThrow(int N, int board[]){
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }

        Queue<QueueEntry> q = new LinkedList<>();

        visited[0] = true;
        QueueEntry s = new QueueEntry();
        s.distance = 0;
        s.vertex = 0;
        q.add(s);

        QueueEntry qe = new QueueEntry();

        while (!q.isEmpty()) {

            qe = q.peek();
            int vertex = qe.vertex;

            if (vertex == N - 1){
                break;
            }

            q.remove();
            for (int i = vertex + 1; i <= (vertex + 6) && i < N; ++i) {

                if (!visited[i]) {

                    QueueEntry cell = new QueueEntry();
                    cell.distance = (qe.distance + 1);
                    visited[i] = true;
                    if (board[i] != -1){

                        cell.vertex = board[i];

                    }else{

                        cell.vertex = i;

                    }
                    q.add(cell);

                }
            }
        }

        return qe.distance;
    }

    public static void main(String[] args) {
        int N = 30; // number of cells
        int[] board = new int[N];
        for (int i = 0; i < N; i++)
            board[i] = -1;

        // Ladders
        board[2] = 21;
        board[4] = 7;
        board[10] = 25;
        board[19] = 28;

        // Snakes
        board[26] = 0;
        board[20] = 8;
        board[16] = 3;
        board[18] = 6;

        System.out.println("Minimum number of controlled dice throws are: "
                + minThrow(N, board));
    }
}
