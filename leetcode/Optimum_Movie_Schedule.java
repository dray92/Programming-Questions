package leetcode;

import java.util.Arrays;

/*
 * Question: http://stackoverflow.com/questions/36293291/optimum-movie-schedule-considering-duration-and-no-overlap/36294032#36294032
 */
public class Optimum_Movie_Schedule {
	
	public static void main(String[] args) {
		Movie[] movies = new Movie[] {
			new Movie("f", 5, 9),
			new Movie("a", 1, 2),
			new Movie("b", 3, 4),
			new Movie("c", 0, 6),
			new Movie("d", 5, 7),
			new Movie("e", 8, 9)
		};
		
		// sort by endMonth; startMonth if endMonth clash
		Arrays.sort(movies);
		System.out.println(Arrays.toString(movies));
		
		System.out.println("Final list: ");
		System.out.print(movies[0] + " ");
		
		int cur = 0;
		for(int i = 1 ; i < movies.length ; i++) {
			if(movies[i].startMonth > movies[cur].endMonth) {
				System.out.print(movies[i] + " ");
				cur = i;
			}
		}
	}
	
	

	static class Movie implements Comparable<Movie> {
		String name;
		int startMonth;
		int endMonth;
		int duration;
		public Movie(String name, int start, int end) {
			this.name = name;
			this.startMonth = start;
			this.endMonth = end;
			this.duration = (end + 1) - start;
		}
		
		public int compareTo(Movie o) {
			if(this.endMonth < o.endMonth)
				return -1;
			
			if(this.endMonth == o.endMonth)
				if(this.startMonth < o.startMonth)
					return -1;
			
			return 1;
		}
		
		public String toString() {
			return name + "("+ startMonth + ", " + endMonth + ")";
		}
	}
}
