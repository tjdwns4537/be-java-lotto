package kr.codesquad.service;

import kr.codesquad.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLottoRobot implements MakeLottoInterface{

    public Person IssuedLotto(Person person) {
        for (int i = 0; i < person.getHaveLotto(); i++) {
            person.addLotto(make()); // 사용자 로또 생성
        }
        return person;
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
