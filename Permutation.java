import java.util.*;

public class Permutation {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    // Backtracking method to generate permutations
    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int number : nums) {
            if (tempList.contains(number)) {
                continue; // skip duplicates
            }

            tempList.add(number); // choose
            backtrack(resultList, tempList, nums); // explore
            tempList.remove(tempList.size() - 1); // un-choose (backtrack)
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Permutation solution = new Permutation();
        int[] nums = {1, 2, 3};

        List<List<Integer>> permutations = solution.permute(nums);

        System.out.println("Permutations of " + Arrays.toString(nums) + " are:");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
