package com.jag.xml;
import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Transforms an input document to an output document using an XSLT stylesheet.
 * Usage: java XSLTransform input stylesheet output
 **/
public class XSLTransform {
    public static void main(String[  ] args) throws TransformerException {
        // Set up streams for input, stylesheet, and output.
        // These do not have to come from or go to files.  We can also use the
        // javax.xml.transform. {dom,sax} packages use DOM trees and streams of
        // SAX events as sources and sinks for documents and stylesheets.
        StreamSource input = new StreamSource(new File("src/je3/xml/web.xml"));
        StreamSource stylesheet = new StreamSource(new File("src/je3/xml/simplelog.xsl"));
        StreamResult output = new StreamResult(new File("src/je3/xml/test.xml"));
        
        // Get a factory object, create a Transformer from it, and 
        // transform the input document to the output document.
        TransformerFactory factory = TransformerFactory.newInstance( );
        Transformer transformer = factory.newTransformer(stylesheet);
        transformer.transform(input, output);
    }
}
