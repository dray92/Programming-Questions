package ctci;

import java.util.Arrays;

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
	// need it to be static since we are invoking instances of Pixel from main
	// ideally, it would obviously not be a subclass.
	// making pixel a subclass here, for clarity and not to ruin the 
	// directory structure.
	static public class Pixel {
		// 8-bit signed two's complement integer; it has a minimum value 
		// of -128 and a maximum value of 127 (inclusive)
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
		
		public Pixel(byte[] pixels) {
			if(pixels.length != 4)
				throw new IllegalArgumentException("Pixel is 4 bytes");
			
			this.byte3 = pixels[3];
			this.byte2 = pixels[2];
			this.byte1 = pixels[1];
			this.byte0 = pixels[0];
		}
		
		// get bytes for this pixel
		// range of values [-128, 127]
		public byte[] getPixels() {
			return new byte[]{byte3, byte2, byte1, byte0};
		}
		
		// get true values for this pixel
		// int[] length -> 4
		// range of values [0, 255]
		// cant return byte array since now values range
		// from [0, 255]
		public int[] getTruePixels() {
			byte[] bytesB = getPixels();
			int[] bytesI = new int[bytesB.length];
			// scale up all values by 128
			// old range [-128, 127]
			// new range [0, 255]
			for(int i = 0 ; i < bytesI.length ; i++)
				bytesI[i] = (int)bytesB[i] + 128;
			
			return bytesI;
		}
		
		public String toString() {
			return Arrays.toString(getTruePixels());
		}
	}
	
	public void rotate90(Pixel[][] arr) {
		
		if(arr == null)
			throw new IllegalArgumentException("Array cannot be null");
		
		if(!isSquare(arr))
			throw new IllegalArgumentException("Array must be NxN");
		
		if(arr.length == 1)
			return;
		
		int n = arr.length;
		
		// rotation stage
		// layering out the levels of the array
		// first, we do the outermost layer, i.e.
		// arr[0][0...n-1] -> arr[0...n-1][n-1] || top layer -> right layer
		// arr[0...n-1][n-1] -> arr[n-1][n-1...0] || right layer -> bottom layer
		// arr[n-1][0...n-1] -> arr[0...n-1][0] || bottom layer -> left layer
		// left layer -> top layer
		// then move to inner layer and repeat
		for(int layer = 0 ; layer < n/2 ; layer++) {
			// layer start index for array to be copied
			int last = (n - 1) - layer;
			// work with the current layer
			for(int i = layer ; i < last ; i++) {
				
				// getting value at top[i]
				Pixel temp = arr[layer][i];
				
				// left[n-1-i] -> top[i]
				arr[layer][i] = arr[(n - 1) - i][layer];
				
				// bottom[last-i] -> left[n-1-i]
				arr[(n - 1) - i][layer] = arr[(n - 1) - layer][last - i + layer];
				
				// right[i] -> bottom[last-i]
				arr[(n - 1) - layer][last - i + layer] = arr[i][(n - 1) - layer];
				
				// top[i] -> right[i]
				arr[i][(n - 1) - layer] = temp;
			}
		}
	}
	
	// tests if the given array is square
	private boolean isSquare(Pixel[][] arr) {
		int len = arr.length;
		for(int i = 0 ; i < len ; i++)
			if(arr[i].length!=len)
				return false;
		
		return true;
	}
	
	// returns a new number in [min, max];
	private byte randomWithRange(int min, int max) {
		if(max < min)
			return randomWithRange(max, min);
		
		int range = (max - min) + 1;     
		return (byte)((Math.random() * range) + min);
	}
	
	// prints a formatted version of a 2D pixel array
	private void print2DPixelArray(Pixel[][] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		ArrayString1_6 rotate = new ArrayString1_6();
		final int N = 5;
		Pixel[][] pixels = new Pixel[N][N];
		
		byte count = -118;
		for(int i = 0  ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				
				// establish array of bytes for current pixel
				byte[] curPixel = new byte[4];
				for(int k = curPixel.length - 1 ; k >= 0 ; k--)
					// range of byte is [-128, 127]
					curPixel[k] = count;
				pixels[i][j] = new Pixel(curPixel);
				count++;
			}
		}
		System.out.println("Old pixels: ");
		rotate.print2DPixelArray(pixels);
		rotate.rotate90(pixels);
		System.out.println("\nNew pixels: ");
		rotate.print2DPixelArray(pixels);
		
		for(int i = 0  ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				
				// establish array of bytes for current pixel
				byte[] curPixel = new byte[4];
				for(int k = curPixel.length - 1 ; k >= 0 ; k--)
					// range of byte is [-128, 127]
					curPixel[k] = rotate.randomWithRange(-128, 127);
				pixels[i][j] = new Pixel(curPixel);
				count++;
			}
		}
		
		System.out.println("\n\nOld pixels: ");
		rotate.print2DPixelArray(pixels);
		rotate.rotate90(pixels);
		rotate.rotate90(pixels);
		rotate.rotate90(pixels);
		rotate.rotate90(pixels);
		System.out.println("\nNew pixels: ");
		rotate.print2DPixelArray(pixels);
	}

}
