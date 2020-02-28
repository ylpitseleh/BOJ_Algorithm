import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class notepad {
	static int max;
	static int min;
	static int N;
	static int[] a;
	static int[] op;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[4];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st1.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		solve(1, a[0]);
		System.out.println(max);
		System.out.println(min);	
	}

	public static void solve(int depth, int sum) {
		if(depth >= N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			if (op[i] == 0)
				continue;
			op[i]--;
			switch(i) {
			case 0:
				solve(depth+1 , sum + a[depth]);
				break;
			
			}
			
		}
	}
		
	
}
