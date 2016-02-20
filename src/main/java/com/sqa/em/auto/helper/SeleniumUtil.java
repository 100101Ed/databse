/**
 * File Name: SeleniumUtil.java<br>
 * Mora, Eduardo<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 20, 2016
 */
package com.sqa.em.auto.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * SeleniumUtil //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mora, Eduardo
 * @version 1.0.0
 * @since 1.0
 */
public class SeleniumUtil {

	public enum LOCATER_TYPE {
		XPATH, CSS, ID, NAME, CLASSNAME, TAG, TEXT, PTEXT
	}

	public static void gotoAndClick(WebDriver driver, String idLocation) {
		System.out.println("DEFAULT STRATEGY:");
		gotoAndClick(driver, idLocation, LOCATER_TYPE.CSS);
	}

	public static void gotoAndClick(WebDriver driver, String idLocation, LOCATER_TYPE locater_type) {
		switch (locater_type) {
		case ID:
			driver.findElement(By.id(idLocation)).click();
			break;
		case XPATH:
			driver.findElement(By.xpath(idLocation)).click();
			break;
		case CSS:
			driver.findElement(By.cssSelector(idLocation)).click();
			break;
		case NAME:
			driver.findElement(By.name(idLocation)).click();
			break;
		case CLASSNAME:
			driver.findElement(By.className(idLocation)).click();
			break;
		case TAG:
			driver.findElement(By.tagName(idLocation)).click();
			break;
		case TEXT:
			driver.findElement(By.linkText(idLocation)).click();
			break;
		case PTEXT:
			driver.findElement(By.partialLinkText(idLocation)).click();
			break;
		default:
			System.out.println("Your locater " + locater_type + " was not found make sure your Enum is updated");
			break;
		}
	}

	public static void superClick(WebDriver driver, String[] locations, LOCATER_TYPE[] strategies) {
		for (int i = 0; i < locations.length; i++) {
			gotoAndClick(driver, locations[i], strategies[i]);
		}
	}
}
