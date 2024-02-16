package utils;


import org.openqa.selenium.WebElement;
import org.reflections.Reflections;
import pageObjects.Page;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

public class Reflection {
    public static WebElement getWebElementByName(Page page, String name) {
        Field[] fields = page.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(WebElementName.class) && field.getAnnotation(WebElementName.class).name().equals(name)) {
                try {
                    field.setAccessible(true);
                    return (WebElement) field.get(page);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static List<WebElement> getListOfWebElements(Page page, String name) {
        Field[] fields = page.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(WebElementName.class) && field.getAnnotation(WebElementName.class).name().equals(name)) {
                try {
                    field.setAccessible(true);
                    return (List<WebElement>) field.get(page);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Page getPageByName(String pageName) {
        Reflections reflections = new Reflections("pageObjects");
        Set<Class<? extends Page>> classSet = reflections.getSubTypesOf(Page.class);
        for (Class<? extends Page> cl : classSet)
            if (cl.getAnnotation(PageName.class).name().equals(pageName)) {
                try {
                    return cl.getConstructor().newInstance();
                } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                         IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        return null;
    }
}