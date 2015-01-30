/*
package com.alexvolov.ads.ds.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BTreePrinter {

    public static void printTreeNode(TreeNode root, int gogogo) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel, gogogo);
    }

    private static void printTreeNodeInternal(List<TreeNode> TreeNodes, int level, int maxLevel, int gogogo) {
        if (TreeNodes.isEmpty() || BTreePrinter.isAllElementsNull(TreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newTreeNodes = new ArrayList<TreeNode>();
        for (TreeNode TreeNode : TreeNodes) {
            if (TreeNode != null) {
                if (gogogo == 0) {
                    System.out.print(null == TreeNode.getValue()?"X":TreeNode.getValue());
                } else if (gogogo == 1) {
                    System.out.print(TreeNode.getLeftHeight() + "-" + TreeNode.getValue() + "-" + TreeNode.getRightHeight());
                } else {
                    System.out.print(null == TreeNode.getValue()?"X":TreeNode.getValue() + (TreeNode.getColor()?"b":"r"));
                }
                newTreeNodes.add(TreeNode.getLeft());
                newTreeNodes.add(TreeNode.getRight());
            } else {
                newTreeNodes.add(null);
                newTreeNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < TreeNodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (TreeNodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (TreeNodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (TreeNodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeNodeInternal(newTreeNodes, level + 1, maxLevel, gogogo);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode TreeNode) {
        if (TreeNode == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(TreeNode.getLeft()), BTreePrinter.maxLevel(TreeNode.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
*/