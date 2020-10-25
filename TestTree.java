package Tree;



import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTree {
    public static void main(String[] args) {
        Node testNode = new Node(3);
        List<Integer> numbers = Arrays.asList(5, 21, 1, 4, 7, 6, 84, 9, 3, 2, 0, 8, 12, 5);
        Node root = null;
        for (Integer number : numbers) {
            Node node = new Node(number);
            if (root == null) {
                root = node;
            } else {
                insertTree(root, node);
            }
        }

//        System.out.println("ok");
        List<Integer> sorted = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        List<Pair> pairs = new ArrayList<>();
        List<Triple> triples = new ArrayList<>();
        traverseLmr3(triples, root, 0, "");
        printTree2(triples);
//        printTree(root, holder);
//        System.out.println(getTreeHeight(root));
//        traverseLrm(sorted, root);
//        traverseMlr(sorted, root);
//        for (Integer integer : sorted) {
//            System.out.println(integer);
//        }
//
//        System.out.println(search(root, 5));
//        System.out.println(search(root, 11));
//        System.out.println(search(root, 2));

    }

    public static void insertTree(Node root, Node node) {
        if (node.getValue() <= root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                insertTree(root.getLeft(), node);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                insertTree(root.getRight(), node);
            }
        }
    }

    public static void traverseLmr(List<Integer> holder, Node root) {
        if (root.getLeft() != null) {
            traverseLmr(holder, root.getLeft());
        }
        holder.add(root.getValue());
        if (root.getRight() != null) {
            traverseLmr(holder, root.getRight());
        }
    }

    public static void traverseLmr2(List<Pair> holder, Node root, int layer) {
        int currentLayer = layer+1;
        if (root.getLeft() != null) {
            traverseLmr2(holder, root.getLeft(), currentLayer);
        }
        holder.add(Pair.of(root.getValue(), currentLayer));
        if (root.getRight() != null) {
            traverseLmr2(holder, root.getRight(), currentLayer);
        }
    }

    public static void traverseLmr3(List<Triple> holder, Node root, int layer, String side) {
        int currentLayer = layer+1;
        if (root.getLeft() != null) {
            traverseLmr3(holder, root.getLeft(), currentLayer, "L");
        }
        holder.add(Triple.of(root.getValue(), currentLayer, side));
        if (root.getRight() != null) {
            traverseLmr3(holder, root.getRight(), currentLayer, "R");
        }
    }

    public static int getTreeHeight(Node root) {
            if (root == null) {
                return 0;
            }
            /*
            5
           /\
          2 7
        /\ /\
       1 4 6 8
             */
            return 1 + Math.max(getTreeHeight(root.getLeft()), getTreeHeight(root.getRight()));

    }

    public static void printTree(Node root, List<Integer> holder) {
        int treeHeight = getTreeHeight(root);
        int treeWidthSpaces = treeHeight * 2 + 1;
//            System.out.println(treeWidthSpaces);

    }


    public static void printTree(List<Triple> pairs) {
        boolean hasLayer = true;
        int layer = 1;
        while (hasLayer) {
            hasLayer = false;
            for (int i = 0; i < pairs.size(); i++) {
                int v = (int) pairs.get(i).getLeft();
                int l = (int) pairs.get(i).getRight();

                if (l == layer) {
                    hasLayer = true;
                    if (v < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(v);
                    }
                else {
                    System.out.print("  ");
                }
            }

            layer++;
            System.out.println("");
        }

    }

    public static void printTree2(List<Triple> triples) {
        boolean hasLayer = true;
        int layer = 1;
        while (hasLayer) {
            hasLayer = false;
            for (int i = 0; i < triples.size(); i++) {
                int v = (int) triples.get(i).getLeft();
                int l = (int) triples.get(i).getMiddle();

                if (l == layer) {
                    hasLayer = true;

                    if (triples.get(i).getRight().equals("L")) {
                        System.out.print(" /");
                    }
                    else if (triples.get(i).getRight().equals("R")) {
                        System.out.print("\\ ");
                    }
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println("");

            for (int i = 0; i < triples.size(); i++) {
                int v = (int) triples.get(i).getLeft();
                int l = (int) triples.get(i).getMiddle();

                if (l == layer) {
                    hasLayer = true;


                    if (triples.get(i).getRight().equals("L")) {
                        System.out.print(v);
                        if (v < 10) {
                            System.out.print(" ");
                        }
                    }
                    else {
                        if (v < 10) {
                            System.out.print(" ");
                        }
                        System.out.print(v);
                    }



                }
                else {
                    System.out.print("  ");
                }
            }
            layer++;
            System.out.println("");
        }

    }

//    public static void traverseLrm(List<Integer> holder, Node root) {
//        if (root.getLeft() != null) {
//            traverseLrm(holder, root.getLeft());
//        }
//
//        if (root.getRight() != null) {
//            traverseLrm(holder, root.getRight());
//        }
//
//        holder.add(root.getValue());
//    }
//
//    public static void traverseMlr(List<Integer> holder, Node root) {
//
//        holder.add(root.getValue());
//        if (root.getLeft() != null) {
//            traverseLrm(holder, root.getLeft());
//        }
//
//        if (root.getRight() != null) {
//            traverseLrm(holder, root.getRight());
//        }
//    }


    public static boolean search(Node root, int n) {
        if (n == root.getValue()) {
            return true;
        }

        if (n < root.getValue()) {
            if (root.getLeft() == null) {
                return false;
            }
            else {

                boolean resultFromLeft = search(root.getLeft(), n);
                return resultFromLeft;
            }
        }

        if (n > root.getValue()) {
            if (root.getRight() == null) {
                return false;
            }
            else {
                boolean resultFromRight = search(root.getRight(), n);
                return resultFromRight;
            }
        }
        return false;
    }

}
