package org.dsa.hackerrank.sum;

public class Sum {

    class Solution {
        public Integer sum(Integer[] ia) {
            int curr = ia[0];

            for (int i = 1; i < ia.length; i++) {
                curr += ia[i];
            }

            return curr;
        }

        public String sum(String[] sa) {
            String curr = sa[0];

            for (int i = 1; i < sa.length; i++) {
                curr += sa[i];
            }

            return curr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Sum().new Solution();
        Integer[] ia = {5, 5, 5};
        String[] sa = {"1", "2", "3"};
        String result = solution.sum(sa);
        System.out.println(result);
    }
}
