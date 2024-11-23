package com.pageobjectmanager;

import java.io.FileReader;

import com.baseclass.Base_Class;
import com.pageobjectmodel.WomenSearchModelPage;
import com.src.main.resource.LumaFIleReaderManager;

public class LumaPageObjectManager extends Base_Class {
private WomenSearchModelPage  womenSearchModelPage;
private LumaFIleReaderManager lumaFIleReaderManager;
public WomenSearchModelPage getWomenSearchModelPage() {
	if(womenSearchModelPage==null)
		womenSearchModelPage = new WomenSearchModelPage(driver);
	return womenSearchModelPage;
}
public LumaFIleReaderManager getLumaFIleReaderManager() {
	if(lumaFIleReaderManager==null)
		lumaFIleReaderManager = new LumaFIleReaderManager();
	return lumaFIleReaderManager;
}
}
