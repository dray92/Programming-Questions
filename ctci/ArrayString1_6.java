package ctci;

/**
 * Given an image represented by a NxN matrix,
 * where each pixel in the image is 4 bytes, write
 * a method to rotate the image by 90 degrees.
 * Do it in place.
 * @author Debosmit
 *
 */
public class ArrayString1_6 {
	
	// 4 bytes for every pixel
	public class Pixel {
		private byte byte3, byte2, byte1, byte0;
		
		public Pixel(byte byte3, byte byte2, byte byte1, byte byte0) {
			this.byte3 = byte3;
			this.byte2 = byte2;
			this.byte1 = byte1;
			this.byte0 = byte0;
		}
		
		public Pixel() {
			this((byte)0, (byte)0, (byte)0, (byte)0);
		}
		
		public byte[] getPixel() {
			return new byte[]{byte3, byte2, byte1, byte0};
		}
	}
	
	public void rotate90() {
		
	}

}
