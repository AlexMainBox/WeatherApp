package com.alexapp.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class ParserPages {

    private static Document page;

    //Take URL and add input city
    public static void setPage(String city) throws IOException {
        String url = "https://www.euronews.com/weather/europe/ukraine/" + city;
        page = Jsoup.parse(new URL(url), 3000);
    }

    // textInfo field on user page
    public static String infoText() {
        return page.select("p[class=unit_C c-cityWeather__forecast__desc ltr no-unit]").text();
    }

    // max degrees field on user page
    public static String maxDegrees() {
        return page.select("span.c-swiper-slide--day__temp-max").first().text() + " °C";
    }

    // min degrees field on user page
    public static String minDegrees() {
        return page.select("span.u-text-size-extra-small").get(1).text() + " °C";
    }

    //return city label text
    public static String cityLabel() {
        return page.select("span.c-current-weather__city").text();
    }

    // now degrees field
    public static String nowDegreesField() {
        return page.select("span[class=c-current-weather__temperature unit_C ltr]").text();
    }
}
