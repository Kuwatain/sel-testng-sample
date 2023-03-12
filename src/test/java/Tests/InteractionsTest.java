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

    @Test
    public void resizableTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsInteractions();
        clickJS(interactionsPage.resizable);

        actions.clickAndHold(interactionsPage.reactResizableHandle).moveByOffset(-50, -50).click().build().perform();
        wait.until(attributeToBe(interactionsPage.resizableBoxWithRestriction, "style", "width: 150px; height: 150px;"));

        actions.clickAndHold(interactionsPage.reactResizableHandle).moveByOffset(350, 150).click().build().perform();
        wait.until(attributeToBe(interactionsPage.resizableBoxWithRestriction, "style", "width: 500px; height: 300px;"));

        actions.clickAndHold(interactionsPage.reactResizableHandle2).moveByOffset(-180, -180).click().build().perform();
        wait.until(attributeToBe(interactionsPage.resizableBox, "style", "width: 20px; height: 20px;"));

        actions.clickAndHold(interactionsPage.reactResizableHandle2).moveByOffset(980, 280).click().build().perform();
        wait.until(attributeToBe(interactionsPage.resizableBox, "style", "width: 1000px; height: 300px;"));
    }

    @Test
    public void droppableTest() {

        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsInteractions();
        clickJS(interactionsPage.droppable);

        interactionsPage.clickTabRevertable();
        wait.until(attributeToBe(interactionsPage.revertable, "aria-selected", "true"));
        interactionsPage.clickTabPreventPropogation();
        wait.until(attributeToBe(interactionsPage.preventPropogation, "aria-selected", "true"));
        interactionsPage.clickTabAccept();
        wait.until(attributeToBe(interactionsPage.accept, "aria-selected", "true"));
        interactionsPage.clickTabSimple();
        wait.until(attributeToBe(interactionsPage.simple, "aria-selected", "true"));

        interactionsPage.dragAndDropSimple();
        wait.until(textToBePresentInElement(interactionsPage.droppableSimple, "Dropped!"));

        interactionsPage.clickTabAccept();
        interactionsPage.dragAndDropNotAccept();
        wait.until(textToBePresentInElement(interactionsPage.droppableAccept, "Drop here"));
        interactionsPage.dragAndDropAccept();
        wait.until(textToBePresentInElement(interactionsPage.droppableAccept, "Dropped!"));

        interactionsPage.clickTabPreventPropogation();
        interactionsPage.dragAndDropNotGreedy();
        wait.until(textToBePresentInElement(interactionsPage.notGreedyDropBox, "Dropped!"));
        wait.until(textToBePresentInElement(interactionsPage.notGreedyInnerDropBox, "Dropped!"));
        interactionsPage.dragAndDropGreedy();
        wait.until(textToBePresentInElement(interactionsPage.greedyDropBox, "Outer droppable"));
        wait.until(textToBePresentInElement(interactionsPage.greedyDropBoxInner, "Dropped!"));

        interactionsPage.clickTabRevertable();
        interactionsPage.dragAndDropRevertable();
        wait.until(textToBePresentInElement(interactionsPage.droppableRevertable, "Dropped!"));
        wait.until(attributeToBe(interactionsPage.revertableBox, "style", "position: relative; left: 0px; top: 0px;"));
        interactionsPage.dragAndDropNotRevertable();
        wait.until(attributeToBe(interactionsPage.notRevertable, "style", "position: relative; left: 353px; top: -17px;"));
    }

    @Test
    public void dragabbleTest() {
        driver.get("https://demoqa.com/");

        landingPage.clickCategoryCardsInteractions();
        clickJS(interactionsPage.dragabble);

        wait.until(attributeToBe(interactionsPage.simple, "aria-selected", "true"));
        actions.dragAndDropBy(interactionsPage.dragBox, 100, 100).build().perform();
        wait.until(attributeToBe(interactionsPage.dragBox, "style", "position: relative; left: 100px; top: 100px;"));

        interactionsPage.clickTabAxisRestriction();
        wait.until(attributeToBe(interactionsPage.axisRestriction, "aria-selected", "true"));
        actions.dragAndDropBy(interactionsPage.restrictedX, 100, 100).build().perform();
        wait.until(attributeToBe(interactionsPage.restrictedX, "style", "position: relative; left: 100px; top: 0px;"));
        actions.dragAndDropBy(interactionsPage.restrictedY, 100, 100).build().perform();
        wait.until(attributeToBe(interactionsPage.restrictedY, "style", "position: relative; left: 0px; top: 100px;"));

        interactionsPage.clickTabContainerRestriction();
        wait.until(attributeToBe(interactionsPage.containerRestriction, "aria-selected", "true"));
        actions.dragAndDropBy(interactionsPage.withinTheBox, 673, 106).build().perform();
        wait.until(attributeToBe(interactionsPage.withinTheBox, "style", "position: relative; left: 673px; top: 106px;"));
        actions.dragAndDropBy(interactionsPage.withinMyParent, 13, 86).build().perform();
        wait.until(attributeToBe(interactionsPage.withinMyParent, "style", "position: relative; left: 13px; top: 86px;"));

        interactionsPage.clickTabCursorStyle();
        wait.until(attributeToBe(interactionsPage.cursorStyle, "aria-selected", "true"));
        actions.dragAndDropBy(interactionsPage.cursorCenter, 300, 100).build().perform();
        wait.until(attributeToBe(interactionsPage.cursorCenter, "style", "position: relative; left: 293.734px; top: 94px;"));
        actions.dragAndDropBy(interactionsPage.cursorTopLeft, 300, 100).build().perform();
        wait.until(attributeToBe(interactionsPage.cursorTopLeft, "style", "position: relative; left: 354.734px; top: 155px;"));
        actions.dragAndDropBy(interactionsPage.cursorBottom, 300, 100).build().perform();
        wait.until(attributeToBe(interactionsPage.cursorBottom, "style", "position: relative; left: 300px; top: 50px;"));
    }
}