import java.util.*;

class Solution {
    
    class Word {
        String word;
        int loopCount;
        
        public Word(String word, int loopCount) {
            this.word = word;
            this.loopCount = loopCount;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Deque<Word> deque = new ArrayDeque<>();
        deque.add(new Word(begin, 0));
        
        boolean[] visit = new boolean[words.length];
        
        while(!deque.isEmpty()) {
            Word current = deque.poll();
            String currentWord = current.word;
            int loopCount = current.loopCount;
            
            for(int i = 0; i < words.length; i++) {
                if(currentWord.equals(target)) {
                    return loopCount;
                }
                
                if(checkWord(currentWord, words[i])) {
                    if(visit[i]) {
                        continue;
                    }
                    visit[i] = true;
                    deque.add(new Word(words[i], loopCount + 1));
                }
            }
        }
        return 0;
    }
    
    public boolean checkWord(String word, String otherWord) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            char wordCh = word.charAt(i);
            char otherWordCh = otherWord.charAt(i);
            
            if(wordCh != otherWordCh) {
                count++;
            }
        }
        return count == 1;
    }
}

/**
    1. begin 넣고
    2. words 돌면서 하나 차이나는 것만 큐에 저장
    3. 방문한 단어는 제외
    4. 찾다가 tartget 나오면 끝
**/