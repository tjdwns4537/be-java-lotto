package kr.codesquad.service;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;

import java.util.List;

public class CountNumber {

    public Person collectNumberCount(Person person, Lotto lotto) { // 로또 일치 개수 구하기
        for (int i = 0; i < person.getSize(); i++) {
            collectNumberCountIndex(person,lotto,i);
        }
        return person;
    }

    public void collectNumberCountIndex(Person person, Lotto lotto, int i) {
        int cnt = checkNumber(person.getLotto(i), lotto.getWinNumber());

        if(cnt == 3) person.setWinNumberArr(0,person.getWinNumberArr(0)+1);
        if(cnt == 4) person.setWinNumberArr(1,person.getWinNumberArr(1)+1);
        if(cnt == 5) checkBonus(person.getLotto(i),lotto.getBonus(),person);
        if(cnt == 6) person.setWinNumberArr(4,person.getWinNumberArr(4)+1);
    }

    public Integer checkNumber(List<Integer> inputLotto, List<Integer> compLotto) { //로또 맞는 개수 구하기
        int cnt = 0;
        for (int i = 0; i < compLotto.size(); i++) {
            cnt = checkNumberCount(inputLotto, compLotto.get(i),cnt);
        }
        return cnt;
    }

    public int checkNumberCount(List<Integer> inputLotto, int b,int cnt) {
        if (inputLotto.contains(b)) {
            cnt++;
        }
        return cnt;
    }

    public void checkBonus(List<Integer> list, int bonus, Person person) {
        if(!list.contains(bonus)) person.setWinNumberArr(2, person.getWinNumberArr(2)+1);
        if(list.contains(bonus)) person.setWinNumberArr(3, person.getWinNumberArr(3)+1);
    }
}
