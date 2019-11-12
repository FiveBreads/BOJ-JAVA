package greedyAlgorithm;
import java.util.*;
import java.util.*;
public class Num11399 {
	class Record{
        private int x;
        private int y;
        private int nx;
        private int ny;
        public Record(int a, int b, int c, int d){
            this.x = a;
            this.y = b;
            this.nx = c;
            this.ny = d;
        }
        
        @Override
        public int hashCode() {
        	String a = ""+x+y+nx+ny;
            return a.hashCode();
        }
        
        @Override
        public boolean equals(Object obj) {
            Record rcd = (Record) obj;
            if(rcd instanceof Record){
                return (x == rcd.x && y == rcd.y && nx == rcd.nx && ny == rcd.ny);
            }else{
                return false;
            }
            
        }
        
        
    }	
	
	public int solution(String dirs) {
        HashSet<Record> set = new HashSet<>();
        HashMap<Character, Integer> direction = new HashMap<>();
        direction.put('U', 0);
        direction.put('L', 1);      
        direction.put('D', 2); 
        direction.put('R', 3);
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int answer  = 0;        
        int x = 0, y = 0, nx = 0, ny = 0;     
        for(int i = 0; i < dirs.length(); i++){
            char dir = dirs.charAt(i);
            nx = x + dx[direction.get(dir)];
            ny = y + dy[direction.get(dir)];
            if(nx > 5 || nx < -5 || ny > 5 || ny < -5){
                continue;
            }
            
            if(!set.contains(new Record(x,y,nx,ny))) {
            	set.add(new Record(x,y,nx,ny));
                set.add(new Record(nx,ny,x,y));
                answer++;
            }            
            
            x = nx;
            y = ny;
        }
        
        
        return answer;
    }	
	public static void main(String[] args) {		
		
	}
}
