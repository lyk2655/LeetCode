import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9] Explanation: Substrings starting at index 0 and
 * 9 are "barfoor" and "foobar" respectively. The output order does not matter, returning [9,0] is fine too. Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] Output: []
 * 
 * 找出字符串s中包含words数组的子串
 * 
 * @author linyk001
 * @date 2019/02/13
 */
public class P030_Substring_with_Concatenation_of_All_Words {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words.length == 0 || words[0].length() == 0 || s == null || s.equals(""))
            return result;
        int wordLen = words[0].length();
        int listLen = words.length;
        int strLen = s.length();
        int maxIdx = strLen - wordLen * listLen;
        if (maxIdx < 0)
            return result;
        Map<String, Integer> freq = new HashMap<String, Integer>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> temp = new HashMap();

        for (int i = 0; i < wordLen; i++) {
            // 从j开始遍历子串s[j, j+listLen*words]
            for (int j = i; j <= maxIdx; j += wordLen) {
                // 子串中每个word是否在words中
                for (int k = listLen - 1; k >= 0; k--) {
                    String str = s.substring(k * wordLen + j, k * wordLen + j + wordLen);
                    int num = temp.getOrDefault(str, 0) + 1;
                    if (num > freq.getOrDefault(str, 0)) {
                        j += k * wordLen; // 子串中的单词不在words中或出现次数大于words中次数,将窗口后挪
                        break;
                    } else if (k == 0) {
                        result.add(j);   // 子串遍历完毕, 没有出现次数大于2或不存在words中的情况
                    } else {
                        temp.put(str, num);
                    }
                }
                temp.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
        s = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println(findSubstring(s, words2));
    }
}
