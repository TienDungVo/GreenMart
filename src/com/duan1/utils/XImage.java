/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author dung8
 */
public class XImage {

    public static Image getAppIcon() {
        URL url = XImage.class.getResource("/com/edusys/icon/fpt.png");
        return new ImageIcon(url).getImage();
    }

    public static boolean save(File scr) {
        File dst = new File("F:\\IDE\\NetBeansProjects\\DuAn1\\src\\com\\duan1\\icon", scr.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();

        }
        try {
            Path from = Paths.get(scr.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static ImageIcon read(String fileName) {
        File path = new File("F:\\IDE\\NetBeansProjects\\DuAn1\\src\\com\\duan1\\icon",fileName);
        return  new ImageIcon(path.getAbsolutePath());
    }
}
