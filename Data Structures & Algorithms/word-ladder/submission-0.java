class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length())
            return 0;

        Map<String, Set<String>> regexMap = new HashMap<>();
        for (String word : wordList) {
            for (String regex : prepareRegexes(word)) {
                regexMap.computeIfAbsent(regex, v -> new HashSet<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord))
                    return level;

                for (String regex : prepareRegexes(current)) {
                    if (visited.contains(regex))
                        continue;
                    visited.add(regex);
                    for (String word : regexMap.getOrDefault(regex, Set.of())) {
                        if (visited.contains(word))
                            continue;
                        visited.add(word);
                        queue.add(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private Set<String> prepareRegexes(String s) {
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, '*');
            result.add(sb.toString());
            sb.setCharAt(i, s.charAt(i));
        }
        return result;
    }
}
