package gyeong_in_shake;
import java.io.*;
public class Num17301 {	
	static boolean[] visited;	
	static String[] words;
	static int N;
	
	static String target = "NC";
	static long res = 0;
	
	static void dfs(String word, int depth, boolean flag) {
		if(depth < N) {
			if(!flag) {
				String str = "";				
				for(int i = 0; i < word.length(); i++) {
					if(word.charAt(i) == 'N' || word.charAt(i) == 'C') {
						str += word.charAt(i);
					}
				}
				if(str.contains("NC")) {
					res++;
					flag = true;
				}
			}else {
				res++;
			}						
		}else {
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(flag) {
					dfs(word, depth+1, flag);
				}else {
					dfs(word+words[i], depth+1, flag);
				}				
				visited[i] = false;
			}			
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N+1];
		visited = new boolean[N+1];
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(words[i], 0, false);
			visited[i] = false;			
		}
		System.out.println(res%1000000007);
	}
}
