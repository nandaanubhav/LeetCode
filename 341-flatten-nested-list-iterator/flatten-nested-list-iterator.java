/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int index;
    List<Integer> nestedList;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = new ArrayList<>();
        index = 0;
        addToList(nestedList);   
    }

    private void addToList(List<NestedInteger> nestedList) {
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) this.nestedList.add(ni.getInteger());
            else addToList(ni.getList());
        }
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            return null;
        }
        return this.nestedList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < this.nestedList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */