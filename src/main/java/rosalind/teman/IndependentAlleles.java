package rosalind.teman;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/*
 * Two positive integers k (k≤7) and N (N≤2k).
 * and genotype mates with Ab Bb, would have 1/4 probability to get Aa Bb
 *  The probability that at laast N Aa Bb organisms will belong to the k-th generation     
 */
public class IndependentAlleles {

	public static void main(String[] args) {
		
		int k = 6;
		int n = 16;		 
		BigDecimal prob = new BigDecimal(0) ;
		double numkgen = Math.pow(2, k);
		System.out.println("K-th:"+numkgen);
		for(int i = 0 ; i < n ; i++){ //sigma
			BigDecimal combine =   getC(numkgen,i) ;			
			BigDecimal numOfAaBb =  new BigDecimal(Math.pow(0.25d, i));
			BigDecimal numOfNotAaBb = new BigDecimal(Math.pow(0.75d, (numkgen-i)));
			System.out.println("conbime:"+ combine+", AaBb:"+ numOfAaBb + ", not AaBb: "+ numOfNotAaBb);
			BigDecimal each = combine.multiply(numOfAaBb).multiply(numOfNotAaBb);
			System.out.println("num :"+ i +" Aa Bb :" + each);
			prob=prob.add(each);			
		}		
		System.out.println(new DecimalFormat("#.##################").format(new BigDecimal(1).subtract(prob)));
	}
	
	public static BigDecimal getC(double total , int num) throws ArithmeticException{
		if(num > total) throw new ArithmeticException();
		if(total == num || num == 0){
			return new BigDecimal(1);
		}
		BigDecimal result = new BigDecimal(1);
		double i = total; 
		int j = num;
		int count = 0 ;
		while(count < num){
			result = result.multiply(new BigDecimal(i/j));
			i--;
			j--;
			count++;
		}
		return result;
	}
}
