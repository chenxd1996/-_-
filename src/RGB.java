public class RGB {
    public int r, g, b, a;
    public RGB(int rgb) {
        this.a = (rgb & 0xff000000) >> 24;
        this.r = (rgb & 0x00ff0000) >> 16;
        this.g  = (rgb & 0x0000ff00) >> 8;
        this.b = (rgb & 0x000000ff);
    }
    public int getRgb() {
        int rgb;
        rgb = (this.a << 24) + (this.r << 16) + (this.g << 8) + this.b;
        return rgb;
    }
}
