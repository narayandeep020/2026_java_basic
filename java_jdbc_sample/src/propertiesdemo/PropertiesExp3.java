package propertiesdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExp3 {

	public static void main(String[] args) {

		Properties p = new Properties();

		p.setProperty("name", "Sidhi Vinayak");
		p.setProperty("email", "vinayak123@gmail. com");

		try {
			p.store(new FileWriter("E:\\properties_secret\\info.properties"), "gfg properties example");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
