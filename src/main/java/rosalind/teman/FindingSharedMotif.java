package rosalind.teman;

import java.io.IOException;
import java.util.List;

public class FindingSharedMotif {
	public static void main(String[] args) {
		try {
			List<FASTA> fastaList = DistanceUtils
					.buildFastaFormat("resources/findCommon");
			FASTA first = fastaList.remove(0);
			String base = first.getStr();
			boolean find = true;
			for (int len = base.length(); len > 1 ; len--) {
				for (int i = 0; i < base.length()- len + 1; i++) {
					String common = base.substring(i,i+len);
					find = true;
					for(FASTA fasta : fastaList){
						if(!fasta.getStr().contains(common)){
							find = false;
							break;
						}
					}
					if(find){
						System.out.println(common);
						break;
					}
				}
				if(find){
					break;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
