package autoTests;

import autoTests.pages.main.TemplatePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends CustomMethods {
	ConfigurationVariables CV = ConfigurationVariables.getInstance();


	//<editor-fold desc="Тестовый пример заполнение полей">
        @Test(enabled = true, groups = {"Main", "Критический функционал"}, priority = 1)
	public void A1_Test_Example_Fill_Field(WebDriver driver) throws Exception {
		/*****************************************объявляем элементы страниц*******************************************/
		TemplatePage tp = new TemplatePage(driver);
        //  Вносим в переменные название услуги начиная с точки ._test_fields_bankid_--_ и до начала названия поля
        String sn = "._test_fields_bankid_--_";

        addStepToTheReport("1. Вход по прямому URL на услугу");
		openURLservice(driver, CV.baseUrl + "/service/720/general");

		addStepToTheReport("2. Проверить, что открылась нужная услуга");
		assertThis(driver, tp.usluga, "_test_fields_bankid");

		addStepToTheReport("3. Выбор области/города");
		tp.selectRegion("Дніпропетровська");
        tp.selectCity("Дніпро (Дніпропетровськ");

        addStepToTheReport("4. Авторизация Off AuthMock/BankID");
        tp.mokAuthorization();

        addStepToTheReport("5. Заполняем форму услуги");
        fillInField(driver, sn, "tooltiptext", "test");
        fillInField(driver, sn, "email", "v-i-d-k@mail.ru");

        addStepToTheReport("6. Отправка формы");
        click(driver, tp.buttonSendingForm);

        addStepToTheReport("7. Проверка сообщения о успешной отправке");
        tp.checkMessageSuccess("Шановний(-а) MockUser MockUser!\n" +
                "Ваше звернення х-хххххххх успішно зареєстровано\n" +
                "(номер також відправлено Вам електронною поштою на Ваш e-mail v-i-d-k@mail.ru) Результати будуть спрямовані також на email.\n" +
                "Звертаємо увагу, що Іноді листи потрапляють у спам або у розділ \"Реклама\" (для Gmail).");

        addStepToTheReport("8. Нажать кнопку Выйти");
        click(driver, tp.buttonLogOut);
	}
    //</editor-fold>

    //<editor-fold desc="Тестовый пример загрузки файла">
        @Test(enabled = true, groups = {"Main", "Критический функционал"}, priority = 2)
    public void A2_Test_Example_Attach(WebDriver driver) throws Exception {
        /*****************************************объявляем элементы страниц*******************************************/
        TemplatePage tp = new TemplatePage(driver);
        //  Вносим в переменные название услуги начиная с точки ._test_mailer_--_ и до начала названия поля
        String sn = "._test_mailer_--_";

        addStepToTheReport("1. Вход по прямому URL на услугу");
        openURLservice(driver, CV.baseUrl + "/service/755/general");

        addStepToTheReport("2. Проверить, что открылась нужная услуга");
        assertThis(driver, tp.usluga, "_test_mailer");

        addStepToTheReport("3. Авторизация Off AuthMock/BankID");
        tp.mokAuthorization();

        addStepToTheReport("4. Заполняем форму услуги");
        fillInField(driver, sn, "mail", "v-i-d-k@mail.ru");
        attachDocument(tp.attachDocumentButton, "src/test/resources/files/test.jpg", driver);

        addStepToTheReport("5. Отправка формы");
        click(driver, tp.buttonSendingForm);

        addStepToTheReport("6. Проверка сообщения о успешной отправке");
        tp.checkMessageSuccess("Шановний(-а) MockUser MockUser!\n" +
                "Ваше звернення х-хххххххх успішно зареєстровано");

        addStepToTheReport("7. Нажать кнопку Выйти ");
        click(driver, tp.buttonLogOut);

    }
    //</editor-fold>

    //<editor-fold desc="Тестовый пример выпадающее листы">
     @Test(enabled = true, groups = {"Main", "Критический функционал"}, priority = 3)
    public void A3_Test_Example_Select(WebDriver driver) throws Exception {
        /*****************************************объявляем элементы страниц*******************************************/
        TemplatePage tp = new TemplatePage(driver);
        //  Вносим в переменные название услуги начиная с точки ._test_sID_UA_--_ и до начала названия поля
        String sn = "._test_sID_UA_--_";

        addStepToTheReport("1. Вход по прямому URL на услугу");
        openURLservice(driver, CV.baseUrl + "/service/785/general");

        addStepToTheReport("2. Проверить, что открылась нужная услуга");
        assertThis(driver, tp.usluga, "_test_sID_UA");

        addStepToTheReport("3. Выбор области/города");
        tp.selectRegion("Дніпропетровська");
        tp.selectCity("Дніпро (Дніпропетровськ");

        addStepToTheReport("3. Авторизация Off AuthMock/BankID");
        tp.mokAuthorization();

        addStepToTheReport("4. Заполняем форму услуги");
        fillInField(driver, sn, "sID_Place_UA", "test");
        fillInField(driver, sn, "sID_UA", "test");
        fillInField(driver, sn, "email", "v-i-d-k@mail.ru");
        selectByVisibleText(driver,sn,"client","нет");

        addStepToTheReport("5. Отправка формы");
        click(driver, tp.buttonSendingForm);

        addStepToTheReport("6. Проверка сообщения о успешной отправке");
        tp.checkMessageSuccess("Шановний(-а) MockUser MockUser!\n" +
                "Ваше звернення х-хххххххх успішно зареєстровано\n" +
                "(номер також відправлено Вам електронною поштою на Ваш e-mail v-i-d-k@mail.ru) Результати будуть спрямовані також на email.\n" +
                "Звертаємо увагу, що Іноді листи потрапляють у спам або у розділ \"Реклама\" (для Gmail).");

        addStepToTheReport("7. Нажать кнопку Выйти ");
        click(driver, tp.buttonLogOut);
    }
    //</editor-fold>

  }