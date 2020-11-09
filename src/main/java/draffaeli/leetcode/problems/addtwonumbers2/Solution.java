package draffaeli.leetcode.problems.addtwonumbers2;

import draffaeli.leetcode.problems.addtwonumbers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // calculate nodes quantity of each list
        int l1Quantity = 0;
        if (l1 != null) {
            l1Quantity = this.retrieveQuantity(l1, 1);
        }

        int l2Quantity = 0;
        if (l2 != null) {
            l2Quantity = this.retrieveQuantity(l2, 1);
        }

        int quantityDiff = l1Quantity-l2Quantity;

        // complete with nodes in the left to equiparate the nodes quantity of the lists
        ListNode fixedL1 = l1;
        ListNode fixedL2 = l2;
        if (quantityDiff < 0) {
            fixedL1 = this.addLeftNodes(l1, Math.abs(quantityDiff));
        } else if (quantityDiff > 0) {
            fixedL2 = this.addLeftNodes(l2, quantityDiff);
        }

        return this.process(fixedL1, fixedL2);
    }

    private ListNode addLeftNodes(ListNode l, int quantity) {
        if (quantity == 0) {
            return l;
        }

        return addLeftNodes(new ListNode(0, l), --quantity);
    }

    private int retrieveQuantity(ListNode l, int currentQuantity) {
        if (l.next != null) {
            return retrieveQuantity(l.next, ++currentQuantity);
        }

        return currentQuantity;
    }

    private ListNode process(ListNode l1, ListNode l2) {
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
            return new ListNode(currentVal, process(nextL1, nextL2));
        } else {
            return new ListNode(currentVal);
        }
    }

    private ListNode process2(ListNode l1, ListNode l2) {
        int l1Number = Integer.getInteger(toStringNumber(l1));
        int l2Number = Integer.getInteger(toStringNumber(l2));

        int sum = l1Number+l2Number;
        String stringSum = String.valueOf(sum);

        char[] sumChars = stringSum.toCharArray();
        for (int i = 0; i < sumChars.length; i++) {

        }

    }

    private ListNode process3(ListNode l1, ListNode l2) {

        int currentVal1 = 0;
        ListNode nextL1 = null;
        if (l1 != null) {
            currentVal1 = l1.val;
            nextL1 = l1.next;
        }

        int currentVal2 = 0;
        ListNode nextL2 = null;
        if (l2 != null) {
            currentVal2 = l2.val;
            nextL2 = l2.next;
        }

        int nextSum = nextL1.val+nextL2.val;


        if (nextL1 == null) {
            int nextSum = nextL1.val+ nextL2.val;
            ListNode lastNode = new ListNode(nextNextSum);
            if (nextNextSum >= 0) {
                nextSum++;
            }
            return new ListNode(nextSum, lastNode);
        } else {
            ListNode nextNode = process3(nextL1, nextL2);
            if (nextNode.val >= 10) {
                nextNode.val -= 10;
                nextSum++;
            }
            return new ListNode(nextSum, n;
        }
    }

    public String toStringNumber(ListNode l) {
        return String.join("", addValue(l, new ArrayList<>()));
    }

    private static List<String> addValue(ListNode l, List<String> values) {
        values.add(String.valueOf(l.val));
        if (l.next != null) {
            return addValue(l.next, values);
        } else {
            return values;
        }
    }
}
