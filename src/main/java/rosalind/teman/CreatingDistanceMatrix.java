package rosalind.teman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatingDistanceMatrix {
	
	public static void main(String[] args) {
		try {
			List<FASTA> taxas = DistanceUtils
					.buildFastaFormat("resources/distanceMatrix");
			for (FASTA fasta : taxas) {
				System.out.println(fasta.getStr());
			}

			for (int i = 0; i < taxas.size(); i++) {
				for (int j = 0; j < taxas.size(); j++) {
					System.out.print(DistanceUtils.getDistance(taxas.get(i)
							.getStr(), taxas.get(j).getStr())
							+ " ");
					if (j == taxas.size() - 1)
						System.out.println();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
