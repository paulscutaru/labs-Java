package com;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (var out = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))){
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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(doc.getLocation());
        try {
            if(file.isFile())
                desktop.open(file);
            else
                desktop.browse(new URI(doc.getLocation().toString()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }
}
