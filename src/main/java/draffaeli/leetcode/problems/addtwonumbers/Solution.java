package draffaeli.leetcode.problems.addtwonumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807
 *
 *
 */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int val1 = 0;
        ListNode nextL1 = null;
        if (l1 != null) {
            val1 = l1.val;
            nextL1 = l1.next;
        }

        int val2 = 0;
        ListNode nextL2 = null;
        if (l2 != null) {
            val2 = l2.val;
            nextL2 = l2.next;
        }

        int currentVal = val1+val2;
        if (currentVal >= 10) {
            currentVal -= 10;
            if (nextL1 != null) {
                nextL1 = new ListNode(nextL1.val+1, nextL1.next);
            } else {
                nextL1 = new ListNode(1, null);
            }
        }

        if (nextL1 != null || nextL2 != null) {
            return new ListNode(currentVal, addTwoNumbers(nextL1, nextL2));
        } else {
            return new ListNode(currentVal);
        }
    }
}
