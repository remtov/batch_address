package batch_address;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchTest {

static AddrListDAO ad = new AddrListDAOImpl();

	public static void main(String[] args) throws IOException, SQLException {
		String path = "C:\\jsp_studyKHG\\zipcode_DB";//패스에 주소
		File f = new File(path);//f 파일클래스에 주소
		
		System.out.println("폴더 유무 : " + f.isDirectory());    //isDirectory는 검색한 데이터에 대해 파일인지 	디렉토리인지 확인을 해준다. 파일이면 false 디렉토리면 true 



		System.out.println("대상 폴더 유무 : " + f.exists()); // exists() 메소드를 사용하면,"파일"이 있어도 OK 가 나옴
		File[] fList = f.listFiles();//File[] listFiles()  해당 경로의 파일들과 폴더의 파일을 배열로 반환한다. 



		
		List<List<String>> list = new ArrayList<List<String>>(); 

		for (File ff : fList) {
			if (ff.getName().endsWith(".txt")) {

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
				ad.insertAddList(list); 
				br.close();
				fr.close();
			
//				for (List<String> sList : list) {
//					for (String s : sList) {
//						System.out.println(s + ",");
//						
//						
//					}
//					System.out.println();
//					
//
//				}
//				System.out.println("exit");

			}
		}

	}

}
