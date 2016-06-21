package rosalind.teman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RNATable {

	public static Map<String,String> table = new HashMap<String, String>();
	
	static{
		try {
			List<String> lines = Files.readAllLines(Paths.get("resources/RNATable"));
			for(String line : lines){
				String[] str = line.split(" ");
				table.put(str[0], str[1]);
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
}
