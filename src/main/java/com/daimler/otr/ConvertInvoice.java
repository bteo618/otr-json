package com.daimler.otr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.*;

public class ConvertInvoice {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        ConvertInvoice ci = new ConvertInvoice();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("data/0b406468-5d73-4fd6-8869-c33c0fec8f0c.json")))
        ) {
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);

            for (int n = 0; n <= 1; n++){
                System.out.println(jsonInString);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private InputStream getFileFromResources(String fileName) {
//        return this.getClass().getResourceAsStream(fileName);

//        ClassLoader classLoader = getClass().getClassLoader();
//
//        URL resource = classLoader.getResource(fileName);
//        if (resource == null) {
//            throw new IllegalArgumentException("file is not found!");
//        } else {
//            return new File(resource.getFile());
//        }
//    }

}
