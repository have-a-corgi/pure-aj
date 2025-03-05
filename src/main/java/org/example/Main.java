package org.example;

import org.example.pojo.DummyPojo;
import org.example.pojo.SmartPojo;

public class Main {
    public static void main(String[] args) {
        new DummyPojo().dummyMethod();
        new SmartPojo().smartMethod();
    }
}