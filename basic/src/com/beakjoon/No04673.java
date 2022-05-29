package com.beakjoon;

import java.util.ArrayList;
import java.util.List;

/**
 *  셀프 넘버
 */
public class No04673 {
  // 셀프 넘버가 아닌 값이 들어가는 List 생성
  public static List notSelfNum = new ArrayList();

  public static void main(String[] args) {
    // notSelfNum에 셀프 넘버가 아닌 값을 넣어주는 메소드
    arrayStart();
    // 1부터 10000까지 셀프 넘버인지 확인하기 위해 판별
    for (int i = 0; i < 10001; i++)
      // isSelfNum메소드에 i값을 넣는다.
      // false 일경우에만 출력
      if (!isSelfNum(i))
        System.out.println(i);
  }

  private static boolean isSelfNum(int i) {
    // i값이 List에 없으면 SelfNum이므로 false반환
    return notSelfNum.contains(i);
  }

  private static void arrayStart() {
    // 1부터 10000까지 모든 생성자값을 구한다.
    // ex) ab + a + b = cd
    for (int i = 0; i < 10001; i++) {
      // 생성자를 구하기 위해 ab값을 먼저 넣어준다.
      int sum = i;
      // 값의 길이를 구하기위해 String으로 변환
      String num = String.valueOf(i);
      // for 문을 이용해 sum에 각각 자리수의 값을 더해준다.
      for (int j = 0; j < num.length(); j++)
        sum += Integer.parseInt(num.substring(j, j+1));
      // 값을 List에 넣어준다.
      notSelfNum.add(sum);
    }

  }
}
