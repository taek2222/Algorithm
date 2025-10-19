import java.util.*;
import java.time.*;

class Solution {
    
    Map<String, String> musics = new LinkedHashMap<>();
    
    public String solution(String m, String[] musicinfos) {
        m = convert(m);
        
        for(String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");
            
            LocalTime start = LocalTime.parse(infos[0]);
            LocalTime end = LocalTime.parse(infos[1]);
            int length = (int) Duration.between(start, end).toMinutes();
            
            saveExtendMusic(convert(infos[3]), length, infos[2]);
        }
        
        String answer = "(None)";
        int maxLen = 0;
        
        for (String entry : musics.keySet()) {
            if(!entry.contains(m)) continue;
            int index = entry.indexOf(m);
            if(index + m.length() < entry.length() && entry.charAt(index + m.length()) == '#') continue;
            int len = entry.replace("#", "").length();
            if(len > maxLen) {
                maxLen = len;
                answer = musics.get(entry);
            }
        }
        
        return answer;
    }
    
    public void saveExtendMusic(String music, int length, String name) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.toString().replace("#", "").length() < length) {
            sb.append(music.charAt(i));
            if (i + 1 < music.length() && music.charAt(i + 1) == '#') {
                sb.append('#');
                i++;
            }
            i = (i + 1) % music.length();
        }
        
        musics.put(sb.toString(), name);
    }
    
    private String convert(String music) {
        return music
                .replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}