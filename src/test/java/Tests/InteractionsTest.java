package Tests;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class InteractionsTest extends BaseTest {
    @Test
    public void sortableTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsInteractions();
        clickJS(interactionsPage.sortable);

        interactionsPage.clickDemoTabGrid();
        wait.until(attributeToBe(interactionsPage.demoTabpaneGrid, "aria-hidden", "false"));
        interactionsPage.clickDemoTabList();
        wait.until(attributeToBe(interactionsPage.demoTabpaneList, "aria-hidden", "false"));

        LinkedHashMap<String, String> testData = new LinkedHashMap<>();
        testData.put("One", "Six");
        testData.put("Six", "Two");
        testData.put("Two", "Five");
        testData.put("Five", "Three");
        testData.put("Three", "Four");

        testData.forEach((k, v) -> {
            interactionsPage.dragAndDropListItem(k, v);
        });
        wait.until(textToBePresentInElement(interactionsPage.listGroupItemAction.get(5), "One"));
        wait.until(textToBePresentInElement(interactionsPage.listGroupItemAction.get(4), "Two"));
        wait.until(textToBePresentInElement(interactionsPage.listGroupItemAction.get(3), "Three"));
        wait.until(textToBePresentInElement(interactionsPage.listGroupItemAction.get(2), "Four"));
        wait.until(textToBePresentInElement(interactionsPage.listGroupItemAction.get(1), "Five"));
        wait.until(textToBePresentInElement(interactionsPage.listGroupItemAction.get(0), "Six"));


        interactionsPage.clickDemoTabGrid();

        interactionsPage.dragAndDropGridItem("Nine", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("1"), "Nine"));

        interactionsPage.dragAndDropGridItem("Eight", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("2"), "Eight"));

        interactionsPage.dragAndDropGridItem("Seven", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("3"), "Seven"));

        interactionsPage.dragAndDropGridItem("Six", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("4"), "Six"));

        interactionsPage.dragAndDropGridItem("Five", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("5"), "Five"));

        interactionsPage.dragAndDropGridItem("Four", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("6"), "Four"));

        interactionsPage.dragAndDropGridItem("Three", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("7"), "Three"));

        interactionsPage.dragAndDropGridItem("Two", "One");
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("8"), "Two"));
        wait.until(textToBePresentInElement(interactionsPage.getCreateGridNumberListItem("9"), "One"));
    }

    @Test
    public void selectableTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsInteractions();
        clickJS(interactionsPage.selectable);

        interactionsPage.clickDemoTabGrid();
        wait.until(attributeToBe(interactionsPage.demoTabpaneGrid, "aria-hidden", "false"));
        interactionsPage.clickDemoTabList();
        wait.until(attributeToBe(interactionsPage.demoTabpaneList, "aria-hidden", "false"));

        List<String> clickListItem = Arrays.asList("Cras justo odio", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac");
        clickListItem.forEach(i -> interactionsPage.clickListGroupItem(i));
        clickListItem.forEach(i -> wait.until(attributeToBe(interactionsPage.getListGroupItem(i),
                "class",
                "mt-2 list-group-item active list-group-item-action")));

        interactionsPage.clickDemoTabGrid();
        List<String> clickGridItem = Arrays.asList("One", "Five", "Nine", "Seven", "Three", "Four", "Two", "Eight", "Six");
        clickGridItem.forEach(i -> interactionsPage.clickListGroupItem(i));
        clickGridItem.forEach(i -> wait.until(attributeToBe(interactionsPage.getListGroupItem(i),
                "class",
                "list-group-item active list-group-item-action")));
    }
}
