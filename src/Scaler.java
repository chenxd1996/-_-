import java.awt.image.BufferedImage;

public class Scaler {
    public static BufferedImage scale(BufferedImage img, int target_width, int target_height) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(target_width, target_height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < target_width; i++) {
            for (int j = 0; j < target_height; j++) {
                float x = ((float) i / target_width) * width;
                float y = ((float)j / target_height) * height;
                int x1 = (int)Math.floor(x);
                int x2 = (int)Math.ceil(x) < width? (int)Math.ceil(x): width - 1;
                int y1 = (int) Math.floor(y);
                int y2 = (int) Math.ceil(y) < height? (int)Math.ceil(y): height - 1;
                int value11 = img.getData().getSample(x1, y1, 0);
                int value12 = img.getData().getSample(x1, y2, 0);
                int value21 = img.getData().getSample(x2, y1, 0);
                int value22 = img.getData().getSample(x2, y2, 0);
                int value;
                if (x1 == x2 && y1 == y2) {
                    newImg.getRaster().setSample(i, j, 0, value11);
                } else if (x1 == x2) {
                    value = (int)((y2 - y) / (y2 - y1) * value11 + (y - y1) / (y2 - y1) * value12);
                    newImg.getRaster().setSample(i, j, 0, value);
                } else if (y1 == y2) {
                    value = (int)((x2 - x) / (x2 - x1) * value11 + (x - x1) / (x2 - x1) * value12);
                    newImg.getRaster().setSample(i, j, 0, value);
                } else {
                    value = (int)(((float)value11 /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y2 - y)
                            + ((float) value21 /((x2 - x1) * (y2 - y1))) * (x - x1) * (y2 - y)
                            + ((float) value12 /((x2 - x1) * (y2 - y1))) * (x2 - x) * (y - y1)
                            + ((float) value22 /((x2 - x1) * (y2 - y1))) * (x - x1) * (y - y1));
                    newImg.getRaster().setSample(i, j, 0, value);
                }

            }
        }
        return newImg;
    }
}
