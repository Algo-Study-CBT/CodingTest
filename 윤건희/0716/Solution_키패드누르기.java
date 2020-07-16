package 카카오인턴쉽2020;

public class Solution_키패드누르기 {
	
	static int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
	static String hand = "right";
	
	public static void main(String[] args) {
		String answer = "";
		boolean hand_flag = true;
		if(hand.equals("left"))hand_flag = false; // 오른손잡이 = true, 왼손잡이 = false
		int[] hand_loc = {10,12}; // 키패드상 왼손, 오른손 위치
		
		
		for(int i = 0 ; i < numbers.length;i++) {
			int num = numbers[i]; // 보기 쉽게하려고 num 선언
			if(num == 1 || num == 4 || num == 7) {
				answer += "L";
				hand_loc[0] = num;
			}
			else if(num == 3 || num == 6 || num == 9) {
				answer += "R";
				hand_loc[1] = num;
			}
			else { // 2 5 8 0 일때
				if(getDis(num, hand_loc[0]) < getDis(num, hand_loc[1])) { //왼손 더가까우면
					answer += "L";
					hand_loc[0] = num;
				}else if(getDis(num, hand_loc[0]) > getDis(num, hand_loc[1])) {// 오른손이 더 가까우면
					answer += "R";
					hand_loc[1] = num;
				}else {
					if(hand_flag) {
						answer += "R";
						hand_loc[1] = num;
					}else {
						answer += "L";
						hand_loc[0] = num;
					}
				}
			}
		}
		System.out.println(answer);
	}
	public static int getDis(int num, int loc) {// 누를숫자, 현재숫자
		int dis = 0;
		int diff = Math.abs(num-loc);
		if(loc == 0)loc = 11; //키패드상 위치
		if(num == 0)num = 11;
		if(diff % 3 == 0)dis = diff/3; //현재 2 5 8 0에 있을 때
		else dis = (diff + 1) / 3 +1;
		
		return dis;
	}

}
