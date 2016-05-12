package com.github.kpavlov.selenide;

import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test
    public void shouldOpenYandex() {
        System.out.println("GoogleTest.shouldOpenYandex");
        open("https://yandex.com/");
        $("title").has(text("Yandex"));
    }

}
