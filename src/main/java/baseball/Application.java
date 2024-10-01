package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException {

        System.out.println("숫자 야구 게임을 시작합니다.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Random random = new Random(); // 랜덤 함수 지정
        int target; // 타겟을 설정

        while (true) {
            target = random.nextInt(100,1000);

            int first = target / 100;
            int second = (target / 10) % 10;
            int third = target % 10;

            if (first != second && first != third && second != third) {
                break;
            }
        }

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            int number = Integer.parseInt(br.readLine()); // 숫자 입력받기
            if (number > 1000) {
                break;
            }

            int strike = 0;
            int ball = 0;

            int first_target = target / 100; // 100 자릿수
            int second_target = (target / 10) % 10; // 10의 자릿수
            int third_target = target % 10; // 1의 자릿수

            int[] target_arr = {first_target, second_target, third_target}; // 타겟 각 자릿수의 값을 리스트로 생성
            System.out.println("target_arr = " + Arrays.toString(target_arr));

            int first_number = number / 100; // 100 자릿수
            int second_number = (number / 10) % 10; // 10의 자릿수
            int third_number = number % 10; // 1의 자릿수

            int[] number_arr = {first_number, second_number, third_number}; // 입력 각 자릿수의 값을 리스트화
            System.out.println("number_arr = " + Arrays.toString(number_arr));

            for (int i = 0; i < number_arr.length; i++) {  // 각 자리수 비교하고 strike ball 추가하는 로직
                for (int j = 0; j < number_arr.length; j++) {
                    if (target_arr[i] == number_arr[j] && i == j) {
                        strike++;
                        break;
                    } else if (target_arr[i] == number_arr[j]) {
                        ball++;
                    }
                }
            }

            if (strike > 0 && ball > 0) {  // 출력하는 로직
                System.out.println(ball+"볼 "+strike+"스트라이크");
            } else if (strike == 3){
                System.out.println(strike+"스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    // 여기에 새로 게임을 시작하는 코드를 작성하면 될듯
                    while (true) {
                        target = random.nextInt(100, 1000);

                        int first = target / 100;
                        int second = (target / 10) % 10;
                        int third = target % 10;

                        if (first != second && first != third && second != third) {
                            break;
                        }
                    }
                }else if (ans == 2) {
                    break;
                }
            } else if (strike == 0 && ball == 0) {
                continue;
            } else if (strike > 0 && ball == 0) {
                System.out.println(strike+"스트라이크");
            } else if (strike == 0 && ball > 0) {
                System.out.println(ball+"볼");
            }
        }
    }
}
