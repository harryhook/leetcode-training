import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 4};
        int[] nums2 = new int[]{3, 6};
        int[] nums3 = new int[]{8, 12};
        int[] nums4 = new int[]{9, 10};

        List<int[]> numsList = new ArrayList<>();
        numsList.add(nums1);
        numsList.add(nums2);
        numsList.add(nums3);
        numsList.add(nums4);

        Main main = new Main();
        List<int[]> res = main.mergeNums(numsList);
        for (int i = 0; i < res.size(); i++) {
            int[] curr = res.get(i);
            System.out.println(curr[0] + " " + curr[1]);
        }
    }

    private List<int[]> mergeNums(List<int[]> nums) {
        if (nums.size() == 0) return new ArrayList<>();
        // Arrays.sort(nums);

        List<int[]> res = new ArrayList<>();

        int[] temp  = new int[2];
        for (int i=0, j = 1;  j < nums.size() ; j++) {
            // 大于暂存
            if (nums.get(i)[1] > nums.get(j)[0]) {
                temp[0] = nums.get(i)[0];
                temp[1] = Math.max( nums.get(j)[1], nums.get(i)[1]);

            } else if (nums.get(i)[1] < nums.get(j)[0]) {
                res.add(new int[]{temp[0], temp[1]});
                i = j;
            }

        }
        res.add(temp);

        return res;

    }

}