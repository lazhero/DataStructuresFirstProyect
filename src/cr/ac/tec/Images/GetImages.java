package cr.ac.tec.Images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * In this class methods are created to obtain images
 * @author Andrey Zuñiga
 */
public class GetImages {
    /**
     * Gets the imageView with the direction it receives
     * @author Andrey Zuñiga
     * @param path
     * @return
     * @throws IOException
     */
    public static ImageView getImageView(String path) throws IOException {//Need to add the logger
        FileInputStream input= new FileInputStream(path);
        Image image=new Image(input);
        ImageView imageView=new ImageView(image);
        return imageView;
    }

    /**
     * Gets the imageView with the direction it receives
     * @author Andrey Zuñiga
     * @param path
     * @return
     */
    public static Image getImage(String path){
        try {
            FileInputStream input = new FileInputStream(path);
            Image image = new Image(input);
            return image;
        }
        catch (Exception e){return null;}
    }
}
