/**
 * @author open
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
 */
public class P012_IntegerToRoman {
	public String intToRoman(int num) {
		 int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		 String[] romans = {"m","cm","d","cd","c","xc","l","xl","x","ix","v","iv","i"};
		 String s = "";
		 for(int i = 0; i < 13; i++) {
			 while(num >= nums[i]) {
				 s += romans[i];
				 num -= nums[i];
			 }
		 }
		 return s.toUpperCase();
	}
	public static void main(String[] args) {
		int num = 2334;
		System.out.println(new P012_IntegerToRoman().intToRoman(num));
	}
}
