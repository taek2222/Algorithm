class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        String[] c = wallpaper[0].split("");
        
        // 파일 저장 배열 생성 
        boolean[][] wallpaperArray = new boolean[wallpaper.length][c.length];
        
        System.out.println("파일 세로 크기 확인 = " + wallpaperArray.length + " 파일 가로 크기 확인 = " + wallpaperArray[0].length);
        
        for(int i = 0; i < wallpaper.length; i++) {
            String[] division = wallpaper[i].split("");
            
            for(int j = 0; j < division.length; j++) {
                if(division[j].equals("#"))
                    wallpaperArray[i][j] = true;
            }
        }
        
        for(int i = 0; i < wallpaperArray.length; i++) {
            for(int j = 0; j < wallpaperArray[0].length; j++)
                System.out.print(wallpaperArray[i][j] + " ");
            System.out.println();
        }
        
        answer[0] = lux(wallpaperArray);
        answer[1] = luy(wallpaperArray);
        answer[2] = rdx(wallpaperArray);
        answer[3] = rdy(wallpaperArray);
        
        return answer;
    }
    
    public int lux(boolean[][] wallpaperArray) {
        for(int i = 0; i < wallpaperArray.length; i++)
            for(int j = 0; j < wallpaperArray[0].length; j++)
                if(wallpaperArray[i][j])
                    return i;
        return 0;
    }
    
    public int luy(boolean[][] wallpaperArray) {
        for(int j = 0; j < wallpaperArray[0].length; j++)
            for(int i = 0; i < wallpaperArray.length; i++)
                if(wallpaperArray[i][j])
                    return j;
        return 0;
    }
    
    public int rdx(boolean[][] wallpaperArray) {
        for(int i = wallpaperArray.length - 1; i >= 0 ; i--)
            for(int j = 0; j < wallpaperArray[0].length; j++)
                if(wallpaperArray[i][j])
                    return i+1;
        return 0;
    }
    
    public int rdy(boolean[][] wallpaperArray) {
        for(int j = wallpaperArray[0].length - 1; j >= 0; j--)
            for(int i = 0; i < wallpaperArray.length; i++)
                if(wallpaperArray[i][j])
                    return j+1;
        return 0;
    }
}