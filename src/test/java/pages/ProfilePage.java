package pages;

import com.codeborne.selenide.SelenideElement;
import data.DataTest;
import io.qameta.allure.Step;
import models.AuthorizationBodyModel;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

    SelenideElement emptyList = $(".rt-noData"),
            userName = $("#userName-value"),
            tableItem = $(".rt-tbody"),
            deleteButton = $("#delete-record-undefined"),
            okButton = $("#closeSmallModal-ok");


    @Step("открытие профиля")
    public ProfilePage openPageUI() {
        open("profile");
        return this;
    }

    @Step("проверка отображения User Name в UI")
    public ProfilePage checkUserNameUI() {
        AuthorizationBodyModel authData = new AuthorizationBodyModel();
        DataTest acc = new DataTest();
        authData.setUserName(acc.getUserName());
        authData.setPassword(acc.getPassword());

        userName.shouldBe(text(acc.getUserName()));
        return this;
    }

    @Step("проверка на удаление книг")
    public ProfilePage checkProfileIsEmptyUI() {
        emptyList.shouldHave(text("No rows found"));
        return this;
    }

    @Step("проверка наличия книг в UI")
    public void checkAddedBookUI() {
        tableItem.shouldNotBe(empty);
    }

    @Step("Удаление книги из списка")
    public ProfilePage deleteBookUI() {
        deleteButton.click();
        okButton.click();
        return this;
    }

}
