package cr.ac.tec.Images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class GetImages {
    public static ImageView getImageView(String path) throws IOException {//Need to add the logger
        FileInputStream input= new FileInputStream(path);
        Image image=new Image(input);
       ImageView imageView=new ImageView(image);
       return imageView;

    }
}
