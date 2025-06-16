import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    static BufferedWriter bw;
    static int[] heap;
    static int size;

    static void insert(int number) {
        heap[size] = number;
        heapifyUp();
        size++;
    }

    static void heapifyUp() {
        int index = size;
        while (true) {
            int parentIndex = (index - 1) / 2;

            if (parentIndex >= 0 && heap[parentIndex] > heap[index]) {
                swap(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    static void poll() throws IOException {
        if (size == 0) {
            bw.append("0").append("\n");
            return;
        }

        int minNode = heap[0];
        bw.append(String.valueOf(minNode)).append("\n");

        heap[0] = heap[size - 1]; // 루트 노드로 이동
        heap[size - 1] = 0;
        size--;

        heapifyDown();
    }

    static void heapifyDown() {
        int index = 0;
        while (true) {
            int leftNode = index * 2 + 1;
            int rightNode = index * 2 + 2;
            int smallNode = index;

            if (leftNode < size && heap[leftNode] < heap[smallNode]) {
                smallNode = leftNode;
            }

            if (rightNode < size && heap[rightNode] < heap[smallNode]) {
                smallNode = rightNode;
            }

            if (smallNode != index) {
                swap(index, smallNode);
                index = smallNode;
            } else {
                break;
            }
        }
    }

    static void swap(int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = 0;

        int N = Integer.parseInt(br.readLine());
        heap = new int[N];

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                poll();
                continue;
            }

            insert(number);
        }

        bw.flush();
    }
}
