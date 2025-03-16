package Programmers.Lv_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 숫자_문자열과_영단어 {

    public static void main(String[] args) {

    }

    public static int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        List<String> list = new ArrayList<>(map.keySet());
        for (String str : list) {
            s = s.replace(str, map.get(str));
        }
        return Integer.parseInt(s);
    }
}
