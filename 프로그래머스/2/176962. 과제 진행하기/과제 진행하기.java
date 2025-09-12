import java.util.*;

class Solution {
    private int toMin(String hhmm) {
        String[] sp = hhmm.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparing(p -> toMin(p[1])));

        Deque<String[]> stack = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();

        int cur = toMin(plans[0][1]);

        for (String[] p : plans) {
            int start = toMin(p[1]);
            int gap = start - cur;

            while (gap > 0 && !stack.isEmpty()) {
                String[] top = stack.peek();
                int remain = Integer.parseInt(top[1]);
                if (remain <= gap) {
                    gap -= remain;
                    cur += remain;
                    ans.add(stack.pop()[0]);
                } else {
                    top[1] = String.valueOf(remain - gap);
                    cur += gap;
                    gap = 0;
                }
            }

            stack.push(new String[]{ p[0], p[2] });
            cur = start;
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop()[0]);
        }

        return ans.toArray(new String[0]);
    }
}