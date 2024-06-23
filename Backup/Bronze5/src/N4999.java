import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String man = br.readLine(); // 재환이 음성
        String doctor = br.readLine(); // 의사 원하는 음성

        if(man.length() >= doctor.length()) // 비교
            System.out.print("go");
        else
            System.out.print("no");
    }
}
