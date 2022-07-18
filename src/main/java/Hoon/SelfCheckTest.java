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

        System.out.println("오늘 활동량 단계를 입력하세요. (InformationMapper.xml~5단계)");
        System.out.println("1단계 아주 가볍게 || 2단계 조금 가볍게  || 3단계 보통 || 4단계 조금 강하게 || 5단계 아주 강하게");
        System.out.println("자세한 설명을 원하시면 0번을 눌러주세요.");
        sc.nextLine();



        while (true) {

            dayEnergy = sc.nextInt();

            if (dayEnergy == 0) {
                    System.out.println("1단계 호흡의 변화 없음 (스트레칭)|| 2단계 숨이 깊어지지만 편히 대화 가능 (걷기)|| 3단계 대화하기엔 숨쉬기 다소 힘든정도 (적당한 달리기)");
                    System.out.println("4단계 숨이 많이 차고 숨쉬기 힘든 정도 (빠른 달리기)|| 5단계 숨쉬기 매우 힘들고 극도록 힘이 드는 정도 (전력 달리기)");
                    System.out.println("이제 알맞는 번호를 선택해주세요.");
            } else if (dayEnergy == 1) {
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
