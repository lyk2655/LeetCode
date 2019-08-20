/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class P038_CountandSay {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String arr = countAndSay(n-1);
        StringBuffer buf = new StringBuffer();
        char index = ' ';
        int count = 0;
        for(int i = 0; i < arr.length(); i++) {
            if(index == ' ') {
                index = arr.charAt(i);
                count = 1;
            } else if(index ==  arr.charAt(i)) {
                count ++;
            } else {
                buf.append(String.valueOf(count));
                buf.append(index);
                index = arr.charAt(i);
                count = 1;
            }
        }
        if(index != ' ') {
            buf.append(String.valueOf(count));
            buf.append(index);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        P038_CountandSay countandSay = new P038_CountandSay();
        System.out.println(countandSay.countAndSay(4));
    }
}
