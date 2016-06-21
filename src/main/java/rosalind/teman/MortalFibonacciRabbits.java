package rosalind.teman;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MortalFibonacciRabbits {
	static int n = 90;
	static int m = 16;
	public static void main(String[] args) {
		BigDecimal[] F = new BigDecimal[101];
		F[0] = new BigDecimal(1d);
		F[1] = new BigDecimal(1d);
		F[2] = new BigDecimal(1d);
		for(int i = 3; i <= 100; i++){
			if(i > m){
				F[i] = F[i-1].add(F[i-2]).subtract(F[i-m-1]);
			}else{
				F[i] = F[i-1].add(F[i-2]) ;
			}
			System.out.println("F["+i+"]="+new DecimalFormat("####################.#").format( F[i]));
		}
		System.out.println(new DecimalFormat("####################.#").format(F[n]));
		
		BigDecimal[][] FT = new BigDecimal[n][m];
		
		for(int i = 0; i < n; i++){
			System.out.print("F("+(i+1)+") ");
			for(int j = 0 ; j < m ; j++){
				if(i==0){
					if( j==0 )
						FT[i][j] = new BigDecimal(1d) ;
					else
						FT[i][j] = new BigDecimal(0d) ;
				}else{
					if( j==0){
						FT[i][j] = sumParent(FT[i-1]);//new born
					}else{
						FT[i][j]= FT[i-1][j-1];
					}					
				}
				//System.out.print( new DecimalFormat("###################.#").format(FT[i][j])+" ");
			}
			System.out.println(" = " + new DecimalFormat("####################.#").format(sumGeneration(FT[i])));
		}
		System.out.println(new DecimalFormat("####################.#").format(sumGeneration(FT[n-1])));
	}
	
	private static  BigDecimal sumParent(BigDecimal[] ds) {
		BigDecimal sum = new BigDecimal(0d);
		for(int i = 1; i < ds.length; i++){
			sum= sum.add( ds[i]);
		}
		return sum;
	}
	
	private static BigDecimal sumGeneration(BigDecimal[] ds){
		BigDecimal sum = new BigDecimal(0d);
		for(int i = 0; i< ds.length; i++){
			sum= sum.add( ds[i]);
		}
		return sum;
	}
	
	public static int MortalFibonacci(int n){
		 
		if(n <= 2)
			return 1;
		else{			
			if(n > m)
				return MortalFibonacci(n-1 )+MortalFibonacci(n-2)-MortalFibonacci(n-m-1);
			else
				return MortalFibonacci(n-1 )+MortalFibonacci(n-2);
		}
	}
}
