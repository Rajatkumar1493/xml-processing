package com.example.xmlprocessor;

import org.springframework.stereotype.Service;

@Service
public class XmlService {

    public String fetchValueByXPath(String xml, String xpath) {
        try {
            return XmlUtils.getValueByXPath(xml, xpath);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching value by XPath", e);
        }
    }

    public String updateValueByXPath(String xml, String xpath, String newValue) {
        try {
            return XmlUtils.updateValueByXPath(xml, xpath, newValue);
        } catch (Exception e) {
            throw new RuntimeException("Error updating value by XPath", e);
        }
    }
}
