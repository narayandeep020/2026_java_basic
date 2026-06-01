package propertiesdemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExp1 {

	public static void main(String[] args) {

		FileReader fr = null;
		try {
			fr = new FileReader("E:\\application_secret\\db.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties p = new Properties();

		try {
			p.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));

	}

}
