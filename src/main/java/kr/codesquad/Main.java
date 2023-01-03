package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;
import kr.codesquad.service.CountNumber;
import kr.codesquad.service.InputService;
import kr.codesquad.service.MakeLottoRobot;
import kr.codesquad.service.ScannerInput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Person person = new Person();
    static Lotto lotto = new Lotto();
    static CountNumber countNumber = new CountNumber();
    static InputService inputService = new InputService();

    public static void main(String[] args) {
        inputService.startInput(person,lotto);
        person = countNumber.collectNumberCount(person, lotto.getWinNumber());
        person.print(person.getMoney());
    }
}