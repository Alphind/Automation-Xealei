/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul, on date

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.pom;

import org.alphind.xealei.pages.LoginPage;
import org.alphind.xealei.pages.SuitesPage;

public class PageObjectManager {

	/*
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
