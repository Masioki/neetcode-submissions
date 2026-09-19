class Solution {
  public String encode(List<String> strs) {
    return strs.stream()
        .map(s -> s.replace("%", "%25"))
        .map(s -> s.replace(" ", "%20"))
        .map(s -> s.isEmpty() ? "%22" : s)
        .collect(Collectors.joining(" "));
  }

  public List<String> decode(String str) {
    if(str.isEmpty()) return Collections.emptyList();
    return Arrays.stream(str.split(" "))
        .map(s -> s.replace("%22", ""))
        .map(s -> s.replace("%20", " "))
        .map(s -> s.replace("%25", "%"))
        .toList();
  }
}
