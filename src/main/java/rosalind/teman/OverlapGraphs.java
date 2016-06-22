package rosalind.teman;

import java.io.IOException;
import java.util.List;

import rosalind.teman.entity.FASTA;
import rosalind.teman.util.DistanceUtils;

public class OverlapGraphs {

	public static void main(String[] args) {
		try {
			List<FASTA> fastaList = DistanceUtils
					.buildFastaFormat("resources/OverlapGraphs");

			for (int i = 0; i < fastaList.size(); i++) {
				String s = fastaList.get(i).getStr();
				String suffix = s.substring(s.length() - 3, s.length());
				for (int j = 0; j < fastaList.size(); j++) {
					String t = fastaList.get(j).getStr();
					if (i != j) {
						if (t.startsWith(suffix) && !s.equals(t)) {
							System.out.println(fastaList.get(i).getLabel().substring(1)
									+ " " + fastaList.get(j).getLabel().substring(1));
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
