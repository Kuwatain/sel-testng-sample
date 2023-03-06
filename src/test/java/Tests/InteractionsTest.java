package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class InteractionsTest extends BaseTest {
    @Test
    public void sortableTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsInteractions();
        clickJS(interactionsPage.sortable);

        interactionsPage.clickDemoTabGrid();
        wait.until(ExpectedConditions.attributeToBe(interactionsPage.demoTabpaneGrid, "aria-hidden", "false"));
        interactionsPage.clickDemoTabList();
        wait.until(ExpectedConditions.attributeToBe(interactionsPage.demoTabpaneList, "aria-hidden", "false"));


        actions.dragAndDrop(interactionsPage.getVerticalListItem("One"), interactionsPage.getVerticalListItem("Six")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getVerticalNumberListItem("6"), "One"));

        actions.dragAndDrop(interactionsPage.getVerticalListItem("Six"), interactionsPage.getVerticalListItem("Two")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getVerticalNumberListItem("1"), "Six"));

        actions.dragAndDrop(interactionsPage.getVerticalListItem("Two"), interactionsPage.getVerticalListItem("Five")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getVerticalNumberListItem("5"), "Two"));

        actions.dragAndDrop(interactionsPage.getVerticalListItem("Five"), interactionsPage.getVerticalListItem("Three")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getVerticalNumberListItem("2"), "Five"));

        actions.dragAndDrop(interactionsPage.getVerticalListItem("Three"), interactionsPage.getVerticalListItem("Four")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getVerticalNumberListItem("4"), "Three"));

        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getVerticalNumberListItem("3"), "Four"));


        interactionsPage.clickDemoTabGrid();

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Nine"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("1"), "Nine"));

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Eight"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("2"), "Eight"));

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Seven"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("3"), "Seven"));

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Six"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("4"), "Six"));

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Five"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("5"), "Five"));

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Four"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("6"), "Four"));

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Three"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("7"), "Three"));

        actions.dragAndDrop(interactionsPage.getCreateGridListItem("Two"), interactionsPage.getCreateGridListItem("One")).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("8"), "Two"));

        wait.until(ExpectedConditions.textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("9"), "One"));
    }
}
