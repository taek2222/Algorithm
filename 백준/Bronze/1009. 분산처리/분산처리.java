import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//T값만큼 for문을 반복
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//a의 %10 값을 구하고, 0일경우 10 저장
			if(a % 10 == 0) {
				a = 10;
			}else if(a > 10){
				a = a % 10;
			}
			
			//반복 횟수에 따른 if문
			if(a == 1 || a == 5 || a == 6 || a == 10) {
				System.out.println(a);
			}else if(a == 4 || a == 9) {
				if(b % 2 == 0) {
					System.out.println((int) ((a * a) % 10));
				}else {
					System.out.println(a);
				}
			}else {
				b %= 4;
				if(b == 0) {
					b = 4;
				}
				//2제곱이면 a*a로 충분하지만 횟수가 변하는 값이면 pow나 for문 사용
				System.out.println((int) (Math.pow(a, b) % 10));
			}
		}
	}

}