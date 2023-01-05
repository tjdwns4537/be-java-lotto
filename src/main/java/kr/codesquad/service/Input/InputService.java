package kr.codesquad.service.Input;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;
import kr.codesquad.exception.CustomException;
import kr.codesquad.service.Inteface.MakeLottoInterface;
import kr.codesquad.service.MakeLottoPerson;
import kr.codesquad.service.MakeLottoRobot;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputService {

    CustomException customException = new CustomException();
    ScannerInput scannerInput = new ScannerInput();
    MakeLottoInterface makeLottoRobot = new MakeLottoRobot();
    MakeLottoInterface makeLottoPerson = new MakeLottoPerson();

    public void startPersonInput(Person person) throws Exception{
        // 구입 금액를 1000원 단위로 설정 필요
        System.out.println("구입금액을 입력해 주세요.");
        buy(person);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        makeLottoPerson.IssuedLotto(person);
        makeLottoRobot.IssuedLotto(person);
        System.out.println("수동으로 "+ person.getHaveHandLotto() + "장," + "자동으로 " + person.getHaveRobotLotto() + "개를 구매했습니다.");
        person.LottoNumPrint();
    }

    public void startLottoInput(Lotto lotto) {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        List<String> inputList = Arrays.asList(num.split(","));
        for(String i : inputList){
            lotto.getWinNumber().add(Integer.parseInt(i.trim()));
        }
        System.out.println("보너스 볼을 입력해주세요.");
        lotto.setBonus(scannerInput.inputNumber());
    }

    public void buy(Person person) {
        int haveMoney = scannerInput.inputNumber();
        int buyLottoCount = customException.butMoneyCheck(haveMoney, 1000);
        person.setMoney(haveMoney);
        handBuyLotto(person, buyLottoCount);
    }

    public void handBuyLotto(Person person, int buyLottoCount){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int handLotto = scannerInput.inputNumber();
        person.setHaveHandLotto(handLotto);
        person.setHaveRobotLotto(buyLottoCount - person.getHaveHandLotto());
    }


}
