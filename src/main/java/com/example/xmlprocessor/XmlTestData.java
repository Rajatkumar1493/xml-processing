package com.example.xmlprocessor;

public class XmlTestData {
    public static String getSampleXml() {
        return """
                <Student>
                    <Id>1</Id>
                    <Name>Student Name</Name>
                    <BirthDate>2000-01-01</BirthDate>
                    <Class>12</Class>
                    <Grade>A</Grade>
                    <Address>123 Main St</Address>
                    <Contact>
                        <Mobile>9876543210</Mobile>
                        <Home>0123456789</Home>
                    </Contact>
                </Student>
                """;
    }
}
