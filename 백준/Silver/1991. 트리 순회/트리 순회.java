import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static class Node {
        private char value;
        private Node left;
        private Node right;

        public Node(final char value) {
            this.value = value;
        }
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (nodes[root - 65] == null) {
                nodes[root - 65] = new Node(root);
            }

            if (left != '.') {
                nodes[left - 65] = new Node(left);
                nodes[root - 65].left = nodes[left - 65];
            }

            if (right != '.') {
                nodes[right - 65] = new Node(right);
                nodes[root - 65].right = nodes[right - 65];
            }
        }

        preorder(nodes[0]);
        System.out.println();

        inorder(nodes[0]);
        System.out.println();

        postorder(nodes[0]);
        System.out.println();
    }
}
