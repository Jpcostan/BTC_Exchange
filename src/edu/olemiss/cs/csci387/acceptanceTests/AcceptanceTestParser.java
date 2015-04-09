
package edu.olemiss.cs.csci387.acceptanceTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


// Adapted from http://www.vogella.com/tutorials/JavaXML/article.html

public class AcceptanceTestParser {
	static final String TYPE = "type";
	static final String COMMAND = "command";
	static final String MODE = "mode";
	static final String UNIT = "unit";
	static final String CURRENT = "current";
	static final String INTERACTIVE = "interactive";



	public void executeTest(String configFile) {

		AcceptanceTestCommand command = null;
		Environment environment = new Environment();
		String resultname = "empty";

		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// If we have an command element, we create a new command
					if (startElement.getName().getLocalPart() == (COMMAND)) {
						// There should be a type attribute, which we'll pass to the
						// command factory method. This doesn't require an iterator, but
						// I'll leave that in for the moment.
						@SuppressWarnings("unchecked")
						Iterator<Attribute> attributes = startElement.getAttributes();
						
						Attribute attribute = attributes.next();
						
						if (attribute.getName().toString().equals(TYPE)) {
							
							// A factory method
							command=AcceptanceTestCommand.createCommand(attribute.getValue());
							resultname = "empty";
							
						} else {
							System.err.println("Acceptance Test: Type expected for command, but found " + attribute.getName());
						}						
					}


					// record the name that we'll store the result of the command under.
					if (event.asStartElement().getName().getLocalPart()
							.equals("resultname")) {
						event = eventReader.nextEvent();
						
						resultname = event.asCharacters().getData();
						continue;
					}

					// Add an argument to the command. It's up to the command itself to 
					// interpret the argument as a constant or environment variable.
					if (event.asStartElement().getName().getLocalPart()
							.equals("argument")) {
						event = eventReader.nextEvent();
						
						command.addArgument(event.asCharacters().getData());
						continue;
					}

					// Tell the command the name of the object it should use to execute a method.
					// This name will be used to find the object in the environment by command.execute().
					if (event.asStartElement().getName().getLocalPart()
							.equals("objectname")) {
						event = eventReader.nextEvent();
						
						command.setObjectName(event.asCharacters().getData());
						continue;
					}

				}
				
				// If we reach the end of a COMMAND element,  it's time to execute the command.
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (COMMAND)) {
						
						Object result = command.execute(environment);
						
						if (result != null){
							
							environment.set(resultname, result);
						}
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}
	
	

} 
