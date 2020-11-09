package draffaeli.leetcode.problems.addtwonumbers2;

import draffaeli.leetcode.problems.addtwonumbers.ListNode;
import org.junit.jupiter.api.Test;

import static draffaeli.leetcode.problems.AddTwoNumbersUtils.newListNodes;
import static draffaeli.leetcode.problems.AddTwoNumbersUtils.toStringNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private Solution target = new Solution();

    @Test
    void addTwoNumbers() {

        // arrange
        // Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = newListNodes(new int[] {7,2,4,3});
        // [5,6,4]
        ListNode l2 = newListNodes(new int[] {5,6,4});
        // Output: 7 -> 8 -> 0 -> 7


        // act
        ListNode actualListNode = this.target.addTwoNumbers(l1, l2);

        // assertions
        assertEquals("7807", toStringNumber(actualListNode));
    }
}