package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Tests.BaseTest.actions;

public class InteractionsPage {
    @FindBy(xpath = "//li[contains(., 'Sortable')]")
    public WebElement sortable;
    @FindBy(xpath = "//li[contains(., 'Selectable')]")
    public WebElement selectable;
    @FindBy(xpath = "//li[contains(., 'Resizable')]")
    public WebElement resizable;
    @FindBy(xpath = "//li[contains(., 'Droppable')]")
    public WebElement droppable;

    @FindBy(xpath = "//a[@id = 'demo-tab-list']")
    private WebElement demoTabList;
    @FindBy(xpath = "//a[@id = 'demo-tab-grid']")
    private WebElement demoTabGrid;
    @FindBy(xpath = "//div[@id = 'demo-tabpane-list']")
    public WebElement demoTabpaneList;
    @FindBy(xpath = "//div[@id = 'demo-tabpane-grid']")
    public WebElement demoTabpaneGrid;
    @FindBy(xpath = "//div[contains(@class, 'vertical-list-container')]/div")
    public List<WebElement> listGroupItemAction;

    @FindBy(xpath = "//div[@id = 'resizableBoxWithRestriction']")
    public WebElement resizableBoxWithRestriction;
    @FindBy(xpath = "//div[@id = 'resizableBoxWithRestriction']/span")
    public WebElement reactResizableHandle;
    @FindBy(xpath = "//div[@id = 'resizable']")
    public WebElement resizableBox;
    @FindBy(xpath = "//div[@id = 'resizable']/span")
    public WebElement reactResizableHandle2;

    @FindBy(xpath = "//a[contains(@id, 'simple')]")
    public WebElement simple;
    @FindBy(xpath = "//a[contains(@id, 'accept')]")
    public WebElement accept;
    @FindBy(xpath = "//a[contains(@id, 'preventPropogation')]")
    public WebElement preventPropogation;
    @FindBy(xpath = "//a[contains(@id, 'revertable')]")
    public WebElement revertable;

    @FindBy(xpath = "//div[@id ='draggable']")
    public WebElement draggable;
    @FindBy(xpath = "//div[contains(@id, 'simple')]/div[@id ='droppable']")
    public WebElement droppableSimple;
    @FindBy(xpath = "//div[@id ='acceptable']")
    public WebElement acceptable;
    @FindBy(xpath = "//div[@id ='notAcceptable']")
    public WebElement notAcceptable;
    @FindBy(xpath = "//div[contains(@id, 'accept')]/div[@id ='droppable']")
    public WebElement droppableAccept;
    @FindBy(xpath = "//div[@id ='dragBox']")
    public WebElement dragBox;
    @FindBy(xpath = "//div[@id ='notGreedyDropBox']")
    public WebElement notGreedyDropBox;
    @FindBy(xpath = "//div[@id ='notGreedyInnerDropBox']")
    public WebElement notGreedyInnerDropBox;
    @FindBy(xpath = "//div[@id ='greedyDropBox']")
    public WebElement greedyDropBox;
    @FindBy(xpath = "//div[@id ='greedyDropBoxInner']")
    public WebElement greedyDropBoxInner;
    @FindBy(xpath = "//div[contains(@id, 'revertable')]/div[@id ='droppable']")
    public WebElement droppableRevertable;
    @FindBy(xpath = "//div[@id ='revertable']")
    public WebElement revertableBox;
    @FindBy(xpath = "//div[@id ='notRevertable']")
    public WebElement notRevertable;

    public void clickDemoTabList() {
        demoTabList.click();
    }

    public void clickDemoTabGrid() {
        demoTabGrid.click();
    }

    public WebElement getVerticalListItem(String item) {
        return driver.findElement(By.xpath("//div[contains(@class, 'vertical-list-container')]/div[contains(@class, 'list-group-item') and (text() = '" + item + "')]"));
    }

    public WebElement getVerticalNumberListItem(String number) {
        return driver.findElement(By.xpath("//div[contains(@class, 'vertical-list-container')]/div[contains(@class, 'list-group-item')][" + number + "]"));
    }

    public WebElement getCreateGridListItem(String item) {
        return driver.findElement(By.xpath("//div[@class = 'create-grid']/div[contains(@class, 'list-group-item') and (text() = '" + item + "')]"));
    }

    public WebElement getCreateGridNumberListItem(String number) {
        return driver.findElement(By.xpath("//div[@class = 'create-grid']/div[contains(@class, 'list-group-item')][" + number + "]"));
    }

    public void dragAndDropGridItem(String source, String target) {
        actions.dragAndDrop(getCreateGridListItem(source), getCreateGridListItem(target)).build().perform();
    }

    public void dragAndDropListItem(String source, String target) {
        actions.dragAndDrop(getVerticalListItem(source), getVerticalListItem(target)).build().perform();
    }

    public WebElement getListGroupItem(String text) {
        return driver.findElement(By.xpath("//li[contains(@class, 'list-group-item') and (text() = '" + text + "')]"));
    }

    public void clickListGroupItem(String text) {
        getListGroupItem(text).click();
    }

    public void clickTabSimple() {
        simple.click();
    }

    public void clickTabAccept() {
        accept.click();
    }

    public void clickTabPreventPropogation() {
        preventPropogation.click();
    }

    public void clickTabRevertable() {
        revertable.click();
    }

    public void dragAndDropSimple() {
        actions.dragAndDrop(draggable, droppableSimple).build().perform();
    }

    public void dragAndDropNotAccept() {
        actions.dragAndDrop(notAcceptable, droppableAccept).build().perform();
    }

    public void dragAndDropAccept() {
        actions.dragAndDrop(acceptable, droppableAccept).build().perform();
    }

    public void dragAndDropNotGreedy() {
        actions.dragAndDrop(dragBox, notGreedyInnerDropBox).build().perform();
    }

    public void dragAndDropGreedy() {
        actions.dragAndDrop(dragBox, greedyDropBoxInner).build().perform();
    }

    public void dragAndDropNotRevertable() {
        actions.dragAndDrop(notRevertable, droppableRevertable).build().perform();
    }

    public void dragAndDropRevertable() {
        actions.dragAndDrop(revertableBox, droppableRevertable).build().perform();
    }

    private WebDriver driver;

    public InteractionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
