/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. 
If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 */
public class P008_StringtoInteger_atoi {
    public static int myAtoi(String str) {
        if(str == null || str.length() == 0) {
        	return 0;
        }
        if(str.length() == 1) {
        	if(str.charAt(0) == '-' || str.charAt(0) == '+') {
        		return 0;
        	} else {
        		return Integer.parseInt(str);
        	}
        }
        for(int i = 0; i < str.length(); i++) {
        	if(str.charAt(i)!=' ') {
        		str = str.substring(i);
        		break;
        	}
        }
        int flag = 1;
        if(str.charAt(0) == '-' && str.length() > 1) {
        	flag = -1;
        	str = str.substring(1);
        }else if(str.charAt(0) == '+' && str.length() > 1) {
        	flag = 1;
        	str = str.substring(1);
        }
        int x = 0;
        for(int i = 0; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <='9'; i++) {
        	if(x > 214748364) {
        		if(flag == 1) {
        			return 2147483647;
        		} else {
        			return -2147483648;
        		}
        	} else if(x == 214748364) {
        		if(flag == 1 && Integer.parseInt(str.substring(i, i+1)) > 7) {
        			return 2147483647;
        		} else if(flag == -1 && Integer.parseInt(str.substring(i, i+1)) > 8) {
        			return -2147483648;
        		}
        	}
        	int y = x * 10 + Integer.parseInt(str.substring(i, i+1));
        	x = y;
        }
    	return x*flag;
    }
    public static void main(String[] args) {
    	System.out.println(myAtoi("2147483649"));
    	System.out.println(myAtoi("2147483647"));
    	System.out.println(myAtoi("-2147483649"));
    	System.out.println(myAtoi("-2147483648"));
    	System.out.println(myAtoi("-2147483647"));
    	System.out.println(myAtoi("    10522545459"));    	
    	System.out.println(myAtoi("-+1"));
    	System.out.println(myAtoi("+-2"));
    	System.out.println(myAtoi("     010"));
    	
    }
}
