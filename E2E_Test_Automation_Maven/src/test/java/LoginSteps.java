import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;

    @Given("o usuário está na página de login")
    public void usuarioNaPaginaDeLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("o usuário insere credenciais válidas e faz login")
    public void usuarioFazLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Then("o usuário deve ver a página de produtos")
    public void usuarioNaPaginaDeProdutos() {
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        driver.quit();
    }
}
