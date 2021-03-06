package CodingTestPreparationSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 이해가 60%정도 간다....
public class 퇴사_DP_14501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N + 1];
		int[] price = new int[N + 1];
		int[] dp = new int[N + 5];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i=0; i<N; i++) {
			// i일까지 일했을 최대이익값으로 dp[i]도 새로 갱신해줌
			dp[i] = Math.max(dp[i], max); // 이전에 dp[time[i]+i]로 값이 있을수도 있으니
			// 원래값 vs 이번 움직임으로 생긴 최대 수익
			dp[time[i]+i] = Math.max(dp[time[i]+i], price[i] + dp[i]);
			// i일까지 일했을 때 최대이익
			max = Math.max(max, dp[i]);
		}
		
		for (int i=0; i<=N; i++)
			System.out.print(dp[i]+" ");
		System.out.println();
		
	}

}
