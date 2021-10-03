package proxy;

public class RateLimitingImage implements Image {
	static int count = 0;
	Image image;

	public RateLimitingImage(Image image) {
		this.image = image;
	}

	@Override
	public void displayImage() {
		System.out.println("Number of display: " + (++count));
		if (count > 3) throw new RuntimeException("Too many request");
		this.image.displayImage();
	}

}
