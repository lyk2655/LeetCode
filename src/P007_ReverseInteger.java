/*
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class P007_ReverseInteger {
    public static int reverse(int x) {
        String s = Integer.toString(x);
        if(s == null || s.length() < 2) {
        	return x;
        }
        boolean flag = true;
        if(s.charAt(0)== '-') {
        	flag = false;
        	s = s.substring(1);
        }
        int y = 0;
        for(int i = 0; i < s.length(); i++) {
        	int yy = (int) (Integer.parseInt(s.substring(i, i+1))*Math.pow(10, i));
        	if(y > y+yy) {
        		return 0;
        	}
        	y = y + yy;
        }
        if(flag) {
        	return y;
        } else {
        	return y*(-1);
        }
    }
    public static void main(String[] args) {
    	System.out.println(reverse(123));
    	System.out.println(reverse(-123));
    	System.out.println(reverse(100));
    	System.out.println(reverse(12300));
    	System.out.println(reverse(1000000003));
    }
}
