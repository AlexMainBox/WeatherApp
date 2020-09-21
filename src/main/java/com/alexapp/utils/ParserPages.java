package com.alexapp.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class ParserPages {

    private static Document page;

    public static Document setPage(String city) throws IOException {

        String url = "https://www.euronews.com/weather/europe/ukraine/" + city;
        page = Jsoup.parse(new URL(url), 3000);
        return page;

    }

    public static String infoText() {
        return page.select("p[class=unit_C c-cityWeather__forecast__desc ltr no-unit]").text();
    }

    public static String maxDegrees() {
        return page.select("span.c-swiper-slide--day__temp-max").first().text() + " °C";
    }

    public static String minDegrees() {
        return page.select("span.u-text-size-extra-small").get(1).text() + " °C";
    }

    public static String cityLabel() {
        return page.select("span.c-current-weather__city").text();
    }

    public static String nowDegreesField() {
        return page.select("span[class=c-current-weather__temperature unit_C ltr]").text();
    }
}
