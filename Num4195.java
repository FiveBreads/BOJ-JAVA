package fastcampus;
import java.io.*;
import java.util.*;
public class Num4195 {
	/* Union-Find 알고리즘  */
	static HashMap<String, Integer> person;
	static int[] parent;
	static int[] relation;
	
	static int findParent(int p) {
		if(p == parent[p]) {
			return p;
		}else {
			return parent[p] = findParent(parent[p]);			
		}			
	}
	
	static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);		
		if(x != y) {
			parent[y] = x;			
			relation[x] += relation[y];
		}		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCase; i++) {
			person = new HashMap<>();
			parent = new int[200001];
			relation = new int[200001];
			for(int j = 0; j < 200001; j++) {
				parent[j] = j;
				relation[j] = 1;
			}
			int F = Integer.parseInt(br.readLine());
			int idx = 0;
			for(int j = 0; j < F; j++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if(!person.containsKey(a)) {
					person.put(a, idx++);					
				}
				if(!person.containsKey(b)) {
					person.put(b, idx++);					
				}
				
				int p1 = person.get(a);
				int p2 = person.get(b);
			
				union(p1, p2);
				System.out.println(relation[findParent(p1)]);				
			}			
		}
	}
}
