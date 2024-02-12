package com.ideyalabs.projects.coyni;

import com.ideyalabs.helpers.PropertiesHelpers;
import org.openqa.selenium.By;

public class ConstantsLocators {

    static {
        PropertiesHelpers.loadAllFiles();
    }

    public ConstantsLocators() {
    }

    //Dynamic Elements
    public static final By dynamic_id = By.id("%s");
    public static final By dynamic_name = By.name("%s");
    public static final By dynamic_class = By.className("%s");
    public static final By dynamic_xpath_span_text = By.xpath("//span[contains(text(),'%s')]");
    public static final By dynamic_xpath_button_type = By.xpath("//button[@type='%s']");
    public static final By dynamic_xpath_div_text = By.xpath("//div[contains(text(),'%s')]");
    public static final By dynamic_xpath_button_text = By.xpath("//button[contains(text(),'%s')]");
    public static final By dynamic_xpath_p_text = By.xpath("//p[contains(text(),'%s')]");
    public static final By dynamic_xpath_h1_text = By.xpath("//h1[contains(text(),'%s')]");
    public static final By dynamic_xpath_div_text_parent_span = By.xpath("//div[contains(text(),'%s')]/..//span");


    //    Elements
    public static final By lblfiveTimeResnd = By.xpath("//span[text()='Looks like something went wrong. Please try again later.']");

    public static final By coyniAdminLblHeading = By.xpath("//span[text()='Log In to coyni Admin']");
    public static final By lblDescription = By.cssSelector(".verify-identity__sub-title");
    public static final By lblHeading = By.cssSelector(".verify-identity__title");
    public static final By eyeIcon = By.xpath("//button[(@data-for='button')]");
    public static final By btnNext = By.cssSelector(".business-login__login-button");
    public static final By lnkForgotEmail = By.xpath("//button[.='Forgot Email?']");
    public static final By lnkForgotPassword = By.xpath("//button[.='Forgot Password?']");
    public static final By lnkSignUp = By.xpath("//button[text()='Sign Up']");
    public static final By btnSms = By.xpath("//div[contains(@class,'text-x')]");
    public static final By btnResendVerification = By.xpath("//button[contains(@class,'text-cm3 hover:underline mt')]");
    public static final By btnNewVerification = By.xpath("//div[contains(@class,'text-cgn')]");

//public static Constant methdos
    //    Forgot Password


    public static final By lblForgotHeading = By.xpath("//span[text()='Forgot Password?']");
    public static final By lblForgotDescrip = By.xpath("//span[@class='forgot-password__sub-title']");
    public static final By forgotNext = By.xpath("//button[text()='Next']");
    public static final By lblEmailVerifiHeading = By.xpath("//div[text()='Email Verification']");
    public static final By inputBox = By.cssSelector("input[class *= 'verification-input']");
    public static final By lblCreatePwdHeading = By.cssSelector(".update-password-password__title");
    public static final By lblCreatePwdDescription = By.cssSelector(".update-password-password__sub-title");
    public static final By txtCreatePassword = By.id("Enter_Password");

    public static final By btnSubmit = By.xpath("//button[@type='submit']");
    public static final By lblSucessHeading = By.cssSelector(".title");
    public static final By lblSucessDescription = By.cssSelector(".subtitle");
    public static final By btnLogin = By.xpath("//button[text()='Log In']");
    public static final By forgotEmailField = By.id("Email-id");
    public static final By errorMsgs = By
            .cssSelector("div[class *= 'FormField_error'],span[class *='verification_error'],p.text-crd5.font-semibold");
}
