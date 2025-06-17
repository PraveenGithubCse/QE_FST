package Activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Activity14 {
	public static void main(String[] args) throws IOException {
		// create new file
		File f = new File("src/main/resources/input.txt");
		if (f.createNewFile()) {
			System.out.println("File Created succesfully");
		} else { 
			System.out.println("File already exists");
		}
		System.out.println("Data in input file: " + FileUtils.readFileToString(f, Charset.defaultCharset()));
		// copy the file to a new directory
		FileUtils.copyFileToDirectory(f, new File("target/destDir"));

		// confirmation for data copied or not
		File f1 = new File("target/destDir/input.txt");
		if (FileUtils.readFileToString(f1, Charset.defaultCharset()).length() > 0) {
			System.out.println("Data copied successfully");
		} else {
			System.out.println("Check once again!!! Data not copied");
		}
	}
}
