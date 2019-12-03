import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day01 extends Day {
    List<Integer> nums;

    void read() {
        nums = new ArrayList<>();
        Scanner input = getInput();
        while (input.hasNextInt()) {
            nums.add(input.nextInt());
        }

    }

    Object problem1() {
        read();
        Integer sum = nums.stream().reduce(0, (a, b) -> a + (b / 3 - 2));

        return sum.toString();
    }

    Object problem2() {

        Integer sum = nums.stream().reduce(0, (a, b) -> a + getFuelForModule(b));
        return sum.toString();
    }

    private Integer getFuelForModule(Integer weight) {
        Integer fuel = weight / 3 - 2;
        if (fuel <= 0) {
            return 0;
        } else {
            return fuel + getFuelForModule(fuel);
        }

    }
}
