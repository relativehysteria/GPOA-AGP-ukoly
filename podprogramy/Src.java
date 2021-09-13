public class Src {
	public static void main(String[] args) {
		int num = 7;
		int max = 101;

		int[] arr = new int[num];

		// https://en.wikipedia.org/wiki/Xorshift
		for (int i = 0; i < num; i++) {
			long rand = (long) (Math.random() * (double) (max));

			rand ^= rand <<  13;
			rand ^= rand >>> 17;
			rand ^= rand <<   5;

			arr[i] = (int) (rand % (long) max);
		}

		vypis(arr);
	}

	static void vypis(int[] arr) {
		System.out.print("Moje pole je:\n\t");
		for (int i : arr) {
			System.out.print(i + ";\t");
		}

		System.out.print("\nSoucet je: " + soucet(arr));
		System.out.print("\nPrumer je: " + prumer(arr));
		System.out.println();
	}

	static long soucet(int[] arr) {
		long sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	static double prumer(int[] arr) {
		return (double) soucet(arr) / (double) arr.length;
	}
}
