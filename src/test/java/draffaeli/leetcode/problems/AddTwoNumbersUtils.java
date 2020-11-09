package draffaeli.leetcode.problems;

import draffaeli.leetcode.problems.addtwonumbers.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddTwoNumbersUtils {

    public static ListNode newListNodes(int[] vals) {
        int lastIndex = vals.length-1;
        if (lastIndex < 0 ) {
            return null;
        }

        return newListNode(new ListNode(vals[lastIndex]), Arrays.stream(vals).limit(lastIndex).toArray());
    }

    private static ListNode newListNode(ListNode l, int[] vals) {
        int lastIndex = vals.length-1;
        if (lastIndex < 0 ) {
            return l;
        }

        return newListNode(new ListNode(vals[lastIndex], l), Arrays.stream(vals).limit(lastIndex).toArray());
    }

    public static String toStringNumber(ListNode l) {
        return String.join("", addValue(l, new ArrayList<>()));
    }

    public static String toStringNumberReverse(ListNode l) {
        List<String> values = addValue(l, new ArrayList<>());
        Collections.reverse(values);
        return String.join("",values);
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
