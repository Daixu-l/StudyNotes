package subject;

import java.util.HashMap;
import java.util.Map;

public class 两数之和_1 {

    /*
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
     */

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
         int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0]+""+ints[1]);

    }

    public static int[] mytwoSum(int[] nums, int target) {
        int rest [] ;
        rest =  new int [2] ;
        for(int i = 0 ;i <nums.length;++i){
            for(int j = i+1 ;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    rest[0] =i;
                    rest[1] = j;
                    break;
                }
            }
        }
        return rest;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
