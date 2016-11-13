import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
 */

public class P006_ZigZagConversion {
    public static String convert(String s, int numRows) {
    	if(s == null || s.length() <= numRows || numRows <= 1) {
    		return s;
    	}
    	Map<Integer,ArrayList<Character>> map = new HashMap<Integer,ArrayList<Character>>();
    	int r = 0, flag = 1;
    	ArrayList<Character> array = new ArrayList<Character>();
    	for(int i = 0; i < s.length() && r < numRows; i++) {
    		if(map.containsKey(r)) {
    			array = map.get(r);
    			array.add(s.charAt(i));
    			map.put(r,array);
    		} else {
    			array = new ArrayList<Character>();
    			array.add(s.charAt(i));
    			map.put(r, array);
    		}
    		if(i%((numRows-1)*2) < (numRows-1)) {
    			r++;
    		} else {
    			r--;
    		}
    	}
    	String ss = "";
    	for(int rr = 0; rr < numRows; rr++) {
    		ArrayList<Character> arr = map.get(rr);
    		for(Character c : arr) {
    			ss += c;
    		}
    	}
        return ss;
    }
    
    public static void main(String[] args) {
    	String s = "AB";
    	System.out.println(convert(s,1));
    }
}
