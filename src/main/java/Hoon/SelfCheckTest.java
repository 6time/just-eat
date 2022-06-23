package Hoon;

import java.util.Scanner;

public class SelfCheckTest {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int dayKcal;
        int dayWeight;
        int dayEnergy;

        System.out.println("오늘 섭취하신 칼로리를 입력하세요.");
        dayKcal = sc.nextInt();

        System.out.println("현재 몸무게를 입력하세요.");
        dayWeight = sc.nextInt();

        System.out.println("오늘 활동량 단계를 입력하세요. (1~5단계)");
        System.out.println("1단계 걷기 || 2단계 간단한 산책 || 3단계 조깅 || 4단계 || 5단계");

        while (true) {
            dayEnergy = sc.nextInt();
            if (dayEnergy == 1) {
                System.out.println("1번을 입력하셨습니다.");
                break;
            } else if (dayEnergy == 2) {
                System.out.println("2번을 입력하셨습니다.");
                break;
            } else if (dayEnergy == 3) {
                System.out.println("3번을 입력하셨습니다.");
                break;
            } else if (dayEnergy == 4) {
                System.out.println("4번을 입력하셨습니다.");
                break;
            } else if (dayEnergy == 5) {
                System.out.println("5번을 입력하셨습니다.");
                break;
            } else {
                System.out.println("올바른 번호를 입력하세요.");

            }
        }
        System.out.println(dayKcal);
        System.out.println(dayWeight);
        System.out.println(dayEnergy);


    }
}
