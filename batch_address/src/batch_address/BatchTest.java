package batch_address;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BatchTest {

	public static void main(String[] args) throws IOException {
		String path = "C:\\jsp_studyKHG\\zipcode_DB";//패스에 주소
		File f = new File(path);//f 파일클래스에 주소
		
		System.out.println("폴더 유무 : " + f.isDirectory()); 
		System.out.println("대상 폴더 유무 : " + f.exists());
		File[] fList = f.listFiles();
		List<List<String>> list = new ArrayList<List<String>>();

		for (File ff : fList) {
			if (ff.getName().endsWith("세종특별자치시.txt")) {

				list = new ArrayList<List<String>>();
				FileInputStream fis = new FileInputStream(ff);
				InputStreamReader fr = new InputStreamReader(fis, "euc-kr");
				BufferedReader br = new BufferedReader(fr);
				String line;
				br.readLine();
				while ((line = br.readLine()) != null) {
					String[] strs = line.split("\\|");
					List<String> strList = new ArrayList<String>();
					for (int i = 0, max = 13; i <= max; i++) {
						strList.add(strs[i]);
					}
					list.add(strList);

				}
				br.close();
				fr.close();
				for (List<String> sList : list) {
					for (String s : sList) {
						System.out.println(s + ",");
						
						
					}
					System.out.println();
					

				}
				System.out.println("exit");

			}
		}

	}

}
