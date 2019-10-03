package com.sda;

import com.sda.clientCustomer.A;
import com.sda.clientCustomer.B;

public class Testowa implements A, B {

    public void doSth() {
        wypisz();
    }

    public static void main(String[] args) {
        new Testowa().doSth();
    }


    @Override
    public void wypisz() {

    }
}
