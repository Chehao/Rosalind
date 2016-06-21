package rosalind.teman;

public class MendelFirstLaw {

	public static void main(String[] args) {
		float k = 23; //23 15 28
		float m = 15;
		float n = 28;
		
		float proKK = k/(k+m+n) * (k-1)/(k+m+n-1);
		float proKM = k/(k+m+n) * (m)/(k+m+n-1);
		float proKN = k/(k+m+n) * (n)/(k+m+n-1);
		System.out.println(String.format("%s %s %s ",proKK,proKM,proKN));
		System.out.println(proKK + proKM+ proKN);
		float proMK = m/(k+m+n) * (k)/(k+m+n-1);
		float proMM = m/(k+m+n) * (m-1)/(k+m+n-1);
		float proMN = m/(k+m+n) * (n)/(k+m+n-1);
		System.out.println(String.format("%s %s %s ",proMK,proMM,proMN));
		System.out.println(proMK + proMM+ proMN);
		float proNK = n/(k+m+n) * (k)/(k+m+n-1);
		float proNM = n/(k+m+n) * (m)/(k+m+n-1);
		float proNN = n/(k+m+n) * (n-1)/(k+m+n-1);
		
		float output = proKK * 1f + proKM * 1f   + proKN * 1f +
				       proMK * 1f + proMM * 0.75f + proMN * 0.5f +
				       proNK * 1f + proNM * 0.5f + proNN * 0f ;
		System.out.println(output);
		
	}
	
}
