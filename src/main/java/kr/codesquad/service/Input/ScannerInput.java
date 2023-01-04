package kr.codesquad.service.Input;

import java.util.Scanner;

public class ScannerInput {
    Scanner sc = new Scanner(System.in);
    public int inputNumber() {
        return sc.nextInt();
    }
    public String inputLine() {
        return sc.nextLine();
    }
}
