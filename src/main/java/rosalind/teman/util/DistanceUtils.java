package rosalind.teman.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import rosalind.teman.entity.FASTA;

public class DistanceUtils {

	public static float getDistance(String s1, String s2) {

		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static List<FASTA> buildFastaFormat(String path) throws IOException {
		List<FASTA> taxas = new ArrayList<FASTA>();
		List<String> lines = Files.readAllLines(Paths.get(path));
		String key = "";
		String value = "";
		for (String l : lines) {
			if (l.startsWith(">")) {
				if (!key.equals("")) {
					taxas.add(new FASTA(key, value));
					value = "";
				}
				key = l;
			} else {
				value += l;
			}
		}
		if (!key.equals("")) {
			taxas.add(new FASTA(key, value));
		}
		return taxas;
	}

	public static float findGCContent(String dnaString){
		float count = 0 ;
		for(int i =0; i < dnaString.length(); i++){
			char c = dnaString.charAt(i);
			if(c == 'G' || c == 'C'){
				count++;
			}
		}
		return count/dnaString.length()*100;
	}
}
