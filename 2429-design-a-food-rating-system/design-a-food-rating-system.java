class FoodRatings {
    Food[] foodList;
    Map<String, Integer> indexMap;
    Map<String, PriorityQueue<Food>> highestRated;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        foodList = new Food[n];
        indexMap = new HashMap<>();
        highestRated = new HashMap<>();
        for(int i=0; i<n; i++) {
            foodList[i] = new Food(foods[i], cuisines[i], ratings[i]);;
            indexMap.put(foods[i], i);
            PriorityQueue<Food> temp = highestRated.getOrDefault(cuisines[i], new PriorityQueue<>());
            temp.add(foodList[i]);
            highestRated.put(cuisines[i], temp);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int index = indexMap.get(food);
        Food temp = new Food(food, this.foodList[index].cuisine, newRating);;
        this.foodList[index] = temp;
        highestRated.get(this.foodList[index].cuisine).add(temp);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = highestRated.get(cuisine);
        Food temp = pq.peek();
        while(this.foodList[indexMap.get(temp.food)].getRating() != temp.getRating()) {
            pq.poll();
            temp = pq.peek();
        }
        return temp.food;
    }
}

class Food implements Comparable<Food>{
    String food;
    String cuisine;
    int rating;

    public Food(String food, String cuisine, int rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int compareTo(Food other) {
        if (rating == other.rating) {
            return food.compareTo(other.food);
        }
        return -1 * Integer.compare(rating, other.rating);
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */