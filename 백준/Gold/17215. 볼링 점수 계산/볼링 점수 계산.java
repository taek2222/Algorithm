import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {

    private static HashMap<Integer, Integer> bonusBoard;
    private static int[] scoreArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int frame = 1; // 프레임 1번 시작
        bonusBoard = new HashMap<>();
        scoreArray = new int[15];
        int playCount = 0;
        int totalScore = 0;
        String[] scoreboard = br.readLine().split("");
        for (String score : scoreboard) {
            playCount++;

            if (frame > 10) {
                totalScore = scoreArray[frame - 1];
            }

            int parseScore = parseScore(score, totalScore);
            processBonusScore(parseScore);

            if (frame < 10) {
                totalScore += parseScore;
            } else {
                totalScore = parseScore;
            }

            if (score.equals("S") && frame < 10) {
                bonusBoard.put(frame, 2);
                playCount++;
            }

            if (score.equals("P") && frame < 10) {
                bonusBoard.put(frame, 1);
            }

            if (playCount == 2 || frame >= 10) {
                scoreArray[frame] = totalScore;
                frame++;
                totalScore = 0;
                playCount = 0;
            }
        }

        int answer = 0;
        for (int score : scoreArray) {
            answer += score;
        }

        System.out.println(answer);
    }

    private static int parseScore(String input, int score) {
        return switch (input) {
            case "S" -> 10;
            case "P" -> 10 - score;
            case "-" -> 0;
            default -> Integer.parseInt(input);
        };
    }

    private static void processBonusScore(int score) {
        HashMap<Integer, Integer> bonusBoardClone = new HashMap<>(bonusBoard);
        for (Map.Entry<Integer, Integer> entry : bonusBoardClone.entrySet()) {
            int frame = entry.getKey();
            int bonusCount = entry.getValue();

            scoreArray[frame] += score;
            bonusCount--;

            if (bonusCount == 0) {
                bonusBoard.remove(frame);
                continue;
            }
            bonusBoard.put(frame, bonusCount);
        }
    }
}