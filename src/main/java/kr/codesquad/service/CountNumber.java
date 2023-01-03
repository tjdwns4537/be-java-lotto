package kr.codesquad.service;

import kr.codesquad.domain.Person;

import java.util.List;

public class CountNumber {

    public Integer checkNumber(List<Integer> inputLotto, List<Integer> compLotto) { //로또 맞는 개수 구하기
        int cnt = 0;
        for (int i = 0; i < compLotto.size(); i++) {
            cnt = checkNumber(inputLotto, compLotto.get(i),cnt);
        }
        return cnt;
    }

    public int checkNumber(List<Integer> inputLotto, int b,int cnt) {
        if (inputLotto.contains(b)) {
            cnt++;
        }
        return cnt;
    }

    public Person collectNumberCount(Person person, List<Integer> winNumber) { // 로또 일치 개수 구하기
        for (int i = 0; i < person.getSize(); i++) {
            collectNumberCountIndex(person,winNumber,i);
        }
        return person;
    }

    public void collectNumberCountIndex(Person person, List<Integer> winNumber, int i) {
        int cnt = checkNumber(person.getLotto(i), winNumber);
        boolean check = false;
        if(cnt == 3) person.setWinNumber(0, person.getWinNumber(0)+1);
        if(cnt == 4) person.setWinNumber(1, person.getWinNumber(1)+1);
        if(cnt == 5){
            person.setWinNumber(2, person.getWinNumber(2)+1);
        }
        if(cnt == 6) person.setWinNumber(3, person.getWinNumber(3)+1);
    }
}
