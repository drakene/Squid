/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squid.tasks;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

import org.cirdles.commons.util.ResourceExtractor;
import org.cirdles.squid.Squid;
import org.cirdles.squid.utilities.fileUtilities.FileValidator;

import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author Noah
 */
public class TaskXMLValidationTest {
    @Test
    public void validateXMLTest() {
        ResourceExtractor taskResourceExtractor = new ResourceExtractor(TaskXMLValidationTest.class);
        ResourceExtractor schemaResourceExtractor = new ResourceExtractor(Squid.class);
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema taskXMLSchema = sf.newSchema(schemaResourceExtractor.extractResourceAsFile("schema/SquidTask_XMLSchema.xsd"));
            assertTrue(FileValidator.validateFileIsXMLSerializedEntity(
                    taskResourceExtractor.extractResourceAsFile(
                            "Z6266_=_11pk_Perm1.xml"), taskXMLSchema));
            
        }
        catch(SAXException e){
            System.out.println("Failed to instantiate taskXMLSchema object");
        }
           
    }   
}
