package ChartDemo;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
public class XMLUtil {
public static String getChartType(){
	try{
		DocumentBuilderFactory dFactroy = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dFactroy.newDocumentBuilder();
		Document doc = builder.parse(new File("src//ChartDemo//config.xml"));
		
		NodeList n1= doc.getElementsByTagName("chartType");
		Node classNode = n1.item(0).getFirstChild();
		String chartType = classNode.getNodeValue().trim();
		return chartType;	
		
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	
}
}
