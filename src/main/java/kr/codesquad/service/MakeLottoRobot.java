package kr.codesquad.service;

import kr.codesquad.domain.Person;
import kr.codesquad.service.Inteface.MakeLottoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLottoRobot implements MakeLottoInterface {

    public void IssuedLotto(Person person) {
        for (int i = 0; i < person.getHaveRobotLotto(); i++) {
            person.addLotto(make()); // 사용자 로또 생성
        }
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
}
