package com.ideyalabs.dataprovider;

import com.ideyalabs.constants.FrameworkConstants;
import com.ideyalabs.helpers.ExcelHelpers;
import com.ideyalabs.helpers.Helpers;
import org.testng.annotations.DataProvider;

public class DataProviderAddProduct {
    @DataProvider(name = "data_provider_add_product")
    public Object[][] dataAddProduct() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_CMS_DATA, "AddProduct", 2, 2);
        return data;
    }
}
