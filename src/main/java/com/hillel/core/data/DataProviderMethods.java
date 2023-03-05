package com.hillel.core.data;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
    @DataProvider(name = "provideStringsForCommonNews")
    private static Object[][] provideStringsForCommonNews() {
        return new Object[][]{
                {"gamedev", 5},
                {"frontend", 9},
                {"qa", 9}
        };
}
}

