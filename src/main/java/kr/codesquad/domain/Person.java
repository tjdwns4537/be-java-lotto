package kr.codesquad.domain;

import kr.codesquad.utilities.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class Person {
    List<List<Integer>> number = new ArrayList<>();
    List<Integer> winNumber = new ArrayList<>();
    int money;
    int haveLotto;
    double total;

    public Person(){
        winNumber.add(0);
        winNumber.add(0);
        winNumber.add(0);
        winNumber.add(0);
        winNumber.add(0);
        total = 0;
    }

    public int getHaveLotto(){
        return this.haveLotto;
    }

    public void setHaveLotto(int cnt) {
        this.haveLotto = cnt;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Integer getWinNumber(int i) {
        return winNumber.get(i);
    }

    public void setWinNumber(int idx, int num) {
        winNumber.remove(idx);
        winNumber.add(idx, num);
    }

    public Integer collectNumSize() {
        return winNumber.size();
    }

    public void addLotto(List<Integer> inputNumber) {
        number.add(inputNumber);
    }

    public Integer getSize() {
        return number.size();
    }

    public List<Integer> getLotto(int i) {
        return number.get(i);
    }

    public void setPlusTotal() {
        for (int i = 0; i < winNumber.size(); i++) {
            plusTotal(i);
        }
    }

    public void plusTotal(int i) {
        if(i == 0) total += (winNumber.get(i) * Integer.parseInt(LottoRank.valueOf("FIVE").getRank()));
        if(i == 1) total += (winNumber.get(i) * Integer.parseInt(LottoRank.valueOf("FOURTH").getRank()));
        if(i == 2) total += (winNumber.get(i) * Integer.parseInt(LottoRank.valueOf("THIRD").getRank()));
        if(i == 3) total += (winNumber.get(i) * Integer.parseInt(LottoRank.valueOf("SECOND").getRank()));
        if(i == 4) total += (winNumber.get(i) * Integer.parseInt(LottoRank.valueOf("FIRST").getRank()));
    }

    public void print() { // 당첨 로또 개수 출력
        System.out.println("당첨 통계\n---------");
        for (int i = 0; i < 5; i++) {
            printCount(i);
        }
        setPlusTotal();
        String result = round(money);
        System.out.println( "총 수익률은 " + result + "%입니다.");
    }

    public void printCount(int i) {
        if(i == 0) System.out.println("3개 일치 (5000원) - " + winNumber.get(i) + "개");
        if(i == 1) System.out.println("4개 일치 (50000원) - " + winNumber.get(i) + "개");
        if(i == 2) System.out.println("5개 일치 (1500000원) - " + winNumber.get(i) + "개");
        if(i == 3) System.out.println("5개 일치 (30000000원), 보너스 볼 일치 - " + winNumber.get(i) + "개");
        if(i == 4) System.out.println("6개 일치 (2000000000원) - " + winNumber.get(i) + "개");
    }

    public String round(int originMoney) {
        double originM = originMoney;
        if (total < originM){
            String temp = String.format("%.3f",((originM - total) / originM) * 100);
            temp = ("-" + temp.substring(0,temp.length()-1));
            return temp;
        }
        String percent = String.format(("%.3f"), (total - originM) / originM * 100);
        return percent.substring(0,percent.length()-1);
    }

    public void LottoNumPrint() {
        for(int i=0; i<number.size(); i++) System.out.println(number.get(i));
    }
}
