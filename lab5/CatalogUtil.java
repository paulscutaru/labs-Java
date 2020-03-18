package com;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog) {
        try (var out = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            out.writeObject(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog c = new Catalog();
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            c = (Catalog) in.readObject();
            if (c == null || c.getDocuments().isEmpty()) {
                throw new InvalidCatalogException(new Exception());
            }
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            System.out.println("Class not found!");
            e1.printStackTrace();
        }
        return c;
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(doc.getLocation());
        try {
            if (file.isFile())
                desktop.open(file);
            else
                desktop.browse(new URI(doc.getLocation().toString()));
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file " + file);
            e.printStackTrace();
        } catch (URISyntaxException e1) {
            System.out.println("Given URI syntax is wrong!");
            e1.printStackTrace();
        }
    }

}
