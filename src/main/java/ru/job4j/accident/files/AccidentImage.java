package ru.job4j.accident.files;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccidentImage {
    public static void saveImage(MultipartFile image) {
        File folder = new File("accidents");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(folder + File.separator + image.getOriginalFilename());
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getImageAsBytes(String filename) {
        byte[] img = null;
        try (FileInputStream in = new FileInputStream("accidents" + File.separator + filename)) {
            img = in.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
