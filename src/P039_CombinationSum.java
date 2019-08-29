import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P039_CombinationSum {
    public static void main(String[] args) {
        P039_CombinationSum cc = new P039_CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = cc.combinationSum(candidates, target);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            int data = candidates[i];
            if(data > target) {
                break;
            }
            list.add(data);
            combination(res, list, candidates, target-data, i);
            list.remove(list.size()-1);
        }

    }
}
