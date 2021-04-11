package techskills.qa.hrs.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import techskills.qa.hrs.base.BaseTest;
import techskills.qa.hrs.utils.Constants;

public class LoginPageTest extends BaseTest {

	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void verifyforgotpwdlinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	
	@Test(priority=3)
	public void verifyRecoverysollinkTest() {
		Assert.assertTrue(loginPage.isRecoverySolutionLinkExist());
	}
	
	@Test(priority=4)
	public void verifyShowhidelinkTest() {
		Assert.assertTrue(loginPage.isShowHideSectionExist());
	}
	
	@Test(priority=5)
	public void verifySigninbuttonTest() {
		Assert.assertTrue(loginPage.isSignInButtonExist());
	}
	
	@Test(priority=6)
	public void verifyHrLogoTest() {
		Assert.assertTrue(loginPage.isHRSLogoExists());
	}
	

	@Test(priority=7)
	public void verifyForgotPasswordTest() {
		String message = loginPage.doForgotPassword();
		Assert.assertEquals(message, Constants.SUCCESS_MESSAGE);
	}
	
	@Test(priority=8)
	public void verifyRecoveryLinkTest() {
		String childtitle = loginPage.doRecoverySolutionlinkBehavior();
		Assert.assertEquals(childtitle, Constants.CHILD_WINDOW_TITLE);
		
	}
}
