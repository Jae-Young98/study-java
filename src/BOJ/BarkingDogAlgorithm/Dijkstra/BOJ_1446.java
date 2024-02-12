package BOJ.BarkingDogAlgorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1446 {

    static int N, D;
    static int[] distance;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        distance = new int[D + 1];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int range = Integer.parseInt(st.nextToken());

            if (dest > D) {
                continue;
            }

            if (dest - start > range) {
                list.add(new Node(start, dest, range));
            }
        }
        Collections.sort(list);

        int move = 0;
        int index = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (move < D) {
            if (index < list.size()) {
                Node node = list.get(index);
                if (move == node.start) {
                    distance[node.dest] = Math.min(distance[node.dest], distance[move] + node.range);
                    index++;
                } else {
                    distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                    move++;
                }
            } else {
                distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                move++;
            }
        }
        System.out.println(distance[D]);
    }

    static class Node implements Comparable<Node>{
        int start;
        int dest;
        int range;

        Node(int start, int dest, int range) {
            this.start = start;
            this.dest = dest;
            this.range = range;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start) {
                return this.dest - o.dest;
            }
            return this.start - o.start;
        }
    }
}
