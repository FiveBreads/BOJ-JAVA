package fastcampus;
import java.io.*;
import java.util.*;
public class Num16165 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());
		//N = �ɱ׷��� ��  M = ������ �� ������ ��
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
		//0�� ���̸�  1�� ����̸�
		//0�ϰ�� ��������������
		//1�ϰ�� �ش��ο��� ���Ե� ���� ���
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
