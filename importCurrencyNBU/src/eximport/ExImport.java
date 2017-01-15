/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eximport;

import entity.Currency;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/**
 *
 * @author Sergey
 */
public class ExImport {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws MalformedURLException, NumberFormatException, DOMException, ParseException  {

      Date d1 = dateFormat("02.01.1996");
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, 1);
      Date d2 = cal.getTime();
 
      Iterator<Date> i = new DateIterator(d1, d2);
      while(i.hasNext())
      {
         Date date = i.next();
         SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyyMMdd");
        String dateURL = dateFormat.format(date);
         System.out.println(dateURL);
         URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date="+dateURL);
          System.out.println(url);
         parseXML(url);
      }
//        URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20170111");
//        parseXML(url);

    }

    public static void insert(Currency currency) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exImportPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
        em.close();
    }

    public static Date dateFormat(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("dd.MM.yyyy");
        Date date = (Date) dateFormat.parse(dateString);
        return date;
    }

    public static void parseXML(URL url) throws NumberFormatException, DOMException, ParseException {
        try {
            /**
             * Create a DocumentBuilder
             */
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = (Document) db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("currency");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    int r030 = Integer.parseInt(eElement
                            .getElementsByTagName("r030")
                            .item(0)
                            .getTextContent());
                    String name = eElement
                            .getElementsByTagName("txt")
                            .item(0)
                            .getTextContent();
                    Double rate = Double.parseDouble(eElement
                            .getElementsByTagName("rate")
                            .item(0)
                            .getTextContent());
                    String cc = eElement
                            .getElementsByTagName("cc")
                            .item(0)
                            .getTextContent();
                    String exchangedate = eElement
                            .getElementsByTagName("exchangedate")
                            .item(0)
                            .getTextContent();
                    Date date = dateFormat(exchangedate);
                    Date dateNow = new Date();
                    insert(new Currency(r030, name, rate, cc, date, dateNow));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ExImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ExImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ExImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
