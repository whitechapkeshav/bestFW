package com.ideyalabs.projects.coyni.testCases;

import com.ideyalabs.annotations.FrameworkAnnotation;
import com.ideyalabs.common.BaseTest;
import com.ideyalabs.constants.FrameworkConstants;
import com.ideyalabs.dataprovider.DataProviderManager;
import com.ideyalabs.enums.AuthorType;
import com.ideyalabs.enums.CategoryType;
import com.ideyalabs.keywords.WebUI;
import com.ideyalabs.projects.coyni.ConstantsLocators;
import com.ideyalabs.projects.coyni.ConstantsMethdos;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.util.Hashtable;
import java.util.List;

public class LoginTest extends BaseTest {


    @Step("AdminLgin")
    @FrameworkAnnotation(author = {AuthorType.Keshav, AuthorType.Keshav}, category = {CategoryType.REGRESSION})
    @Test(priority = 1, description = "AdminLgin", dataProvider = "testAdminLogin", dataProviderClass = DataProviderManager.class)
    public void Admin_testAdminLogin(Hashtable<String, String> data) throws MessagingException {
        ConstantsMethdos.Login(FrameworkConstants.Coyni_Admin_URL, data);
    }

    @Step("testForgotPassword")
    @FrameworkAnnotation(author = {AuthorType.Keshav, AuthorType.Keshav}, category = {CategoryType.REGRESSION})
    @Test(description = "testForgotPassword", dataProvider = "testForgotPassword", dataProviderClass = DataProviderManager.class)
    public void testForgotPassword(Hashtable<String, String> data) {
        ConstantsMethdos.OpenurlAndVerify(FrameworkConstants.Coyni_Admin_URL, data);
        WebUI.clickElement(ConstantsLocators.lnkForgotPassword, 10);
        WebUI.verifyElementTextEquals(ConstantsLocators.lblForgotHeading, data.get("forgotHeading"));
        WebUI.verifyElementTextEquals(ConstantsLocators.lblForgotDescrip, data.get("forgotDescription"));
        WebUI.setText(ConstantsLocators.forgotEmailField, data.get("email"));
        WebUI.clickElement(ConstantsLocators.forgotNext, 10);
        WebUI.verifyElementTextEquals(ConstantsLocators.lblEmailVerifiHeading, data.get("emailHeading"));
        List<WebElement> inputs = WebUI.getWebElements(ConstantsLocators.inputBox);
        int noOfInputs = inputs.size();
        if (noOfInputs == 6) {
            for (int i = 0; i < noOfInputs; i++) {
                inputs.get(i).sendKeys(data.get("code").charAt(i) + "");
            }
        }

        WebUI.verifyElementTextEquals(ConstantsLocators.lblCreatePwdHeading, data.get("createPasswordHeading"));
        WebUI.verifyElementTextEquals(ConstantsLocators.lblCreatePwdDescription, data.get("createPasswordDescription"));
        WebUI.setText(ConstantsLocators.txtCreatePassword, data.get("createPassword"));
        WebUI.setText(WebUI.getNewLocator(ConstantsLocators.dynamic_id, "confirm_Password"), data.get("confirmPassword"));
        WebUI.clickElement(ConstantsLocators.btnSubmit, 10);
        WebUI.verifyElementTextEquals(ConstantsLocators.lblSucessHeading, data.get("successHeading"));
        WebUI.verifyElementTextEquals(ConstantsLocators.lblSucessDescription, data.get("successDescription"));
        WebUI.clickElement(ConstantsLocators.btnLogin, 10);
        WebUI.verifyElementTextEquals(ConstantsLocators.coyniAdminLblHeading, data.get("loginHeading"));
    }

    @Step("LoginInvalidData")
    @FrameworkAnnotation(author = {AuthorType.Keshav, AuthorType.Keshav}, category = {CategoryType.REGRESSION})
    @Test(description = "LoginInvalidData", dataProvider = "testLoginInvalidCredentials", dataProviderClass = DataProviderManager.class)
    public void testLoginInvalidCredentials(Hashtable<String, String> data) {
        WebUI.openWebsite(FrameworkConstants.Coyni_Admin_URL);
        WebUI.verifyElementTextEquals(ConstantsLocators.coyniAdminLblHeading, data.get("loginHeading"));
        WebUI.setText(WebUI.getNewLocator(ConstantsLocators.dynamic_id, "Email"), data.get("email"));
        WebUI.setText(WebUI.getNewLocator(ConstantsLocators.dynamic_id, "Password"), data.get("password"));
        WebUI.clickElement(ConstantsLocators.btnNext, 10);
        WebUI.verifyElementTextEquals(ConstantsLocators.errorMsgs, data.get("errMessage"));

    }
}
