package com.crm.OrganizationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationspage;

@Listeners(com.crm.GenericLibrary.ListerImplementationClass.class)

public class CreateOrgWithBaseClassTest extends BaseClass
{
	@Test

	public void createOrgWithType() throws Throwable 
	{
		//read data from excel file
		
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+jLib.getRandomNumber();
		String IndType = eLib.readDataFromExcel("Org", 1, 3);
		String Type = eLib.readDataFromExcel("Org", 1, 4);



		/*Step 4: Navigate to Organizations Link*/
		
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();                            


		/*Step 5: click on create organization button*/
		
		Organizationspage op = new Organizationspage(driver);
		op.clickOnCreateOrgImg();

		/*Step 6: enter mandatory fields and save*/
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.CreateOrganizationpage(OrgName,IndType,Type);

		/* Step 7: verification */
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);  
		String actdata = oip.OrgNameInfo();

		if(actdata.contains(OrgName))
		{
			System.out.println(actdata+"------> data verified");
		}
		else
		{
			System.out.println("data invalid");
		}
	}
}
