package com.hybridFW.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybridFW.generics.WebDriverUtils;

public class TasksListPage {
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement add_New_Btn;
	@FindBy(xpath = "//div[text()='Add New Task']")
	private WebElement add_NewTasks_Btn;
	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustomer_Btn;
	@FindBy(xpath = "//div[text()='+ New Project']")
	private WebElement newProject_Btn;
	@FindBy(css = "input[id='customerLightBox_nameField']")
	private WebElement customerName_TB;
	@FindBy(css = "textarea[id='customerLightBox_descriptionField']")
	private WebElement customerdescription_Box;
	@FindBy(xpath = "//span[text()='Create Customer']")
	private WebElement creatCustomer_Btn;
	@FindBy(css = "input[id='projectPopup_projectNameField']")
	private WebElement projectTitle_TB;
	// @FindBy(xpath="//button[contains(text(),'Select Customer')]")private
	// WebElement selectCustomer;
	@FindBy(name = "projectDescriptionField")
	private WebElement projectDescription_Box;
	@FindBy(xpath = "//span[text()='Create Project']")
	private WebElement creatProject_Btn;
	@FindBy(xpath = "//div[text()='Create new tasks']")
	private WebElement creatNewTask_Btn;
	// @FindBy(xpath="//button[contains(text(),'Select Project')]")private
	// WebElement selectProject;
	@FindBy(xpath = "//input[@placeholder='Enter task name']")
	private List<WebElement> taskName_TB;
	@FindBy(xpath = "//span[text()='Create Tasks']")
	private WebElement creatTasks_Btn;
	@FindBy(id = "customerLightBox_cancelBtn")
	private WebElement customer_cancel_Btn;
	@FindBy(xpath = "//a[@class='x-menu-item']")
	private List<WebElement> customer_List;
	@FindBy(id = "ext-gen23")
	private WebElement SC;
	@FindBy(id = "ext-gen32")
	private WebElement PT;

	public TasksListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewBtn() {
		add_New_Btn.click();
	}

	public void clickOnNewCustomerBtn() {
		newCustomer_Btn.click();
	}

	public void clickOnAddNewTaskBtn() {
		add_NewTasks_Btn.click();
	}

	public void clickOnNewProjectBtn() {
		newProject_Btn.click();
	}

	public void setCustomerName(String cName) {
		customerName_TB.sendKeys(cName);
		;
	}

	public void setCstmerDescription(String cDcrpn) {
		customerdescription_Box.sendKeys(cDcrpn);
	}

	public void clickOnCreatCustomerBtn() {
		creatCustomer_Btn.click();
	}

	public void setProjectTitle(String pTitle) {
		projectTitle_TB.sendKeys(pTitle);
		;
	}

	public boolean selectCustomer(Object customer_Name, WebDriver driver) {
		// new WebDriverUtils().waitConditionClick(driver, selectCustomer);
		// selectCustomer.click();
		new WebDriverUtils().waitConditionClick(driver, SC);
		SC.click();
		ArrayList<String> al = new ArrayList<>();
		for (WebElement n : customer_List) {
			al.add(n.getText());
		}
		if (al.contains(customer_Name)) {
			for (WebElement name : customer_List) {
				if (name.getText().equals(customer_Name))
					name.click();
			}
			return true;
		} else
			return false;
	}

	public void setProjectDescrptn(String pDcrpn) {
		projectDescription_Box.sendKeys(pDcrpn);
		;
	}

	public void clickOncreatProjectBtn() {
		creatProject_Btn.click();
	}

	public void clickOnCreatNewTaskBtn() {
		creatNewTask_Btn.click();
	}

	public boolean selectProject(String project, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(selectProject));
		// selectProject.click();
		wait.until(ExpectedConditions.elementToBeClickable(PT));
		PT.click();
		ArrayList<String> al = new ArrayList<>();
		for (WebElement n : customer_List) {
			al.add(n.getText());
		}
		if (al.contains(project)) {
			for (WebElement name : customer_List) {
				if (name.getText().equals(project))
					name.click();
			}
			return true;
		} else
			return false;
	}

	public void setTasksName(List<String> tNames) {
		for (int i = 0; i < taskName_TB.size(); i++) {
			taskName_TB.get(i).sendKeys(tNames.get(i));
		}
	}

	public void clickOnCreatTaskBtn() {
		creatTasks_Btn.click();
	}

	public void clickOnCancelBtn() {
		customer_cancel_Btn.click();
	}
}
