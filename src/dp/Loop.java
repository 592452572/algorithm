package src.dp;

public class Loop {

    /**
     * 问题描述：给两条链，可能有环，也可能无环。如果两条链相交，返回相交的第一个节点，如果不相交，返回null
     * 结论 ：确定环的位置，一个先走两步，另一个走一步，如果有环,在环里相遇之后，两步返回起点，走一步，相遇便是环点的位置，
     * 思路：两个链表都无环的情况(结尾都是null)，结局是呈Y，也就是用共同一个结尾。长链表先走x步，直至剩余长度和锻炼表一致，然后一起走。第一个相同的节点就是相交
     * 一个无环，一个有环，一定不可能相交
     *两个都有环：
     * 情况1：各自成环：将其中一个链表继续往下走，在回到本身时没遇到另一个链表的环节点
     * 情况2：环前相交
     *        判断是否是同一个环节点，是的话则是该种情况，则使用无环结构来判断
     * 情况3：环内相交：将其中一个链表继续往下走，在回到本身时遇到另一个链表的环节点
     *
     */
    public static Node getNode(Node head1, Node head2) {
        //判断是否有环
        Node loop1 = getLoop(head1);
        Node loop2 = getLoop(head2);
        Node node = null;

        if (loop1 == null && loop2 == null) {
            //无环判断是否相交
            node = getNodeNotLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            //有环判断是否相交
        }


        return null;
    }
    public static Node getLoop(Node head) {
        Node slow = head.next.next;
        Node fast = head.next;
        boolean flag = true;
        while (slow != fast) {
            if (fast == null) {
                flag = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (!flag) {
            return null;
        }
        fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static Node getNodeNotLoop(Node head1, Node head2) {
        int n = 0;
        Node start1 = head1;
        Node start2 = head2;
        boolean flag = false;
        while (head1.next != null) {
            n++;
        }
        while (head2.next != null) {
            n--;
        }
        if (n > 0) {
            while (n > 0) {
                start1 = start1.next;
                n--;
            }
            while (start1 != null && start1.value != start2.value) {
                start1 = start1.next;
                start2 = start2.next;
            }
        } else if (n < 0) {
            while (n < 0) {
                start2 = start2.next;
                n++;
            }
            while (start1 != null && start1.value != start2.value) {
                start1 = start1.next;
                start2 = start2.next;
            }
        } else {
            while (start1 != null && start1.value != start2.value) {
                start1 = start1.next;
                start2 = start2.next;
            }
        }
        return start1;
    }

    public static Node getLoopNode(Node head1, Node head2, Node loop1, Node loop2) {
        if (loop1.value == loop2.value) {
            int n = 0;
            Node start1 = head1;
            Node start2 = head2;
            while (head1.next != loop1.next) {
                n++;
            }
            while (head2.next != loop2.next) {
                n--;
            }
            if (n > 0) {
                while (n > 0) {
                    start1 = start1.next;
                    n--;
                }
                while (start1 != loop1.next && start1.value != start2.value) {
                    start1 = start1.next;
                    start2 = start2.next;
                }
            } else if (n < 0) {
                while (n < 0) {
                    start2 = start2.next;
                    n++;
                }
                while (start1 != loop1.next && start1.value != start2.value) {
                    start1 = start1.next;
                    start2 = start2.next;
                }
            } else {
                while (start1 != loop1.next && start1.value != start2.value) {
                    start1 = start1.next;
                    start2 = start2.next;
                }
            }
            return start1;
        } else {
            Node start = loop1;
            loop1 = loop1.next;
            while (loop1 != loop2 && loop1 != start){
                loop1 = loop1.next;
            }
            if (loop1 == loop2) {
                //在环里有相交
                return loop1;
            } else {
                return null;
            }
        }
    }
}




class Node{
    public Node next;
    public int value;
}