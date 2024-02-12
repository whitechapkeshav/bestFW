/*
 * Copyright (c) 2024 IdeyaLabs
 * Automation Framework Selenium
 */

package com.ideyalabs.dataprovider;

import com.ideyalabs.constants.FrameworkConstants;
import com.ideyalabs.helpers.ExcelHelpers;
import com.ideyalabs.helpers.Helpers;
import com.ideyalabs.helpers.PropertiesHelpers;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Hashtable;

public final class DataProviderManager {

    private DataProviderManager() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @DataProvider(name = "testAdminLogin", parallel = false)
    public static Object[][] testAdminLogin() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        return excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login", 1, 1);

    }

    @DataProvider(name = "testForgotPassword", parallel = false)
    public static Object[][] testForgotPassword() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        return excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "ForgotPassword", 1, 1);
    }

    @DataProvider(name = "testLoginInvalidCredentials", parallel = false)
    public static Object[][] testLoginInvalidCredentials() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        return excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login", 2, 5);
    }

//    @DataProvider(name = "testAdminLogin", parallel = false)
//    public static Object[][] testAdminLogin(@NotNull Method m) {
//        String sheetName = m.getName().split("_")[0];
//        String colName = m.getName().split("_")[1];
//        return ExcelHelpers.provideExcelData(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, sheetName, colName);
//    }

}
