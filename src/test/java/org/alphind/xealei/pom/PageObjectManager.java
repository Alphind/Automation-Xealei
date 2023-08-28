package org.alphind.xealei.pom;

import org.alphind.xealei.pages.LoginPage;
import org.alphind.xealei.pages.SuitesPage;

public class PageObjectManager {

	/* Created by @Author - Mohamed Razul
	 * Description - All the pages class i.e (POM) Objects are created Here..
	 */
	private LoginPage loginPage;
	private SuitesPage suitesPage;
	
	

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public SuitesPage getSuitesPage() {
		return (suitesPage == null) ? suitesPage = new SuitesPage() : suitesPage;
	}
		

	}
	

