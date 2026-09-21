class Solution {
 public List<Integer> partitionLabels(String s) {
    int[] counts = new int[26];
    for(char c : s.toCharArray()){
      counts[toIndex(c)]++;
    }

    int start = 0;
    int end = 0;
    List<Integer> results = new LinkedList<>();
    Set<Character> partition = new HashSet<>();
    while(end < s.length()){
      char current = s.charAt(end);
      partition.add(current);
      int count = --counts[toIndex(current)];
      if(count == 0){
        partition.remove(current);
      }
      if(partition.isEmpty()) {
        results.add(end - start + 1);
        end = end + 1;
        start = end;
      } else {
        end++;
      }
    }
    return results;
  }

  private int toIndex(char c){
    return c - 'a';
  }
}
