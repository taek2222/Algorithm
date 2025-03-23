import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static class People implements Comparable {
        private final int weight;
        private final int height;

        public People(final int weight, final int height) {
            this.weight = weight;
            this.height = height;
        }

        public int comparison(final People other) {
            if (this.compareTo(other) < 0) {
                return 1;
            }
            return 0;
        }

        @Override
        public int compareTo(final Object o) {
            final People other = (People) o;

            if (this.height > other.height && this.weight < other.weight) {
                return 0;
            }

            if (this.height < other.height && this.weight > other.weight) {
                return 0;
            }

            if (this.height < other.height && this.weight < other.weight) {
                return -1;
            }

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<People> peoples = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            People people = new People(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            peoples.add(people);
        }

        for (int i = 0; i < peoples.size(); i++) {
            People comparePeople = peoples.get(i);
            int rank = 1;
            for (int j = 0; j < peoples.size(); j++) {
                int comparison = comparePeople.comparison(peoples.get(j));
                rank += comparison;
            }
            bw.append(String.valueOf(rank)).append(" ");
        }

        br.close();
        bw.close();
    }
}
