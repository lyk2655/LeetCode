import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P040_CombinationSum2 {
    public static void main(String[] args) {
        P040_CombinationSum2 cc = new P040_CombinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = cc.combinationSum2(candidates, target);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        combination(res, list, candidates, target, 0);
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int pos) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            if(i != pos && candidates[i] == candidates[i-1]) {
                continue;
            }
            int data = candidates[i];
            if(data > target) {
                break;
            }
            list.add(data);
            int[] candi = Arrays.copyOfRange(candidates, i+1, candidates.length);
            combination(res, list, candi, target-data, 0);
            list.remove(list.size()-1);
        }
    }
}
