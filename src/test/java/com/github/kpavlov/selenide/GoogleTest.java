package com.github.kpavlov.selenide;

import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    @Test
    public void shouldOpenGoogle() {
        System.out.println("GoogleTest.shouldOpenGoogle");
        open("https://google.com/");
        $("title").has(text("Google"));
    }

}
