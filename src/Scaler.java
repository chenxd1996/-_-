import java.awt.image.BufferedImage;

public class Scaler {
    public static BufferedImage scale(BufferedImage img, int target_width, int target_height) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(target_width, target_height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < target_width; i++) {
            for (int j = 0; j < target_height; j++) {
                float x = ((float) i / target_width) * width;
                float y = ((float)j / target_height) * height;
                int x1 = (int)Math.floor(x);
                int x2 = (int)Math.ceil(x) < width? (int)Math.ceil(x): width - 1;
                int y1 = (int) Math.floor(y);
                int y2 = (int) Math.ceil(y) < height? (int)Math.ceil(y): height - 1;
                RGB rgb11 = new RGB(img.getRGB(x1, y1));
                RGB rgb12 = new RGB(img.getRGB(x1, y2));
                RGB rgb21 = new RGB(img.getRGB(x2, y1));
                RGB rgb22 = new RGB(img.getRGB(x2, y2));
                RGB rgb = new RGB(0);
                if (x1 == x2 && y1 == y2) {
                    newImg.setRGB(i, j, img.getRGB(x1, y1));
                } else if (x1 == x2) {
                    rgb.a = (int)((y2 - y) / (y2 - y1) * rgb11.a + (y - y1) / (y2 - y1) * rgb12.a);
                    rgb.r = (int)((y2 - y) / (y2 - y1) * rgb11.r + (y - y1) / (y2 - y1) * rgb12.r);
                    rgb.g = (int)((y2 - y) / (y2 - y1) * rgb11.g + (y - y1) / (y2 - y1) * rgb12.g);
                    rgb.b = (int)((y2 - y) / (y2 - y1) * rgb11.b + (y - y1) / (y2 - y1) * rgb12.b);
                    newImg.setRGB(i, j, rgb.getRgb());
                } else if (y1 == y2) {
                    rgb.a = (int)((x2 - x) / (x2 - x1) * rgb11.a + (x - x1) / (x2 - x1) * rgb12.a);
                    rgb.r = (int)((x2 - x) / (x2 - x1) * rgb11.r + (x - x1) / (x2 - x1) * rgb12.r);
                    rgb.g = (int)((x2 - x) / (x2 - x1) * rgb11.g + (x - x1) / (x2 - x1) * rgb12.g);
                    rgb.b = (int)((x2 - x) / (x2 - x1) * rgb11.b + (x - x1) / (x2 - x1) * rgb12.b);
                    newImg.setRGB(i, j, rgb.getRgb());
                } else {
                    rgb.a = (int)(((float)rgb11.a /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y2 - y)
                            + ((float) rgb21.a /((x2 - x1) * (y2 - y1))) * (x - x1) * (y2 - y)
                            + ((float) rgb12.a /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y - y1)
                            + ((float) rgb22.a /((x2 - x1) * (y2 - y1))) * (x - x1) * (y - y1));
                    rgb.r = (int)(((float)rgb11.r /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y2 - y)
                            + ((float) rgb21.r /((x2 - x1) * (y2 - y1))) * (x - x1) * (y2 - y)
                            + ((float) rgb12.r /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y - y1)
                            + ((float) rgb22.r /((x2 - x1) * (y2 - y1))) * (x - x1) * (y - y1));
                    rgb.g = (int)(((float)rgb11.g /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y2 - y)
                            + ((float) rgb21.g /((x2 - x1) * (y2 - y1))) * (x - x1) * (y2 - y)
                            + ((float) rgb12.g /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y - y1)
                            + ((float) rgb22.g /((x2 - x1) * (y2 - y1))) * (x - x1) * (y - y1));
                    rgb.b = (int)(((float)rgb11.b /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y2 - y)
                            + ((float) rgb21.b /((x2 - x1) * (y2 - y1))) * (x - x1) * (y2 - y)
                            + ((float) rgb12.b /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y - y1)
                            + ((float) rgb22.b /((x2 - x1) * (y2 - y1))) * (x - x1) * (y - y1));
                    newImg.setRGB(i, j, rgb.getRgb());
                }

            }
        }
        return newImg;
    }
}
