package com.telran.tests.bookStore;

import com.telran.data.UserData;
import com.telran.pages.HomePage;
import com.telran.pages.bookStore.LoginPage;
import com.telran.pages.bookStore.ProfilePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).clickStore();
        new SidePanelPage(driver).loginButtonSidePanel();
    }


    @Test(enabled = false)
    public void loginPositiveTest(){
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD);
        new ProfilePage(driver).verifyUserName("Tom").logout();
    }

    @Test
    @Parameters({"name","password"})
    public void loginPositiveParametersTestNgTest(String name, String password){
        new LoginPage(driver).login(name,password);
        new ProfilePage(driver).verifyUserName("Tom").logout();
    }

}
