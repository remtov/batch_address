package batch_address;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlPaser {

	public static void main(String[] args) {
		String path = "/config/test.xml"; //스트링패스에 테스트의 경로를 넣는다
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // 도큐멘트 생산하는 공장 dbf에 newInstance 하여 dbf의
																			// 인스턴스를 만든다
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = XmlPaser.class.getResourceAsStream(path);
			Document doc = db.parse(is);
			NodeList foodList = doc.getElementsByTagName("foods");

			for (int i = 0, max = foodList.getLength(); i < max; i++) {
				Node food = foodList.item(i);
				System.out.println(food.getTextContent());
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();//

		}

	}

}
