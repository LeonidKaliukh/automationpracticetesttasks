package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
public class CreateAccountPage {

    private final SelenideElement account = $("a[class='account']");
    private final SelenideElement gender = $("div[id='uniform-id_gender1']");
    private final SelenideElement firstName = $("input[id='customer_firstname']");
    private final SelenideElement lastName = $("input[id='customer_lastname']");
    private final SelenideElement password = $("input[id='passwd']");
    private final SelenideElement firstAddress = $("input[id='address1']");
    private final SelenideElement city = $("input[id='city']");
    private final SelenideElement idState = $("select[id='id_state']");
    private final SelenideElement postCode = $("input[id='postcode']");
    private final SelenideElement country = $("select[id='id_country']");
    private final SelenideElement phoneMobile = $("input[id='phone_mobile']");
    private final SelenideElement alias = $("input[id='alias']");
    private final SelenideElement submitButton = $("button[id='submitAccount']");

    private static final String userFirstName = "LeonidQA";

    private static final String userLastName = "Kaliukh";

    public MyAccountPage enterUserData() {
        gender.shouldBe(Condition.appear).click();
        firstName.setValue(userFirstName);
        lastName.setValue(userLastName);
        password.setValue("12345");
        firstAddress.setValue("test First Address");
        city.setValue("New York");
        idState.selectOptionContainingText("Arizona");
        postCode.setValue("11223");
        country.selectOptionContainingText("United States");
        phoneMobile.setValue("380679106888");
        alias.setValue("test Alias");
        submitButton.click();
        account.shouldHave(Condition.text(userFirstName + " " + userLastName));

        return new MyAccountPage();
    }


}
