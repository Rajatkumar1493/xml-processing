

    package com.example.xmlprocessor;

import com.example.xmlprocessor.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class XmlXpathProcessorApplication {
        public static void main(String[] args) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            XmlService xmlService = context.getBean(XmlService.class);
            String xmlData = XmlTestData.getSampleXml();

            System.out.println("Original XML:\n" + xmlData);

            // Fetch value by XPath
            String xpath = "/Student/Name";
            String value = xmlService.fetchValueByXPath(xmlData, xpath);
            System.out.println("\nValue at XPath (" + xpath + "): " + value);

            // Update value at XPath
            String updatedXml = xmlService.updateValueByXPath(xmlData, "/Student/Name", "Updated Student Name");
            System.out.println("\nUpdated XML:\n" + updatedXml);

            context.close();
        }
    }

