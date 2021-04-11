package dp.thirdDay1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//运用并查集，找出树的公共祖先
public class QuickUnion {

    //代表节点
    private static Map<Node, Node> behalfMap = new HashMap<>();
    //任务序列
    private static Map<Integer, List<Node>> taskList = new HashMap<>();
    //等级
    private static Map<Node, Integer> nodeFRank = new HashMap<>();

    private static Map<Node, Node> fatherMap = new HashMap<>();

    private static List<Node> valueList = new LinkedList<>();

    public static void func1(Node head) {
        //设置自己为自己的代表节点
        setBehalf(head);
        //中序遍历
    }

    public static void setBehalf(Node head) {
        if (head == null) {
            return;
        }
        setBehalf(head.left);
        behalfMap.put(head, head);
        nodeFRank.put(head, 0);
        setBehalf(head.right);
    }


    public static void quickUnion(Node head) {
        if (head == null) {
            return;
        }
        //先序遍历
        quickUnion(head.getLeft());
        findTask(head);
        union(head, head.left);
        fatherMap.put(getBeHalfNode(head), head);
        //设置代表节点
        valueList.add(head);
        quickUnion(head.getRight());
        union(head, head.left);
        fatherMap.put(getBeHalfNode(head), head);
        //设置代表节点

    }

    public static void findTask(Node node) {
        List<Node> list = taskList.get(node);
        if (list != null && list.size() != 0) {
            for (Node i : list) {
                if (valueList.contains(i)) {
                    Node behalfNode = behalfMap.get(i);
                    System.out.println(node.getValue()+":"+i.getValue()+"->"+fatherMap.get(behalfNode).getValue());
                }
            }
        }
    }

    public static void union(Node head, Node son) {
        Node nodeHead = getBeHalfNode(head);
        Node nodeSon = getBeHalfNode(son);
        if (nodeHead != nodeSon) {
            int rankHead = nodeFRank.get(nodeHead);
            int rankSon = nodeFRank.get(nodeSon);
            if (rankHead > rankSon) {
                behalfMap.put(nodeSon, nodeHead);

            } else if (rankHead < rankSon){
                behalfMap.put(nodeHead, nodeSon);
            } else {
                behalfMap.put(nodeSon, nodeHead);
                nodeFRank.put(head, nodeFRank.get(head)+1);
            }

        }
    }

    public static Node getBeHalfNode(Node node) {
        Node halfNode = behalfMap.get(node);
        Node behalfNode = null;
        if (halfNode != node) {
            behalfNode = getBeHalfNode(halfNode);
            behalfMap.put(node, behalfNode);
        }else {
            return halfNode;
        }
        return behalfNode;
    }

}

class Node {
    Node left;
    Node right;
    Integer value;

    public Node getLeft() {
        return this.left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }
    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return this.value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

}
