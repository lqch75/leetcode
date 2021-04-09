package com.leetcode.backtracking.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets_78 {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {

        Deque<Integer> track = new ArrayDeque<>();

        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums, track, i, 0);
        }

        return res;
    }

    void backtrack(int[] nums, Deque<Integer> track, int count, int depth) {

        if (track.size() == count) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = depth; i < nums.length; i++) {

            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);

            backtrack(nums, track, count, ++i);

            --i;
            track.removeLast();
        }
    }


    public static void main(String[] args) {

        Subsets_78 method = new Subsets_78();
        method.subsets(new int[]{1, 2, 3});
    }
}
