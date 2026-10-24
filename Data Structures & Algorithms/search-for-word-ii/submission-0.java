
class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
            { 0, 1 },  // prawo
            { 1, 0 },  // dół
            { 0, -1 }, // lewo
            { -1, 0 }  // góra
    };

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = constructTrie(words);
        List<String> result = new ArrayList<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                dfs(board, x, y, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int x, int y, TrieNode node, List<String> result) {
        char c = board[x][y];
        
        // Jeśli pole było już odwiedzone lub nie ma litery w Trie, wychodzimy
        if (c == '#' || !node.children.containsKey(c)) {
            return;
        }

        node = node.children.get(c);
        
        // Jeśli znaleźliśmy słowo
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Unikamy duplikatów
        }

        // Oznaczamy jako odwiedzone
        board[x][y] = '#';

        // Sprawdzamy 4 sąsiadów
        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (validCoord(board, newX, newY)) {
                dfs(board, newX, newY, node, result);
            }
        }

        // Cofamy zaznaczenie (Backtracking)
        board[x][y] = c;
    }

    private boolean validCoord(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private TrieNode constructTrie(String[] words) {
        TrieNode head = new TrieNode();
        for (String w : words) {
            head.insert(w);
        }
        return head;
    }

    class TrieNode {
        String word;
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
        }

        void insert(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, v -> new TrieNode());
            }
            node.word = word;
        }
    }
}