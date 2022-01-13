package com.spartaglobal.nc.webdriver;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.LocalDate;
import java.util.List;

public class HackerNewsLinkTest {
    private static WebDriver webDriver;
    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless"); // prevents window from popping up
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://news.ycombinator.com/");
    }

    @AfterEach
    public void tearDown() {
        webDriver.close();
    }

    @AfterAll
    public static void tearDownAll() {
        webDriver.quit();
    }

    @Test
    @DisplayName("Checking that the web driver works")
    public void checkWebDriver() {
        Assertions.assertEquals("https://news.ycombinator.com/", webDriver.getCurrentUrl());
    }

    @Nested
    @DisplayName("Checking top navigation bar links")
    class checkingTopNavBar {

        @Test
        @DisplayName("Check that the link to the past page works")
        public void checkPastLink() {
            WebElement pastLink = webDriver.findElement(By.linkText("past"));
            pastLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/front", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the new page works")
        public void checkNewLink() {
            WebElement newLink = webDriver.findElement(By.linkText("new"));
            newLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/newest", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the comments page works")
        public void checkCommentsLink() {
            WebElement commentsLink = webDriver.findElement(By.linkText("comments"));
            commentsLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/newcomments", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the new page works")
        public void checkAskLink() {
            WebElement askLink = webDriver.findElement(By.linkText("ask"));
            askLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/ask", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the new page works")
        public void checkShowLink() {
            WebElement showLink = webDriver.findElement(By.linkText("show"));
            showLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/show", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the new page works")
        public void checkJobsLink() {
            WebElement jobsLink = webDriver.findElement(By.linkText("jobs"));
            jobsLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/jobs", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the new page works")
        public void checkSubmitLink() {
            WebElement submitLink = webDriver.findElement(By.linkText("submit"));
            submitLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/submit", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the Y page works")
        public void checkYLink() {
            WebElement yLink = webDriver.findElement(By.cssSelector("img"));
            yLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/", webDriver.getCurrentUrl());
        }
    }

    @Nested
    @DisplayName("Checking bottom navigation bar links")
    class checkingBottomNavBar {
        @Test
        @DisplayName("Check that the link to the guidelines page works")
        public void checkGuidelinesLink() {
            WebElement guidelinesLink = webDriver.findElement(By.linkText("Guidelines"));
            guidelinesLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/newsguidelines.html", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the FAQ page works")
        public void checkFAQLink() {
            WebElement faqLink = webDriver.findElement(By.linkText("FAQ"));
            faqLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/newsfaq.html", webDriver.getCurrentUrl());
        }

        // not working at present
        @Test
        @DisplayName("Check that the link to the Lists page works")
        public void checkListLink() {
            WebElement listLink = webDriver.findElement(By.linkText("Lists"));
            listLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/lists", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the API page works")
        public void checkAPILink() {
            WebElement apiLink = webDriver.findElement(By.linkText("API"));
            apiLink.click();
            Assertions.assertEquals("https://github.com/HackerNews/API", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the Security page works")
        public void checkSecurityLink() {
            WebElement securityLink = webDriver.findElement(By.linkText("Security"));
            securityLink.click();
            Assertions.assertEquals("https://news.ycombinator.com/security.html", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the Legal page works")
        public void checkLegaLink() {
            WebElement legalLink = webDriver.findElement(By.linkText("Legal"));
            legalLink.click();
            Assertions.assertEquals("https://www.ycombinator.com/legal/", webDriver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the link to the Apply to YC link works")
        public void checkApplyToYCLink() {
            WebElement applyLink = webDriver.findElement(By.linkText("Apply to YC"));
            applyLink.click();
            Assertions.assertEquals("https://www.ycombinator.com/apply/", webDriver.getCurrentUrl());
        }

        // not working at present
        @Test
        @DisplayName("Check that the Contact link works")
        public void checkContactLink() {
            WebElement contactLink = webDriver.findElement(By.linkText("Contact"));
            contactLink.click();
            Assertions.assertEquals("https://outlook.office.com/mail/deeplink/compose?mailtouri=mailto%3Ahn%40ycombinator.com", webDriver.getCurrentUrl());
        }
    }

    @Test
    @DisplayName("Check that the search bar works")
    public void checkSearchBar() {
        var element = webDriver.findElement(By.name("q"));
        element.sendKeys("Java", Keys.ENTER);
        Assertions.assertEquals("https://hn.algolia.com/?q=Java", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check navigation works")
    public void checkNavigation() {
        webDriver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        webDriver.navigate().back();
        Assertions.assertEquals("https://news.ycombinator.com/", webDriver.getCurrentUrl());
        webDriver.navigate().forward();
        Assertions.assertEquals("https://hn.algolia.com/?q=Java", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check date on past page")
    void pastDateTest() {
        WebElement pastLink = webDriver.findElement(By.linkText("past"));
        pastLink.click();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String topString = webDriver.findElement(By.className("pagetop")).getText();
        System.out.println(topString);
        MatcherAssert.assertThat(topString, containsString(yesterday.toString()));
    }

    @Test
    void printTableDataElements() {
        List<WebElement> elements = webDriver.findElements((By.cssSelector("td")));
        for (WebElement row : elements) {
            System.out.println(row.getText());
        }
        Assertions.assertEquals(159, elements.size());
    }

    @Test
    void relativeElementTest() {
        webDriver.get("https://news.ycombinator.com/login?goto=news");
        WebElement userNameBox = webDriver.findElement(By.name("acct"));
        WebElement passwordInput = webDriver.findElement(
                RelativeLocator.with(By.tagName("input")).below(userNameBox));
        System.out.println(passwordInput.toString());
    }

}
