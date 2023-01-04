package kr.codesquad.service;

import kr.codesquad.domain.Person;
import kr.codesquad.service.Input.ScannerInput;
import kr.codesquad.service.Inteface.MakeLottoInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeLottoPerson implements MakeLottoInterface {

    ScannerInput scannerInput = new ScannerInput();

    @Override
    public void IssuedLotto(Person person) {
        for (int i = 0; i < person.getHaveHandLotto(); i++) {
            person.addLotto(make()); // 사용자 로또 생성
        }
    }

    @Override
    public List<Integer> make() {
        String numberLine = scannerInput.inputLine();
        String[] split = numberLine.split(",");
        List<String> inputNumber = Arrays.asList(split);
        List<Integer> changeInteger = new ArrayList<>();
        for (String i : inputNumber) {
            changeInteger.add(Integer.parseInt(i.trim()));
        }
        return changeInteger;
    }
}
