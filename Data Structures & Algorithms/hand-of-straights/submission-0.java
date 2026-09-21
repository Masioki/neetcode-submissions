class Solution {
    public boolean isNStraightHand(int[] hands, int groupSize) {
        if(hands.length == 0){
            return false;
        }
        if(hands.length % groupSize != 0){
            return false;
        }
        
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for(var hand : hands){
            if(!counts.containsKey(hand)){
                counts.put(hand, 0);
            }
            counts.put(hand, counts.get(hand) + 1);
        }
        while(!counts.isEmpty()){
            int key = counts.firstKey();
            decrement(counts, key);
            for(int i = 1; i < groupSize; i++){
                if(!counts.containsKey(key+i)){
                    return false;
                }
                decrement(counts, key+i);
            }
        }

        return true;
    }

    private void decrement(Map<Integer, Integer> counts, int value){
        counts.put(value, counts.get(value) - 1);
        if(counts.get(value) == 0){
            counts.remove(value);
        }
    }
}
