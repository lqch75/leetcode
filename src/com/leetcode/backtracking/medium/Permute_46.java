package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute_46 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> track = new ArrayList<>();

        backtrack(nums, track);
        return res;
    }


    void backtrack(int[] nums, List<Integer> track) {

        if (track.size() == nums.length) {

            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (track.contains(nums[i])) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, track);

            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {

        Permute_46 method = new Permute_46();
        method.permute(new int[]{2, 5, 3});
    }
}
