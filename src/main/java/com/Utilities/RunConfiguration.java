package com.Utilities;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class RunConfiguration {

    public DocumentBuilder dBuilder;
    public Long strImplicitWaitTimeout;
    public String strBrowser;
    public String strOSName;
    public String strBrowserVersion;
    public String strurl;
    public String strusername;
    public String strpassword;


    public RunConfiguration() {

        try {

            String path = System.getProperty("user.dir");
            File readXML = new File(path + "/GlobalConfig.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(readXML);

            // Fetching Values using Tagname from GlobalConfig

            strOSName = doc.getElementsByTagName("OSNAME").item(0).getTextContent();
            strBrowser = doc.getElementsByTagName("Browser").item(0).getTextContent();
            strBrowserVersion = doc.getElementsByTagName("BrowserVersion").item(0).getTextContent();
            strurl = doc.getElementsByTagName("URL").item(0).getTextContent();
            strusername = doc.getElementsByTagName("UserName").item(0).getTextContent();
            strpassword = doc.getElementsByTagName("Password").item(0).getTextContent();
            strImplicitWaitTimeout = Long
                    .parseLong(doc.getElementsByTagName("ImplicitWaitTimeout").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
