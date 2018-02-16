package xml;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import org.dom4j.io.SAXReader;
import org.junit.Test;

public class XmlTest {

	private static final String XML_PATH = "src/bookstore1.xml";
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/**
	 * 解析XML 01:创建SAXReader的对象reader; 02:通过reader对象的read方法加载XML文件,获取document对象;
	 * 03:通过document对象获取XML文件的根节点; 04:通过element对象的elementIterator方法获取迭代器;
	 * 05:遍历迭代器,获取根节点中的信息
	 * 
	 **/
	@Test
	public void readAndParseXML() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(XML_PATH));
		Element rootElement = document.getRootElement(); //获取根节点
		System.out.println("根节点:"+rootElement.getName());
		Iterator<?> iterator = rootElement.elementIterator();
		while (iterator.hasNext()) {
			System.out.println("开始遍历-->");
			Element childElement = (Element) iterator.next(); //获取二级节点
			System.out.println("二级节点: "+childElement.getName());
			Iterator<?> childIterator = childElement.elementIterator(); //获取二级子节点
			while (childIterator.hasNext()) { 
				Element childElement2 = (Element) childIterator.next();
				System.out.println("节点名: " + childElement2.getName() + ":节点值-->" + childElement2.getStringValue());
			}
			System.out.println("结束遍历");
		}
	}


}
