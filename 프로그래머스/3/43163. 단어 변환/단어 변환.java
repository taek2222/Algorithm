import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    
    class Word {
        public String word;
        public int count;
        
        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visit = new boolean[words.length];
        
        Deque<Word> deque = new ArrayDeque<>();
        deque.add(new Word(begin, 0));
        
        while(!deque.isEmpty()) {
            Word current = deque.pop();
            for(int i = 0; i < words.length; i++) {
                if(visit[i] || current.word.equals(words[i])) {
                    continue;
                }
                
                if(check(current.word, words[i])) {
                    continue;
                }
                
                if(words[i].equals(target)) {
                    return current.count + 1;
                }
                
                visit[i] = true;
                deque.add(new Word(words[i], current.count + 1));
            }
        }
        
        return 0;
    }
    
    private boolean check(String begin, String target) {
        int count = 0;
        for(int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        
        return count != begin.length() - 1;
    }
}