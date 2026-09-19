class Solution {

  public int carFleet(int target, int[] position, int[] speed) {
    if(position.length == 0){
      return 0;
    }

    List<int[]> temp = new ArrayList<>();
    for(int i = 0; i <position.length; i++){
      temp.add(new int[]{position[i], speed[i]});
    }
    temp.sort(Comparator.comparing(v -> v[0]));
    Stack<Double> times = new Stack<>();
    for(var v : temp){
      times.push(((double)(target - v[0])) / v[1]);
    }
    int fleets = 0;
    while(!times.isEmpty()){
      double first = times.pop();
      if(times.isEmpty()){
        fleets++;
        break;
      }
      double second = times.pop();
      if(first < second){
        fleets++;
      }
      times.push(Math.max(first, second));
    }
    return fleets;
  }
}
