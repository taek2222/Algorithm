import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int answer;
    static boolean[] visit;
    static List<List<Product>> products;

    static class Product {
        int next;
        String direction;

        public Product(final int next, final String direction) {
            this.next = next;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        products = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            products.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int productValue1 = Integer.parseInt(st.nextToken());
            int productValue2 = Integer.parseInt(st.nextToken());

            Product product1 = new Product(productValue2, "<");
            Product product2 = new Product(productValue1, ">");
            products.get(productValue1).add(product1);
            products.get(productValue2).add(product2);
        }
        
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            answer = 0;
            dfs(i, null);

            System.out.println(N - answer - 1);
        }
    }

    private static void dfs(int next, String direction) {
        visit[next] = true;
        List<Product> values = products.get(next);

        for (Product value : values) {
            if (visit[value.next]) {
                continue;
            }

            if (direction == null) {
                answer++;
                dfs(value.next, value.direction);
                continue;
            }

            if (value.direction.equals(direction)) {
                answer++;
                dfs(value.next, direction);
            }
        }
    }
}
