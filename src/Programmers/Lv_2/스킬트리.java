package Programmers.Lv_2;

public class 스킬트리 {

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]", "");
            boolean flag = true;

            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (skill.charAt(j) != skill_trees[i].charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}
