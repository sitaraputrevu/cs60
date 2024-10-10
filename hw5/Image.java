package com.gradescope.hw5;
import java.util.Arrays;

public class Image {
	
	private char[][] image;
	private int height;
	private int width;

	static char[][] smiley = {
		{' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' '},
		{'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
		{'*', ' ', ' ', '^', ' ', ' ', ' ', '^', ' ', ' ', '*'},
		{'*', ' ', ' ', ' ', ' ', 'N', ' ', ' ', ' ', ' ', '*'},
		{'*', ' ', '\\',' ', ' ', ' ', ' ', ' ', '/', ' ', '*'},
		{'*', ' ', ' ', '-', '-', '-', '-', '-', ' ', ' ', '*'},
		{'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
		{' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' '}		
	};
	
	public Image(char[][] contents) {
		image = contents;
		
		// always assume the array is at least of size 1x1
		height = image.length;
		width = image[0].length;
	}
	
    public Image rotateRight() {
    	// TODO: write rotateRight
	}

    public Image flipVertical() {
    	// TODO: write flipVertical
    }

    public Image flipDiagonal() {
    	// TODO: write flipDiagonal
    }

    public void printImage() {
    	// TODO: write printImage
    }
    
    public boolean equals(Image other) {
    	// TODO: write equals
    }

    public static void main (String [] args) {
		System.out.println("CS60 Face");
		Image face = new Image(smiley);
		face.printImage();

		System.out.println("\nUpside Down");
		face = new Image(smiley).flipVertical();
		face.printImage();

		System.out.println("\nFlip Diagonal");
		face = new Image(smiley).flipDiagonal();
		face.printImage();

		System.out.println("\nRotate Right");
		face = new Image(smiley).rotateRight();
		face.printImage();
    }
}

