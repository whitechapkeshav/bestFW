package com.ideyalabs.projects.coyni;

import com.ideyalabs.helpers.PropertiesHelpers;
import com.ideyalabs.keywords.WebUI;

import java.util.Hashtable;

public class ConstantsMethdos {

    static {
        PropertiesHelpers.loadAllFiles();
    }

    public static void Login(String url, Hashtable<String, String> data) {
        OpenurlAndVerify(url, data);
        WebUI.setText(WebUI.getNewLocator(ConstantsLocators.dynamic_id, "Email"), data.get("email"));
        WebUI.setText(WebUI.getNewLocator(ConstantsLocators.dynamic_id, "Password"), data.get("password"));
        WebUI.clickElement(ConstantsLocators.btnNext, 10);
        WebUI.verifyElementTextEquals(ConstantsLocators.lblHeading, data.get("authyHeading"));
        WebUI.verifyElementTextEquals(ConstantsLocators.lblDescription, data.get("authyDescription"));
    }

    public static void OpenurlAndVerify(String url, Hashtable<String, String> data) {
        WebUI.openWebsite(url);
        WebUI.verifyElementTextEquals(ConstantsLocators.coyniAdminLblHeading, data.get("loginHeading"));
    }
}
