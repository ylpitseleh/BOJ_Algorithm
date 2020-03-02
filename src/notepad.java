import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class notepad {
	static int N;
	static int M;
	static boolean visited[];
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //1부터 N까지 자연수 중
		M = Integer.parseInt(st.nextToken()); //중복 없이 M개를 고른 수열
		visited = new boolean[N];
		arr = new int[N];
		recur(0);
	}
	public static void recur (int depth) {
		if (depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return ;
		}
		
		for (int i=1; i<=N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			arr[depth] = i;
			recur(depth + 1);
			visited[i] = false;
		}
	}

}
