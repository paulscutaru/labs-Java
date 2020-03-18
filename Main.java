package com;

import javax.print.Doc;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CatalogUtil.InvalidCatalogException, IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("Resources", "C:/Users/Alex/Desktop/catalog.ser");
        Document doc = new Document("photo1", "Photo Pet",
                "https://cogni.pet/wp-content/uploads/2018/07/pets-fcb53b73523cd42be71be807ca0d6aaf.jpg");
        doc.addTag("type", "Photo");
        Document doc2 = new Document("text1", "Text",
                "C:/Users/Alex/Desktop/vers.txt");
        doc.addTag("type", "Text");
        catalog.add(doc,doc2);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws CatalogUtil.InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("C:/Users/Alex/Desktop/catalog.ser");
        Document doc = catalog.findById("photo1");
        Document doc2 = catalog.findById("text1");
        System.out.println(catalog.getDocuments());
        CatalogUtil.view(doc);
        CatalogUtil.view(doc2);
    }

}
