import java.util.HashMap;

//Given a string, find the length of the longest substring without repeating characters.
//Examples:
//Given "abcabcbb", the answer is "abc", which the length is 3.
//Given "bbbbb", the answer is "b", with the length of 1.
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//Subscribe to see which companies asked this question

/*
 * public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}


   public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
 */

public class P003_LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>(); 
        for(int i = 0, j = 0; i < s.length(); i++) {
        	if(map.containsKey(s.charAt(i))) {
        		j = Math.max(j, map.get(s.charAt(i))+1);
        	}
        	map.put(s.charAt(i),i);
        	max = Math.max(max, i - j + 1);
        }
        
		return max;
    }
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
