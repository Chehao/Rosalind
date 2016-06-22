package rosalind.teman;

import java.io.IOException;
import java.util.List;

import rosalind.teman.entity.FASTA;
import rosalind.teman.util.DistanceUtils;

public class ComputingGCContent {

	public static void main(String[] args) {
		try {
			List<FASTA> fastaList = DistanceUtils.buildFastaFormat("resources/gc_content");
			 
			float maxGCContent = 0;
			String label = "";
			for(FASTA fasta : fastaList){
				
				float gcContent = DistanceUtils.findGCContent(fasta.getStr());
				System.out.println(String.format("%s %s %s", fasta.getLabel(),gcContent,fasta.getStr()));
				if(gcContent> maxGCContent){
					label = fasta.getLabel();
					maxGCContent = gcContent;
				}
			}
			System.out.println(String.format("max:%s, %s",label,maxGCContent));
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
}
