package com.code2016.imooc.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	public static void main(String[] args) {

		

	}
	
	public static void initXmlBean(){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse("src/com/sql/db.xml");

			NodeList booklist = document.getElementsByTagName("book");
			System.out.println("共有" + booklist.getLength() + "本书");
			for (int i = 0; i < booklist.getLength(); i++) {
				Node book = booklist.item(i);
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("book" + (i + 1) + " " + attrs.getLength() + " ");

				for (int j = 0; j < attrs.getLength(); j++) {
					Node attr = attrs.item(j);
					System.out.print(" :" + attr.getNodeName());
					System.out.println(" " + attr.getNodeValue());
				}
				//Element book =(Element)booklist.item(i);
				// String attrValue=book.getAttribute("id");
				// System.out.println(""+attrValue);
				NodeList childNodes = book.getChildNodes();
				System.out.println("" + (i + 1) + "" + childNodes.getLength() + "");
				for (int k = 0; k < childNodes.getLength(); k++) {
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						System.out.print("" + (k + 1) + ":" + childNodes.item(k).getNodeName());
						// System.out.println("--�ڵ�ֵ"+childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println(":" + childNodes.item(k).getTextContent());
					}

				}
				System.out.println("======" + (i + 1) + "========");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
