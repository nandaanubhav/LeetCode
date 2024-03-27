class ProductOfNumbers {
    List<Integer> prefixProduct;
    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0) prefixProduct = new ArrayList<>();
        else if(prefixProduct.isEmpty()) prefixProduct.add(num);
        else prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
    }
    
    public int getProduct(int k) {
        if(prefixProduct.size() < k) return 0;
        else if(prefixProduct.size() == k) return prefixProduct.get(prefixProduct.size() - 1);
        else return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct.get(prefixProduct.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */