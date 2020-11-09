package draffaeli.leetcode.problems.addtwonumbers;

import org.junit.jupiter.api.Test;

import static draffaeli.leetcode.problems.AddTwoNumbersUtils.newListNodes;
import static draffaeli.leetcode.problems.AddTwoNumbersUtils.toStringNumberReverse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private Solution target = new Solution();

    @Test
    void addTwoNumbers_sameSize_returnSum() {
        // arrange

        // [3,2,1]
        ListNode l1 = newListNodes(new int[] {3,2,1});
        // [5,2,2]
        ListNode l2 = newListNodes(new int[] {5,2,2});
        // 123 + 225 -> 348


        // act
        ListNode actualListNode = this.target.addTwoNumbers(l1, l2);

        // assertions
        assertEquals("348", toStringNumberReverse(actualListNode));
    }


    @Test
    void addTwoNumbers_sameSize_exceedTen_returnSum() {
        // arrange

        // [3,9,1]
        ListNode l1 = newListNodes(new int[] {3,9,1});
        // [5,2,2]
        ListNode l2 = newListNodes(new int[] {5,2,2});
        // 193 + 225 -> 418


        // act
        ListNode actualListNode = this.target.addTwoNumbers(l1, l2);

        // assertions
        assertEquals("418", toStringNumberReverse(actualListNode));
    }

    @Test
    void addTwoNumbers_firstListNull_returnSecond() {
        // arrange

        ListNode l1 = null;
        // [5,2,2]
        ListNode l2 = newListNodes(new int[] {5,2,2});
        // 0 + 225 -> 255


        // act
        ListNode actualListNode = this.target.addTwoNumbers(l1, l2);

        // assertions
        assertEquals("225", toStringNumberReverse(actualListNode));
    }

    @Test
    void addTwoNumbers_differentSize_exceedTen_returnSum() {
        // arrange

        // [9,9]
        ListNode l1 = newListNodes(new int[] {9,9});
        // [5,6,7]
        ListNode l2 = newListNodes(new int[] {5,6,7});
        // 99 + 765 -> 864


        // act
        ListNode actualListNode = this.target.addTwoNumbers(l1, l2);

        // assertions
        assertEquals("864", toStringNumberReverse(actualListNode));
    }

}