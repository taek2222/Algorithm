import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
	static String[][] relations;
	static Stack<Integer> s;
	static List<Integer> ans;
	static boolean[] check;
	static int row, col;
    
	public int solution(String[][] relation) {
		relations = relation;
		col = relation.length;
		row = relation[0].length;

		ans = new ArrayList<>();
		for(int i=0; i<row; i++) {
			s= new Stack<>();
			check= new boolean[row];
			comb(0, i+1);
		}
		return ans.size();
	}
	
	static void comb(int pos, int r) {
		if(s.size() == r) {
			List<Integer> res = new ArrayList<>();
			for(int num : s) {
				res.add(num);
			}
			
			if(isSubKey(res)) { // 해당 집합이 중복 컬림이 존재하는지 (유일성)
				int cur =0;
				for(int num : res) {
					cur |= 1<<(num);
				}
				if(!isSubSet(cur)) { // 부분집합에 해당되지 않는지 (최소성)
					ans.add(cur); // 후보키 만족할 경우 후보키로 저장
				}
			}
			return;
		}
		for(int i=pos; i<row; i++) {
			if(!check[i]) {
				check[i] = true;
				s.push(i);
				comb(i,r);
				s.pop();
				check[i] = false;
			}
		}
	}
	
	static boolean isSubKey(List<Integer> rowList) {
		Set<String> set = new HashSet<>();
        for(int i=0; i<col; i++) {
        	String data = "";
        	for(int row : rowList) {
        		data += relations[i][row];
        	}
        	if(set.contains(data)) {
        		return false;
    		}
    		set.add(data);
        }
        return true;
	}
	
	static boolean isSubSet(int now) {
		for(int i=0; i<ans.size(); i++) {
			int ansData = ans.get(i);
			if((ansData & now) == ansData) return true;
		}
		return false;
	}
}