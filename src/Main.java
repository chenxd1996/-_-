import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File("images/37.png"));
            System.out.print("请输入目标图片的宽度：");
            Scanner sc = new Scanner(System.in);
            int width = sc.nextInt();
            System.out.print("请输入目标图片的高度：");
            int height = sc.nextInt();
            BufferedImage newImg = Scaler.scale(img, width, height);
            ImageIO.write(newImg, "png", new File("images/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
