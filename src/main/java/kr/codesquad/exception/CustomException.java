package kr.codesquad.exception;

import kr.codesquad.domain.Lotto;

public class CustomException{

    public CustomException() {

    }

    public void inputHanLottoCheck(int num) throws Exception{
        if(num > 6) {
            throw new Exception("입력 가능 로또 숫자는 6개까지 입니다.");
        }
    }

    public void numberCheck(String[] split) throws Exception{
        for (String i : split) {
            if(Integer.parseInt(i) < 1|| Integer.parseInt(i) > 45){
                throw new Exception("1부터 45사이의 숫자를 입력해야합니다");
            }
        }
    }

    public int buyMoneyCheck(int num1, int num2) throws Exception {
        if(num1 %  num2 != 0){
            throw new Exception("1000원 단위로 구매가능합니다.");
        }
        return num1 /  num2;
    }

    public void checkTotalCount(int handLotto, int buyLottoCount) throws Exception {
        if(handLotto > buyLottoCount){
            throw new Exception("구입 가능한 로또 수를 초과하였습니다");
        }
    }

    public int duplicateBonnus(Lotto lotto, int num) throws Exception{
        if(lotto.getWinNumber().contains(num)){
            throw new Exception("당첨 숫자 중에 중복되는 수가 있습니다.");
        }
        return num;
    }
}
