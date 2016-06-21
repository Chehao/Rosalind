package rosalind.teman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenomeAssemblyShortestSuperstring {
	public static void main(String[] args) throws Exception {
		try {
			List<FASTA> fastaList = DistanceUtils
					.buildFastaFormat("resources/Superstring");
			for(FASTA fasta : fastaList){
				System.out.print(fasta.getLabel()+",");
				System.out.println(fasta.getStr());
			} 
			List<Edge> edges = findBestMatch(fastaList);
			Merge(edges,fastaList);
			int size = fastaList.size();
			while(fastaList.size() > 1){
				edges = findBestMatch(fastaList);
				Merge(edges,fastaList);
				//if(size == fastaList.size())
				//	break;
				size = fastaList.size();
				System.out.println("remain size:"+size);
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void Merge(List<Edge> edges, List<FASTA> fastaList) {
		for(Edge edge : edges){
			fastaList.add(new FASTA(edge.getLabel(),edge.getStr()));
		}
		for(FASTA fasta : fastaList){
			System.out.println("ML==="+fasta.getLabel());
			System.out.println("MS==="+fasta.getStr());
		}
	}

	private static List<Edge> findBestMatch(List<FASTA> fastaList) throws Exception {
		List<Edge> result = new ArrayList<Edge>();
		for(FASTA fasta : fastaList){
			//System.out.println("==="+fasta.getStr());
		}
		String bestPrefix = "";
		FASTA start = null;
		FASTA end = null;
		for (int i = 0; i < fastaList.size(); i++) {
			String base = fastaList.get(i).getStr();
			for (int j = 0; j < base.length()-3; j++) {
				String prefix = base.substring(j);
				for (int k = 0; k < fastaList.size(); k++) {
					if(i != k){
						String beCompare = fastaList.get(k).getStr();
						if(beCompare.startsWith(prefix)){
							if(prefix.length()> bestPrefix.length()){
								bestPrefix = prefix;
								start =  fastaList.get(i);
								end = fastaList.get(k);
							}
						}
					}
				}
				
			}
		}
		 
		if(start != null && end != null){
			result.add(new Edge(start,end,bestPrefix));
			fastaList.remove(start);
			fastaList.remove(end);
			
			result.addAll(findBestMatch(fastaList));
		}else{
			for(FASTA fasta : fastaList){
				System.out.println("rest==="+fasta.getStr());
			}
			 
		}
		return result;
		
	}
	
	
}
