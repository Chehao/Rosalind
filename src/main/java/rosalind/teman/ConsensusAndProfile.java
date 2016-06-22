package rosalind.teman;

import java.io.IOException;
import java.util.List;

import rosalind.teman.entity.FASTA;
import rosalind.teman.util.DistanceUtils;

public class ConsensusAndProfile {

	public static void main(String[] args) {
		
		try {
			List<FASTA> fasta = DistanceUtils.buildFastaFormat("resources/CAP");
			int len = fasta.get(0).getStr().length();
			int[][] ACGT = new int[4][len];
			
			for(FASTA fa : fasta){
				for(int i = 0 ; i < len; i++){
					char c = fa.getStr().charAt(i);
					if(c == 'A'){
						ACGT[0][i]++;
					}else if(c == 'C'){
						ACGT[1][i]++;
					}else if( c== 'G'){
						ACGT[2][i]++;					
					}else if( c == 'T'){
						ACGT[3][i]++;
					}
					
				}				
			}
			String Consensus = "";
			for(int i =0; i < len ; i++){
				int maxindex=0;
				int maxvalue=0;
				for(int j =0; j < 4; j++){
					if(ACGT[j][i] > maxvalue){
						maxvalue=ACGT[j][i];
						maxindex = j;
					}
				}
				Consensus += "ACGT".charAt(maxindex);
			}
			System.out.println(Consensus);
			for(int i = 0; i< 4;i++){
				System.out.print("ACGT".charAt(i)+": ");
				for(int j=0; j<len;j++){
					System.out.print(ACGT[i][j] + " ");
				}
				System.out.println();
			}
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
