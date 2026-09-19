class Solution {
     public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    for (String s : strs) {
      Map<Character, Integer> frequencyMap = getFrequencyMap(s);
      map.computeIfAbsent(frequencyMap, k -> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(map.values());
  }

  private Map<Character, Integer> getFrequencyMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return map;
  }
}
