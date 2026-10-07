class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0 || n == 0){
            return tasks.length;
        }

        // A C B A C _ A C
        // A B A C B C _ C
        // C A C A B C B
        // A B C A B C  
        int[] counts = new int[26];
        for(char task : tasks){
            counts[task - 'A']++;
        }
        Queue<Character> taskQueue = new PriorityQueue<>(Comparator.comparing(c -> -counts[c - 'A']));
        for(char i = 0; i < 26; i++){
            if(counts[i] > 0)
            taskQueue.add((char)('A' + i));
        }

        Queue<TaskCooldown> cooldown = new ArrayDeque<>();
        int counter = 0;
        while(!taskQueue.isEmpty() || !cooldown.isEmpty()) {
            counter++;
            while(!cooldown.isEmpty() && counter - cooldown.peek().usedAt > n){
                taskQueue.add(cooldown.poll().task);
            }
            if(!taskQueue.isEmpty()){
                char popped = taskQueue.poll();
                counts[popped - 'A']--;
                if(counts[popped - 'A'] > 0)
                    cooldown.add(new TaskCooldown(popped, counter));
            }
        }
        return counter;
    }

    private static class TaskCooldown {
        char task;
        int usedAt;
        TaskCooldown(char task, int usedAt){
            this.task = task;
            this.usedAt = usedAt;
        }
    }
}
