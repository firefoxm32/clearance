/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Roudhentel
 */
public class ContextManager {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext = (applicationContext == null)
                ? new ClassPathXmlApplicationContext("spring/config/BeanLocation.xml")
                : applicationContext;
	}
}
