public class HeapChecker {

    /**
     *
     * @param hOrig represents the original tree
     * @param elt represents the element added
     * @param hAdded represents the new tree with elt added
     * @return true if addElt is a valid operation to perform on hOrig
     */
    public boolean addEltValidator(IHeap hOrig, int elt , IBinTree hAdded) {
        if(hOrig.isHeap() && hAdded.isHeap()) {
            for(int i : hAdded.listOfElt()) {
                if(i == elt && hOrig.size() + 1 == hAdded.size()) {
                    continue;
                } else if(hOrig.countNumElt(i) == hAdded.countNumElt(i)) {
                    continue;
                } else return false;
            } return true;
        } return false;
    }

    /**
     *
     * @param hOrig represents the original tree
     * @param hRemoved represents the new tree with the smallest element removed
     * @return true if remMinElt is a valid operation to perform on hOrig
     */
    public boolean remMinEltValidator(IHeap hOrig, IBinTree hRemoved) {
        if(hOrig.isHeap() && hRemoved.isHeap()) {
            for(int i : hOrig.listOfElt()) {
                if(i == hOrig.listOfElt().iterator().next() && hOrig.size() - 1 == hRemoved.size()) {
                    continue;
                } else if(hOrig.countNumElt(i) == hRemoved.countNumElt(i)) {
                    continue;
                } else return false;
            } return true;
        } return false;
    }
}