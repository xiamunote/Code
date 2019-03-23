package factory_method_pattern;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XMLUtil
{
	public static Object getBean() 
	{
		try
		{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			//����DOM�ĵ�����
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src//factory_method_pattern//config.xml"));
			
			NodeList nl = doc.getElementsByTagName("className");
			//��ȡ�����������ı����
			Node classNode = nl.item(0).getFirstChild();
			String cName = classNode.getNodeValue();
			
			Class c = Class .forName(cName);
			Object obj = c.newInstance();
			return obj;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
