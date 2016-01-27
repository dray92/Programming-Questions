package ctci;

/**
 * Implement paint fill functionality
 * @author Debosmit
 *
 */
public class RecursionDP9_7 {

	public enum Color {
		WHITE, BLACK, BLUE, GREEN, RED, YELLOW;
	}
	
	public boolean paintFill(Color[][] screen, int x, int y, 
			Color oldColor, Color newColor) {
		
		// invalid coordinate case
		if(x < 0 || y < 0 || 
				x >= screen[0].length || y >= screen.length)
			return false;
		
		// if this is the oldColor, check it's neighbors to see if
		// they need repainting
		if(screen[y][x] == oldColor) {
			screen[y][x] = newColor;
			paintFill(screen, x-1, y, oldColor, newColor);
			paintFill(screen, x+1, y, oldColor, newColor);
			paintFill(screen, x, y-1, oldColor, newColor);
			paintFill(screen, x, y+1, oldColor, newColor);
		}
		
		return true;
	}
	
	public boolean paintFill(Color[][] screen, int x, int y, 
			Color newColor) {
		
		if(screen[y][x] == newColor)
			return false;
		
		return paintFill(screen, x, y, screen[y][x], newColor);
	}
}
