package fastcampus;
import java.io.*;
import java.util.*;
public class Num16165 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		//N = 걸그룹의 수  M = 맞혀야 할 문제의 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String groupName = input.readLine();
			int groupNum = Integer.parseInt(input.readLine());
			for(int j = 0; j < groupNum; j++) {
				map.put(input.readLine(), groupName);
			}
		}
		//0과 팀이름  1과 멤버이름
		//0일경우 팀멤버사전순출력
		//1일경우 해당인원이 포함된 팀명 출력
		for(int i = 0; i < M; i++) {
			String ques = input.readLine();
			int quesNum = Integer.parseInt(input.readLine());
			if(quesNum == 0) {
				List<String> list = new ArrayList<>();
				for(Map.Entry<String, String> entry : map.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					if(value.equals(ques)) {
						list.add(key);
					}
				}
				Collections.sort(list);
				for(int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j));
				}
			}else {
				System.out.println(map.get(ques));
			}
		}		
	}
}
