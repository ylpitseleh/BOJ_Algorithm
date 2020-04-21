package Graph_and_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class notepad {
	static int N, M;
	static int map[][];
	static int dist[][];
	static PriorityQueue<Pos> pq = new PriorityQueue<>();
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		int cost;
		Pos (int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pos p) {
			return this.cost < p.cost ? -1 : 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		// 거리값에 무한대 지정
		for (int i=0; i<N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		bfs(0, 0);
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(dist[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(dist[N-1][M-1]);
	}	
	
	public static void bfs (int startY, int startX) {
		pq.add(new Pos(startY, startX, 0));
		
		while (!pq.isEmpty()) {
			Pos p = pq.poll();
			dist[0][0] = 0;
			if (p.y == N && p.x == M) 
				return ;
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue ;
				if (dist[ny][nx] > dist[p.y][p.x] + map[ny][nx]) {
					dist[ny][nx] = dist[p.y][p.x] + map[ny][nx];
					pq.add(new Pos(ny, nx, dist[ny][nx]));
				}
			}
		}
	}
	

}
