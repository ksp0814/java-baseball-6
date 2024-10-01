package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException {

        System.out.println("숫자 야구 게임을 시작합니다.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int number;
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            try {
                number = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                continue;
            }

            if (number < 100 || number > 999) { // 입력 값이 정해진 값을 벗어 낫을 경우 예외 try-catch문 + if 를 통해서 예외처리를 해주었다.
                throw new IllegalArgumentException();
            }




//            int number = Integer.parseInt(br.readLine()); // 숫자 입력받기
//            if (number > 1000) {
//                break;
//            }

            int strike = 0;
            int ball = 0;


            int first_number = number / 100; // 100 자릿수
            int second_number = (number / 10) % 10; // 10의 자릿수
            int third_number = number % 10; // 1의 자릿수

            int[] number_arr = {first_number, second_number, third_number}; // 입력 각 자릿수의 값을 리스트화
//            System.out.println("computer = "+computer);
//            System.out.println("number_arr = " + Arrays.toString(number_arr));

            for (int i = 0; i < number_arr.length; i++) {  // 각 자리수 비교하고 strike ball 추가하는 로직
                for (int j = 0; j < number_arr.length; j++) {
                    if (computer.get(i) == number_arr[j] && i == j) {
                        strike++;
                        break;
                    } else if (computer.get(i) == number_arr[j]) {
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
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                }else if (ans == 2) {
                    System.out.println("게임 종료");
                    break;
                }
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
                continue;
            } else if (strike > 0 && ball == 0) {
                System.out.println(strike+"스트라이크");
            } else if (strike == 0 && ball > 0) {
                System.out.println(ball+"볼");
            }
        }
    }
}
