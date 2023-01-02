package kr.codesquad.service;

import java.util.Scanner;

public class ScannerInput {
    Scanner sc = new Scanner(System.in);

    public int moneyInput() {
        int haveMoney = sc.nextInt();
        return haveMoney;
    }

    public int winNumberInput() {
        int winNumber = sc.nextInt();
        return winNumber;
    }
}
