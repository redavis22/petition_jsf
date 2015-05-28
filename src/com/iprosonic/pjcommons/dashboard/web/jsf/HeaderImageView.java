package com.iprosonic.pjcommons.dashboard.web.jsf;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.imageio.ImageIO;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@ManagedBean
public class HeaderImageView {
 
    private StreamedContent graphicText;
         
 
    @PostConstruct
    public void init() {
        try {
            //Graphic Text
            BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImg.createGraphics();
            g2.drawString("This is a text", 0, 10);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImg, "png", os);
            graphicText = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png"); 

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public StreamedContent getGraphicText() {
        return graphicText;
    }
         
     
}