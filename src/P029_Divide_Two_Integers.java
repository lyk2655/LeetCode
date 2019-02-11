/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3 Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2 
 * Note:
 * Both dividend and divisor will be 32-bit signed integers. The divisor will never be 0. Assume we are dealing with an
 * environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose
 * of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */

/**
 * @author linyk001
 * @date 2019/02/11
 */
public class P029_Divide_Two_Integers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;
        boolean navegate = dividend < 0 != divisor < 0;
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        int result = 0;
        while (m >= n) {
            int shift = 0;
            while (m >= n << (shift + 1)) {
                shift++;
            }
            m -= n << shift;
            result += 1 << shift;
        }
        return navegate == true ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1)); // 2147483647
        System.out.println(divide(-2147483648, 1)); // -2147483648
        System.out.println(divide(-2147483648, 2)); // -1073741824
    }
}
