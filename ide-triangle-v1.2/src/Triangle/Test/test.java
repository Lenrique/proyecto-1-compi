package Triangle.Test;

import java.io.File;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class test {
    public static void main(String[] args){
        try {


            //Crea el nuevo nodo sin papa ni hijos
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("The Java Series");
        createNodes(top); //Agrega nodos al nodo anterior
        TreeModel model = new DefaultTreeModel(top); //Crea un modelo apartir del nodo top

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().newDocument();

            // Get tree root...
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

            parseTreeNode(root, doc);

            // Save the document to disk...
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource domSource = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("TreeModel.xml"));
            tf.transform(domSource, sr);

        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }

/*
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("company");
            document.appendChild(root);

            // employee element
            Element employee = document.createElement("employee");
            root.appendChild(employee);

            // employee element
            Element employee2 = document.createElement("employee2");
            root.appendChild(employee2);

            // set an attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue("10");
            employee.setAttributeNode(attr);

            // set an attribute to staff element
            Attr attr1 = document.createAttribute("ids");
            attr1.setValue("10");
            employee2.setAttributeNode(attr1);



            //you can also use staff.setAttribute("id", "1") for this

            // firstname element
            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode("James"));
            employee.appendChild(firstName);

            // lastname element
            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode("Harley"));
            employee.appendChild(lastname);

            // email element
            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("james@example.org"));
            employee.appendChild(email);

            // department elements
            Element department = document.createElement("department");
            department.appendChild(document.createTextNode("Human Resources"));
            employee.appendChild(department);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("test.xml"));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");


*/
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    protected static void parseTreeNode(DefaultMutableTreeNode treeNode, Document doc) {

        String value = treeNode.getUserObject().toString();
        Element rootElement = doc.createElement("Library");
        doc.appendChild(rootElement);

        Enumeration kiddies = treeNode.children();
        while (kiddies.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) kiddies.nextElement();
            parseTreeNode(child, rootElement);
        }

    }

    protected static void parseTreeNode(DefaultMutableTreeNode treeNode, Element doc) {

        Object value = treeNode.getUserObject();

        Element parentElement = null;
        if (value instanceof BookInfo) {
            parentElement = doc.getOwnerDocument().createElement("book");

            BookInfo book = (BookInfo) value;
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("name");
            attrName.setNodeValue(book.getBookName());
            parentElement.getAttributes().setNamedItem(attrName);

            Attr attrURL = doc.getOwnerDocument().createAttribute("url");
            attrURL.setNodeValue(book.getBookURL());
            parentElement.getAttributes().setNamedItem(attrURL);

        } else if (value instanceof BookCatagory) {
            parentElement = doc.getOwnerDocument().createElement("catagory");

            BookCatagory book = (BookCatagory) value;
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("name");
            attrName.setNodeValue(book.getCatagory());
            parentElement.getAttributes().setNamedItem(attrName);
        }

        doc.appendChild(parentElement);

        Enumeration kiddies = treeNode.children();
        while (kiddies.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) kiddies.nextElement();
            parseTreeNode(child, parentElement);
        }
    }

    protected static void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode(new BookCatagory("Books for Java Programmers"));
        top.add(category);

        //original Tutorial
        book = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial: A Short Course on the Basics",
                "tutorial.html"));
        category.add(book);

        //Tutorial Continued
        book = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial Continued: The Rest of the JDK",
                "tutorialcont.html"));
        category.add(book);

        //JFC Swing Tutorial
        book = new DefaultMutableTreeNode(new BookInfo("The JFC Swing Tutorial: A Guide to Constructing GUIs",
                "swingtutorial.html"));
        category.add(book);

        //Bloch
        book = new DefaultMutableTreeNode(new BookInfo("Effective Java Programming Language Guide",
                "bloch.html"));
        category.add(book);

        //Arnold/Gosling
        book = new DefaultMutableTreeNode(new BookInfo("The Java Programming Language", "arnold.html"));
        category.add(book);

        //Chan
        book = new DefaultMutableTreeNode(new BookInfo("The Java Developers Almanac",
                "chan.html"));
        category.add(book);

        category = new DefaultMutableTreeNode(new BookCatagory("Books for Java Implementers"));
        top.add(category);

        //VM
        book = new DefaultMutableTreeNode(new BookInfo("The Java Virtual Machine Specification",
                "vm.html"));
        category.add(book);

        //Language Spec
        book = new DefaultMutableTreeNode(new BookInfo("The Java Language Specification",
                "jls.html"));
        category.add(book);
    }

    public static class BookCatagory {

        private String catagory;

        public BookCatagory(String cat) {
            this.catagory = cat;
        }

        public String getCatagory() {
            return catagory;
        }

    }

    private static class BookInfo {

        private String bookName;
        private String bookURL;

        public BookInfo(String book, String filename) {
            bookName = book;
            bookURL = filename;
        }

        public String getBookName() {
            return bookName;
        }

        public String getBookURL() {
            return bookURL;
        }

        public String toString() {
            return bookName;
        }
    }



}
