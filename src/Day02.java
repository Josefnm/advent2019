import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day02 extends Day {

    private Integer[] read() {
        Scanner input = getInput();
        List<Integer> nums = new ArrayList<>();
        input.useDelimiter(",");
        while (input.hasNextInt()) {
            nums.add(input.nextInt());
        }
        return nums.toArray(new Integer[]{});
    }

    @Override
    Object problem1() {
        Integer[] nums = read();
        nums[1] = 12;
        nums[2] = 2;
        return calculateOutput(nums);
    }

    @Override
    Object problem2() {
        Integer[] backupNums = read();
        Integer[] nums;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                 nums= backupNums.clone();
                nums[1] = i;
                nums[2] = j;
                Integer output= calculateOutput(nums);
                Integer goal = 19690720;
                if(output.equals(goal)){

                    return String.format("%02d%02d%n", i,j);
                }
            }
        }
        return null;
    }

    private Integer calculateOutput(Integer[] nums) {
        int k = 0;
        while (nums[k] != 99) {
            if (nums[k] == 1) {
                nums[nums[k + 3]] = nums[nums[k + 1]] + nums[nums[k + 2]];
            }else if(nums[k] == 2) {
                nums[nums[k + 3]] = nums[nums[k + 1]] * nums[nums[k + 2]];
            }else {
                return -1;
            }
            k+=4;
        }
        return nums[0];
    }
}
