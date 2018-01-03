/**
 * 
 */
package org.zapto.ajad.tests;

import java.io.IOException;

import org.junit.Assert;
//import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.zapto.ajad.utils.FileOps;
import org.zapto.ajad.utils.StringOps;

/**
 * @author Ajad
 *
 */
public class CodeTest extends TestNgTestBase
	{

		/*
		 * To test FileOpsad 1. To test ReadFile() 2. It reads a file StrDataCsv
		 * from -> appproperties - > pom 3. Out puts ObjStringBuilder containing
		 * all the strings read line by line 4. So need to assert whether the
		 * read value is same as the input.
		 */
		@Test(enabled = true)
		public void ReadFileTest() throws IOException
			{

				// Test in put params
				// The Csv file to fetch data from
				String ParStrIn = "datalogin.csv";

				// Execute Test
				// Instantiate the FileOps obj
				FileOps ObjFileOps = new FileOps();

				// StringBuilder ObjStringBuilder =
				// ObjFileOps.ReadFile("src/test/resources/datalogin.csv");
				StringBuilder ObjStringBuilder = ObjFileOps.ReadFile(ParStrIn);

				// Test Validation params
				String StrActual = ObjStringBuilder.toString();
				String StrExpected = "ajay,ajay,advith,advith,ajad,ajad";
				String StrMessage = "ReadFileTest - Ok";

				// Validate Test
				// Assert.assertEquals("Ok", "TestString",
				// ObjStringBuilder.toString());
				System.out.println("Executing - ReadFileTest");
				System.out.println(ObjStringBuilder.toString());

				// Assert.assertEquals("ReadFileTest - Ok",
				// "ajay,ajay,advith,advith,ajad,ajad",
				// ObjStringBuilder.toString());
				Assert.assertEquals(StrMessage, StrExpected, StrActual);

			}

		@Test(enabled = true)
		public void StringOpsExecuteTest()
			{

				// Test in put Params
				String ParStrCsvData = "a,b,c,d,e,f";
				String ParStrDelimiter = ",";
				int IntArr2dFieldCount = 2;

				// Test validation params
				String[][] Arr2dStrActual;
				String[][] Arr2dStrExpected =
					{
						{ "a", "b" },
						{ "c", "d" },
						{ "e", "f" } };
				String StrMessage = "StringOpsExecuteTest - Ok";

				// Execute test
				StringOps ObjStringOps = new StringOps();
				Arr2dStrActual = ObjStringOps.FormatCsvDataToArray(
						ParStrCsvData, ParStrDelimiter, IntArr2dFieldCount);

				// Assert.assertEquals(Arr2dStrExpected, Arr2dStrActual);
				System.out.println("Executing - StringOpsExecuteTest");
				Assert.assertArrayEquals(StrMessage, Arr2dStrExpected,
						Arr2dStrActual);

				/*
				 * for(int i=0; i<Arr2dStr.length; i++){ for(int j=0;
				 * j<Arr2dStr[0].length; i++){ StrValidate += Arr2dStr[i][j]; }
				 */
			}

		@Test(enabled = true)
		// @DataProvider(name="Arr2dStrFromCsv")
		public String[][] GetDataFromCsvAsArr2dTest() throws IOException
			{

				/*
				 * Get the string from the csv file using FileOps method User
				 * String Ops method to format this to Arr2d
				 * 
				 * @param ParStrDataCsv
				 * 
				 * @return Arr2d[][]
				 */

				// At the end of the test, this is the expected return to
				// validate
				String[][] Arr2dStrExpected =
					{
						{ "a", "b" },
						{ "c", "d" },
						{ "e", "f" } };

				FileOps ObjFileOps = new FileOps();

				// Get the string from file
				StringBuilder ObjStringBuilder = ObjFileOps
						.ReadFile("datalogin.csv");

				// The String data
				String ParStrCsvData = ObjStringBuilder.toString();
				System.out.println("ParStrCsvData - " + ParStrCsvData);

				// Now to format this to 2dArr
				StringOps ObjStringOps = new StringOps();

				// Format the string in to 2d Array
				String[][] Arr2dStrActual = ObjStringOps.FormatCsvDataToArray(
						ParStrCsvData, ",", 2);

				// String Validation message
				String StrMessage = "GetDataFromCsvAsArr2dTest - ok";

				System.out.println("Executing - GetDataFromCsvAsArr2dTest ");
				Assert.assertArrayEquals(StrMessage, Arr2dStrExpected,
						Arr2dStrActual);

				return Arr2dStrActual;

			}

	}