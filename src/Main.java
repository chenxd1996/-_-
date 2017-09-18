import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File("images/37.png"));
            BufferedImage newImg = Scaler.scale(img, 192, 128);
            ImageIO.write(newImg, "png", new File("images/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
