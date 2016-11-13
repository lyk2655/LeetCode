/*
Determine whether an integer is a palindrome. Do this without extra space.
 */
public class P009_PalindromeNumber {
	public static boolean isPalindrome(int x) {
        if(x < 0) {
        	return false;
        }
        if(x < 10) {
        	return true;
        }
        int i = 1, size = 1;
        for( i = 9; i < x; i= i*10 + 9 ) {
        	size++;
        	if(size > 10) {
        		size = 10;
        		break;
        	}
        }
        for(int j = 1; j <= (size+1) / 2; j++) {
        	int m = (int) (x/(Math.pow(10, size-j))) % 10;
        	int n = (int) ((x % (Math.pow(10, j))) / Math.pow(10, j-1) );
        	if(m != n){
        		return false;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isPalindrome(9999));
		System.out.println(isPalindrome(99999));
		System.out.println(isPalindrome(1410110141));
		System.out.println(isPalindrome(123));
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(-123));
		System.out.println(isPalindrome(123454321));
	}
}
