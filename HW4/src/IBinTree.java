import java.util.LinkedList;

interface IBinTree {
    // determines whether element is in the tree
    boolean hasElt(int e);
    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();
    // returns depth of longest branch in the tree
    int height();

    public boolean isSmallest(int data);

    public boolean remMinEltValidator(IHeap hOrig, IBinTree hRemoved);

    public boolean isHeap();

    public int countNumElt(int elt);

    public LinkedList<Integer> listOfElt();


}
