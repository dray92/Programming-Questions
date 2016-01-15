package graph;

import java.util.*;
import java.io.*;

/**
 * Driver program that reads in a graph and prompts user for shortest paths in the graph.
 * (Intentionally without comments.  Read through the code to understand what it does.)
 */

public class Paths {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("USAGE: java Paths <vertex_file> <edge_file>");
			System.exit(1);
		}

		MyGraph g = readGraph(args[0],args[1]);

		Scanner console = new Scanner(System.in);
		Collection<Vertex> v = g.vertices();
		System.out.println("Vertices are "+v);
		System.out.println("Edges are "+g.edges());
		for(;;) {
			System.out.print("Start vertex? ");
			Vertex a = new Vertex(console.nextLine());
			if(!v.contains(a)) {
				System.out.println("no such vertex");
				System.exit(0);
			}
			
			System.out.print("Destination vertex? ");
			Vertex b = new Vertex(console.nextLine());
			if(!v.contains(b)) {
				System.out.println("no such vertex");
				System.exit(1);
			}
			
			System.out.println("Shortest path from "+a+" to "+b+":");
			List<Vertex> path = new ArrayList<Vertex>();
			int length = g.shortestPath(a, b, path);
			for(Vertex c : path)
				System.out.print(c+" ");
			System.out.println(length);
		}
	}

	public static MyGraph readGraph(String f1, String f2) {
		Scanner s = null;
		try {
			s = new Scanner(new File(f1));
		} catch(FileNotFoundException e1) {
			System.err.println("FILE NOT FOUND: "+f1);
			System.exit(2);
		}

		Collection<Vertex> v = new ArrayList<Vertex>();
		while(s.hasNext())
			v.add(new Vertex(s.next()));

		try {
			s = new Scanner(new File(f2));
		} catch(FileNotFoundException e1) {
			System.err.println("FILE NOT FOUND: "+f2);
			System.exit(2);
		}

		Collection<Edge> e = new ArrayList<Edge>();
		while(s.hasNext()) {
			try {
				Vertex a = new Vertex(s.next());
				Vertex b = new Vertex(s.next());
				int w = s.nextInt();
				e.add(new Edge(a,b,w));
			} catch (NoSuchElementException e2) {
				System.err.println("EDGE FILE FORMAT INCORRECT");
				System.exit(3);
			}
		}

		return new MyGraph(v,e);
	}
}
