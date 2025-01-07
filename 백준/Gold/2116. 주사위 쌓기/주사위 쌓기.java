import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static HashMap<Integer, Integer> diceBothSides = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int diceCount = Integer.parseInt(br.readLine());
        List<List<Integer>> dices = new ArrayList<>();
        initDiceBothSide();
        initDices(diceCount, br, dices);

        int result = 0;
        for (int i = 0; i < 6; i++) {
            int bottomNumber = dices.get(0).get(i);
            int value = 0;
            for (int j = 0; j < diceCount; j++) {
                List<Integer> dice = new ArrayList<>(dices.get(j));

                int bottomPos = dice.indexOf(bottomNumber);
                int topNumber = dice.get(diceBothSides.get(bottomPos));

                dice.remove(dice.get(bottomPos));
                dice.remove((Integer) topNumber);

                Integer max = dice.stream()
                        .max(Integer::compareTo)
                        .orElseThrow();

                value += max;

                bottomNumber = topNumber;
            }

            if (result < value) {
                result = value;
            }
        }

        System.out.println(result);
    }

    private static void initDices(final int diceCount, final BufferedReader br, final List<List<Integer>> dices) throws IOException {
        for (int i = 0; i < diceCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> dice = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                dice.add(Integer.parseInt(st.nextToken()));
            }
            dices.add(dice);
        }
    }

    private static void initDiceBothSide() {
        diceBothSides.put(0, 5);
        diceBothSides.put(1, 3);
        diceBothSides.put(2, 4);
        diceBothSides.put(3, 1);
        diceBothSides.put(4, 2);
        diceBothSides.put(5, 0);
    }
}