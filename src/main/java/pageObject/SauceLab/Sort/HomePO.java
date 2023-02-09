package pageObject.SauceLab.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.SauceLab.Sort.HomePageUI;

public class HomePO extends BasePage {
	WebDriver driver;
	
	public HomePO (WebDriver driver) {
		this.driver=driver;
	}

	public void selectDropdownValue(String itemValue) {
		waitForElemenInVisible(driver, HomePageUI.SELECT_DROPDOWN_VALUE);
		selecItemInDefaultDropdown(driver, HomePageUI.SELECT_DROPDOWN_VALUE, itemValue);	
	}

	public boolean isDisplayAscendingName() {
		
		List<WebElement> productsNameElement = getListWebElement(driver, HomePageUI.LIST_PRODUCTS_NAME);
		
		List<String> productsNameText = new ArrayList<String>();
		
		for (WebElement eachProduct : productsNameElement) {
			productsNameText.add(eachProduct.getText());
		}
		
		List<String> productsNameTextClone = new ArrayList<String>(productsNameText);
		Collections.sort(productsNameTextClone);
		
		return productsNameText.equals(productsNameTextClone);
	}

	public boolean isDisplayDescendingName() {
		
		List<WebElement> productsNameElement = getListWebElement(driver, HomePageUI.LIST_PRODUCTS_NAME);
	
		List<String> productsNameText = new ArrayList<String>();
		
		for (WebElement eachProduct : productsNameElement) {
			productsNameText.add(eachProduct.getText());
		}
		
		List<String> productsNameTextClone = new ArrayList<String>(productsNameText);
		Collections.sort(productsNameTextClone);
		Collections.reverse(productsNameTextClone);
		
		return productsNameText.equals(productsNameTextClone);
	}

	public boolean isDisplayAscendingPrice() {
		
		List<WebElement> productsPriceElement = getListWebElement(driver, HomePageUI.LIST_PRODUCTS_PRICE);
		
		List<Float> productsPriceText = new ArrayList<Float>();
		
		for (WebElement eachProduct : productsPriceElement) {
			//chuyển từ string và parse vào kiểu float
			productsPriceText.add(Float.parseFloat(eachProduct.getText().replace("$", "")));
		}
		
		List<Float> productsPriceTextClone = new ArrayList<Float>(productsPriceText);
		Collections.sort(productsPriceTextClone);
		
		return productsPriceText.equals(productsPriceTextClone);
	}

	public boolean isDisplayDescendingPrice() {
		
		List<WebElement> productsPriceElement = getListWebElement(driver, HomePageUI.LIST_PRODUCTS_PRICE);
		
		List<Float> productsPriceText = new ArrayList<Float>();
		
		for (WebElement eachProduct : productsPriceElement) {
			//chuyển từ string và parse vào kiểu float
			productsPriceText.add(Float.parseFloat(eachProduct.getText().replace("$", "")));
		}
		
		List<Float> productsPriceTextClone = new ArrayList<Float>(productsPriceText);
		Collections.sort(productsPriceTextClone);
		Collections.reverse(productsPriceTextClone);
		
		return productsPriceText.equals(productsPriceTextClone);
	}

	}



