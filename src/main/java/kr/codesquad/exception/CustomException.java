package kr.codesquad.exception;

public class CustomException {

    public int butMoneyCheck(int num1, int num2) {
        int result = 0;
        try {
            result = num1 / num2;
            buyException(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void buyException(int num) throws Exception {
        if(num % 1000 != 0){
            throw new Exception("1000원 단위로 구매가능합니다.");
        }
    }

}
