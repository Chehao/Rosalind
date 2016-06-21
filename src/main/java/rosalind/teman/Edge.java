package rosalind.teman;

public class Edge{
	FASTA start ;		
	FASTA end;
	String prefix;
	public Edge(FASTA start, FASTA end,String prefix){
		this.start = start;
		this.end = end;
		this.prefix = prefix;
	}
	public FASTA getStart() {
		return start;
	}
	public void setStart(FASTA start) {
		this.start = start;
	}
	public FASTA getEnd() {
		return end;
	}
	public void setEnd(FASTA end) {
		this.end = end;
	}
	public String getLabel() {
		return start.getLabel()+"-"+end.getLabel();
	}
	public String getStr() {
		return start.getStr()+end.getStr().substring(prefix.length());
	}
}