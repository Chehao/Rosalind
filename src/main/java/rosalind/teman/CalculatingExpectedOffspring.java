package rosalind.teman;

public class CalculatingExpectedOffspring {
	public static void main(String[] args) {
		int[] input = new int[] {19645, 17405, 17256, 17286, 19692, 19216};
		float Eofx = input[0] * 1f + input[1] * 1f + input[2] * 1f + input[3]
				* 0.75f + input[4] * 0.5f + input[5] * 0f;
		System.out.println(Eofx+Eofx);
	}
}
