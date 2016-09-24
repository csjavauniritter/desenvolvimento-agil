package br.com.unirriter.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleUtils {
	
	private static ResourceBundle resourceBundle = null;
	
	private static ResourceBundleUtils instance = null;
	
	private ResourceBundleUtils() {
		resourceBundle = ResourceBundle.getBundle("messages");
	}
	
	public static ResourceBundleUtils getInstance() {
		if (instance == null)  {
			instance = new ResourceBundleUtils();
		}
		return instance;
	}
	
	public String getProperty(String name) {
		String result = null;
		
		try {
			result = resourceBundle.getString(name);
		} catch (MissingResourceException|NullPointerException ex) {
			return null;
		}
		return result;
	}
}
