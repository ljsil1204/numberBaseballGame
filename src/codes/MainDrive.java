package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		[응용문제2] 숫자 야구 게임
		
//		1. 컴퓨터 랜덤 3자리 숫자 문제 출제
		
		int[] questNumArr = new int[3];
		
		for(int i=0; i<questNumArr.length; i++) {
			while(true) {

//				1) 1~9범위 숫자 추출 
				int random = (int) (Math.random() * 9 + 1);
				
//				2) 중복검사
				boolean isDuplOk = true;
				
				for(int qusetNum : questNumArr) {
					
					if(qusetNum == random) {
						isDuplOk = false;
						break;
					}
					
				}
				
//				3) 배열에 숫자 기록
				if(isDuplOk) {
					questNumArr[i] = random;
					break;
				}
				
			}

		}
		
//		확인 - 랜덤 3자리 숫자
//		for(int questNum : questNumArr) {
//			System.out.print(questNum);
//		}
//		
//		System.out.println();
				
		
//		2. 스캐너로 3자리 숫자 입력받기
		
		Scanner myScanner = new Scanner(System.in);
		
//		1) 3자리 숫자를 입력받기 => 맞출때 까지 입력 받아야함.
		
		int inputCount = 0;
		
		while(true) {
			
			System.out.print("3자리 숫자를 입력해주세요 : ");
			int inputNum = myScanner.nextInt();
			
//			2) 숫자를 배열로 분리해서 저장.

			int[] myNumberArr = new int[3];
			
			for(int i=0; i<myNumberArr.length; i++) {
				
				int numBackUp = inputNum;
				
				if(i == 0) {
					inputNum /= 100;
					myNumberArr[i] = inputNum;
				}
				else if(i == 1) {
					inputNum = (inputNum / 10) % 10;
					myNumberArr[i] = inputNum;
				}
				else {
					inputNum %= 10;
					myNumberArr[i] = inputNum;
				}
				
				inputNum = numBackUp;
				
			}
			
			
//			3) 두 배열을 비교 => "S" , "B" 판정
			int numCountB = 0;
			int numCountS = 0;

			boolean isPositionOk = false;
			
//			숫자O, 위치O
			for(int i=0; i<myNumberArr.length; i++) {
				if(questNumArr[i] == myNumberArr[i]) {
					numCountS++;
					isPositionOk = true;
				}
			}
			
//			숫자O, 위치X
			for(int questNum : questNumArr) {
				
				for(int myNum : myNumberArr) {
					
					if(questNum == myNum) {
						
						numCountB++;
							
					}
					
				}
				
			}
			
//			"B" : 위치까지 같은 중복횟수 빼기
			if(isPositionOk) {
				for(int i=0; i<numCountS; i++) {
					numCountB--;
				}
			}
			
//			4) 판정 출력
			System.out.println(numCountS + "S " + numCountB + "B");
			
//			입력한 횟수	
			inputCount++;
			
//			5) 3S를 맞추면 무한반복 탈출, 추가메시지 출력
			if(numCountS == 3) {
				System.out.println("축하합니다. 정답입니다.");
				
//				몇번만에 맞췄는지
				System.out.println(inputCount + "번 만에 정답을 맞췄습니다.");
				
				break;
			}
			
		}
		
	}
	
}
