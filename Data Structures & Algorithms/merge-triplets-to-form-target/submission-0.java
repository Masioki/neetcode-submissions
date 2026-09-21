class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a = 0;
        int b = 0;
        int c = 0;
        for(var triplet : triplets){
            if(!lessOrEqual(triplet, target)){
                continue;
            }
            if(equalsAt(triplet, target, 0)){
                a++;
            }
            if(equalsAt(triplet, target, 1)){
                b++;
            }
            if(equalsAt(triplet, target, 2)){
                c++;
            }
        }
        return a > 0 && b > 0 && c > 0;
    }

    private boolean lessOrEqual(int[] triplet, int[] target){
        return lessOrEqualAt(triplet, target, 0)
        && lessOrEqualAt(triplet, target, 1)
        && lessOrEqualAt(triplet, target, 2);
    }

    private boolean equalsAt(int[] value,  int[] target, int index){
        return target[index] == value[index];
    }

    private boolean lessOrEqualAt(int[] triplet, int[] target, int index){
        return triplet[index] <= target[index];
    }
}
