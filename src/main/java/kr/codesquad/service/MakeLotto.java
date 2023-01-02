package kr.codesquad.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLotto {

    public Integer buy(Integer money) {
        return money / 1000;
    }

    public List<Integer> make() { // 사용자 로또 만들기
        List<Integer> lotto = new ArrayList<>();
        List<Integer> resultLotto = new ArrayList<>();
        for (int i = 1; i <= 45; i++) lotto.add(i);
        Collections.shuffle(lotto);
        for (int i = 0; i < 6; i++) resultLotto.add(lotto.get(i));
        Collections.sort(resultLotto);
        return resultLotto;
    }

    public Integer checkNumber(List<Integer> inputLotto, List<Integer> compLotto) { //로또 맞는 개수 구하기
        int cnt = 0;
        for (int i = 0; i < compLotto.size(); i++) {
            if (inputLotto.contains(compLotto.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }
}
