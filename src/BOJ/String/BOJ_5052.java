package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_5052 {

    static int T, N;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        // 라이브러리 사용
//        while (T-- > 0) {
//            N = Integer.parseInt(br.readLine());
//            list = new ArrayList<>();
//
//            for (int i = 0; i < N; i++) {
//                list.add(br.readLine());
//            }
//
//            Collections.sort(list);
//            if (isStartWith()) {
//                sb.append("NO").append('\n');
//            } else {
//                sb.append("YES").append('\n');
//            }
//        }
//        System.out.print(sb);
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            Trie trie = new Trie();

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                list.add(str);
                trie.insert(str);
            }

            boolean isContain = false;
            for (String str : list) {
                if (trie.search(str)) {
                    isContain = true;
                    break;
                }
            }
            if (isContain) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static boolean isStartWith() {
        for (int i = 0; i < N - 1; i++) {
            if (list.get(i + 1).startsWith(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    static class Trie {
        Node root = new Node();

        // save
        void insert(String str) {
            Node node = this.root;

            // 문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크, 없으면 생성
            for (int i = 0; i < str.length(); i++) {
                node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
            }
            node.endOfWord = true;
        }

        boolean search(String str) {
            Node node = this.root;

            for (int i = 0; i < str.length(); i++) {
                node = node.childNode.getOrDefault(str.charAt(i), null);
                if (node == null) {
                    return false;
                }
            }

            // 해당 단어로 죵료하는 문자가 있는 경우 중 자기 자신과 같은 단어일 경우는 false(조건에서 전화번호가 완전 같은 두 값은 존재하지 않는다고 함)
            if (node.endOfWord) {
                if(node.childNode.isEmpty()) {
                    return false;
                }
            }

            return node.endOfWord;
        }
    }

    static class Node {
        // childNode
        Map<Character, Node> childNode = new HashMap<>();
        boolean endOfWord;
    }
}
