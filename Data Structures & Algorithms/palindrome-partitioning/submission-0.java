class Solution {
  public List<List<String>> partition(String s) {
    Map<Integer, List<List<String>>> cache = new HashMap<>();
    cache.put(s.length(), List.of(List.of()));
    return partition(s, 0, cache);
  }

  private List<List<String>> partition(String word, int wordIdx, Map<Integer, List<List<String>>> cache){
    if(cache.containsKey(wordIdx)){
      return cache.get(wordIdx);
    }

    List<List<String>> result = new ArrayList<>(); // ?
    StringBuilder builder = new StringBuilder();
    for(int i = wordIdx; i < word.length(); i++){
      builder.append(word.charAt(i));
      if(isPalindrome(builder)){
        List<List<String>> subpartitions = partition(word, i+1, cache);
        for(var sub : subpartitions){
          sub = new ArrayList<>(sub);
          sub.addFirst(builder.toString());
          result.add(sub);
        }
      }
    }
    cache.put(wordIdx, result);
    return result;
  }

  private boolean isPalindrome(StringBuilder s){
    int start = 0;
    int end = s.length() - 1;
    while(start <= end){
      if(s.charAt(start) != s.charAt(end)){
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
