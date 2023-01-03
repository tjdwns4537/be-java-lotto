package kr.codesquad.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLottoRobot implements MakeLottoInterface{

    public List<Integer> make() { // 사용자 로또 만들기
        List<Integer> lotto = new ArrayList<>();
        List<Integer> resultLotto = new ArrayList<>();
        for (int i = 1; i <= 45; i++) lotto.add(i);
        Collections.shuffle(lotto);
        for (int i = 0; i < 6; i++) resultLotto.add(lotto.get(i));
        Collections.sort(resultLotto);
        return resultLotto;
    }
}
