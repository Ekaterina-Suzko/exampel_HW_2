import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    @Test
    void successfulLoginTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;

        open("https://niffler.qa.guru");
        $("[name=username]").setValue("ekaterina.suzko@tccenter.ru");
        $("[name=password]").setValue("M3dKAtr8!1").pressEnter();
        $("[id=stat]").shouldHave(text("Statistics"));
    }

    @Test
    void badCredentialsLoginTest() {
        Configuration.holdBrowserOpen = true;

        open("https://niffler.qa.guru");
        $("[name=username]").setValue("ekaterina.suzko@tccenter.ru");
        $("[name=password]").setValue("123").pressEnter();
        $("[class=form__error]").shouldHave(text("Неверные учетные данные пользователя"));
    }
}