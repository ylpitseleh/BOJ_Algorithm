import java.io.*;
import java.lang.Math;

public class hm_골드바흐의_추측 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			System.out.print(n + " = ");

			int n1 = 0;
			int n2 = 0;
			for (int i = 3; i <= n / 2; i++) {
				if (isPrime(i))
					n1 = i;
				else
					continue;
				for (int j = n - 1; j >= i; j--) {
					if (isPrime(j))
						n2 = j;
					else
						continue;

					if (n1 + n2 == n) {
						System.out.println(n1 + " + " + n2);
						i = 2147483646;
						j = -2147483647;
					} else if (n1 + n2 < n)
						j = -2147483647;
				}
			}
			if (n1 % 2 != 1 || n2 % 2 != 1)
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return (false);

		int nearest_sqrt = (int) (Math.sqrt((double) n));
		nearest_sqrt += 1;
		for (int i = 2; i < nearest_sqrt; i++) {
			if (n % i == 0)
				return (false);
		}
		return (true);
	}
}
