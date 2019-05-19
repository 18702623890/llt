package com.tanglc;

public interface ManiMenuUi {

	// 显示一级主菜单
	void showLoginMenu();

	void showMainMenu(String loginNo);

	void modifyPwdMenu(String loginNo);

	void transferMoneyMenu(String loginNo);

	void lookTradeRecordMenu(String loginNo);

	void withdrawMoneyMenu(String loginNo);

	void depositMoneyMenu(String loginNo);

	void lookBalanceMenu(String loginNo);

}