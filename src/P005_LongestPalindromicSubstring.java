
public class P005_LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
	   if(s == null || s.length() == 0) {
		   return null;
	   }
	   if(s.length() == 1) {
		   return s;
	   }
	   int max = 1; 
	   String MS = s.substring(0, 1);
	   for(int i = 0; i < s.length(); i++) {
		   //单数对称
		   int j = 1,m=1, j2 = 1, m2 = 1;   
		   for(; i-j >= 0 && i+j<s.length(); j++) {
			   if(s.charAt(i-j) != s.charAt(i+j)) {
				   break;
			   } else {
				   m += 2;
			   }
		   }
		   
		   //双数对称
		   if( i+1 < s.length() && s.charAt(i)==s.charAt(i+1) ) {
			   j2 = 1; m2 = 2;
			   for(; i-j2>=0 && i+1+j2<s.length(); j2++) {
				   if(s.charAt(i-j2) != s.charAt(i+1+j2)) {
					   break;
				   }else {
					   m2 += 2;
				   }
			   }
		   }
		   if(m > max) {
			   max = m;
			   MS = s.substring(i-j+1,i+j);
		   } 
		   if(m2 > max) {
			   max = m2;
			   MS = s.substring(i-j2+1,i+j2+1);
		   }
	   }
	   return MS;
	}
	public static void main(String[] args) {
		String str = "tattarrattat";
		String s = longestPalindrome(str);
		System.out.println(s);
	}
	
}
