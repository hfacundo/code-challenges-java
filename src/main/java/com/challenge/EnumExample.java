package com.challenge;

public enum EnumExample implements InterfaceExample{
    HI, TXT
    ;

    @Override
    public void hi() {
        System.out.println("hi");
    }
}
