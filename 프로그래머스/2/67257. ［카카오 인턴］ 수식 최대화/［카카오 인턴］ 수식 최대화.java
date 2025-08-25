import java.util.*;

class Solution {
    long max = 0;
    List<Long> originalNumbers = new ArrayList<>();
    List<String> originalOperators = new ArrayList<>();

    public long solution(String expressions) {
        String number = "";
        for (char e : expressions.toCharArray()) {
            if (e == '*' || e == '-' || e == '+') {
                originalNumbers.add(Long.parseLong(number));
                number = "";
                originalOperators.add(String.valueOf(e));
                continue;
            }
            number += e;
        }
        originalNumbers.add(Long.parseLong(number));

        Set<String> uniqueOperators = new HashSet<>(originalOperators);
        List<String> operatorList = new ArrayList<>(uniqueOperators);

        dfs(operatorList, new boolean[operatorList.size()], new ArrayList<>());

        return max;
    }
    
    public void dfs(List<String> opList, boolean[] visited, List<String> currentPermutation) {
        if (currentPermutation.size() == opList.size()) {
            calculate(currentPermutation);
            return;
        }

        for (int i = 0; i < opList.size(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            currentPermutation.add(opList.get(i));
            dfs(opList, visited, currentPermutation);
            currentPermutation.remove(currentPermutation.size() - 1);
            visited[i] = false;
    }
}

    public void calculate(List<String> precedence) {
        List<Long> numbers = new ArrayList<>(originalNumbers);
        List<String> operators = new ArrayList<>(originalOperators);

        for (String op : precedence) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i).equals(op)) {
                    long num1 = numbers.get(i);
                    long num2 = numbers.get(i + 1);
                    long result = 0;

                    if (op.equals("*")) {
                        result = num1 * num2;
                    } else if (op.equals("+")) {
                        result = num1 + num2;
                    } else if (op.equals("-")) {
                        result = num1 - num2;
                    }

                    numbers.set(i, result);
                    numbers.remove(i + 1);
                    operators.remove(i);
                    i--;
                }
            }
        }
        max = Math.max(max, Math.abs(numbers.get(0)));
    }
}