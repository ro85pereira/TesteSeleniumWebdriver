import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Primeiro Teste Automatizados em site")

public class TestePaginaLogin {
    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")

    public void testRegistrarUmNovoUsuarioComDadosValidos(){

        //Baixar e configurar a versão correta do driver
        WebDriverManager.chromedriver().setup();

        //Abrir o Chrome
        WebDriver driver = new ChromeDriver();

        // Abrir o site para o teste
        driver.get("https://www.automationexercise.com/");

        // Clicar na opção sigup/login utilizando XPATH
        WebElement optionLogin = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        optionLogin.click();

        // Teste para confirmar que a tela de login foi aberta com assertions Junit
        // Procurando se há um h2 na tela de sigup
        WebElement loginPage = driver.findElement(By.tagName("h2"));
        // Atribuindo o texto em uma variável
        String textTelaLogin = loginPage.getText();

        // Comparando se o texto da váriável é igual o da página
        Assertions.assertEquals("Login to your account", textTelaLogin);

        // Digitar email no campo email para realizar login
        WebElement emailAdressElement = driver.findElement(By.name("email"));
        emailAdressElement.sendKeys("ro85pereira@hotmail.com");

        // Digitar a senha no campo senha para realizar o login
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("SalazarVasco");

        // Clicar no botão Login
        WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        submitBtnElement.click();

    }

}
