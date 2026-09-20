class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lowerBound = 0;
        int upperBound = 0;
        for(int pile : piles){
            lowerBound += pile / h;
            upperBound = Math.max(upperBound, pile);
        }
        lowerBound = Math.max(lowerBound, 1);

        while(lowerBound < upperBound){
            int mid = lowerBound + ((upperBound - lowerBound) / 2);
            if(isValid(piles, mid, h)){
                upperBound = mid;
            } else {
                lowerBound = mid + 1;
            }
        }
        return lowerBound;
    }

    private boolean isValid(int[] piles, int k, int h){
        int hours = 0;
        for(int pile : piles){
            boolean carry = pile % k > 0;
            hours += pile / k;
            if(carry){
                hours++;
            }
            if(hours > h){
                return false;
            }
        }
        return true;
    }
}
