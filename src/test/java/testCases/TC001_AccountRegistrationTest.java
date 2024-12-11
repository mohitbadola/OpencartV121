package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_account_registration(){

        logger.info("***** Starting TC001_AccountRegistrationTest *****");

        try {


            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("clicked on MyAccount Link...");

            hp.clickRegister();
            logger.info("clicked on Register Link...");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);


            logger.info("Providing customer details...");
            regpage.setTxtFirstname(randomeString().toUpperCase());
            regpage.setLastName(randomeString().toUpperCase());
            regpage.setEmail(randomeString() + "@gmail.com");    //randomly generated email

            String password = randomAlphaNumeric();
            regpage.setPassword(password);

            regpage.setPrivacyPolicy();
            regpage.clickSubmit();

            logger.info("Validating expected message...");
            String confmsg = regpage.getConfirmationMsg();

            if(confmsg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test failed...");
                logger.debug("Debug logs...");
                Assert.fail();
            }

        }catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** Finished TC001_AccountRegistrationTest *****");
    }



}
