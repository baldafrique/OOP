package proxy;

class ProxyExample {

	/**
	 * Test method
	 */
	public static void main(final String[] arguments) {
		Image image1 = createImage("HiRes_10MB_Photo1");
		Image image2 = createImage("HiRes_10MB_Photo2");

		image1.displayImage(); // loading necessary
		image1.displayImage(); // loading unnecessary
		image2.displayImage(); // loading necessary
		image2.displayImage(); // loading unnecessary
		image1.displayImage(); // loading unnecessary
	}

	public static Image createImage(String fileName) {
//		return new RealImage(fileName);
//		return new ProxyImage(fileName);
		return new RateLimitingImage(new ProxyImage(fileName));
	}

}