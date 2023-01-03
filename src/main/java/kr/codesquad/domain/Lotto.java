package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    List<List<Integer>> number = new ArrayList<>();
    List<Integer> collectNum = new ArrayList<>();
    double total;

    public Lotto(){
        collectNum.add(0);
        collectNum.add(0);
        collectNum.add(0);
        collectNum.add(0);
        total = 0;
    }

    public Integer getCollectNum(int i) {
        return collectNum.get(i);
    }

    public void setCollectNum(int idx, int num) {
        collectNum.add(idx, num);
    }

    public Integer collectNumSize() {
        return collectNum.size();
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
        for (int i = 0; i < collectNum.size(); i++) {
            plusTotal(i);
        }
    }

    public void plusTotal(int i) {
        if(i == 0) total += (collectNum.get(i) * 5000);
        if(i == 1) total += (collectNum.get(i) * 50000);
        if(i == 2) total += (collectNum.get(i) * 1500000);
        if(i == 3) total += (collectNum.get(i) * 2000000000);
    }

    public void print(int originMoney) { // 당첨 로또 개수 출력
        System.out.println("당첨 통계\n---------");
        for (int i = 0; i < 4; i++) {
            printCount(i);
        }
        setPlusTotal();
        String result = round(originMoney);
        System.out.println( "총 수익률은 " + result + "%입니다.");
    }

    public void printCount(int i) {
        if(i == 0) System.out.println("3개 일치 (5000원) - " + collectNum.get(i) + "개");
        if(i == 1) System.out.println("4개 일치 (50000원) - " + collectNum.get(i) + "개");
        if(i == 2) System.out.println("5개 일치 (1500000원) - " + collectNum.get(i) + "개");
        if(i == 3) System.out.println("6개 일치 (2000000000원) - " + collectNum.get(i) + "개");
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
