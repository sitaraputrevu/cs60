package com.gradescope.hw5;
import java.util.Arrays;

public class Image {
	
	private char[][] image;
	private int height;
	private int width;
	
	public Image(char[][] contents) {
		this.image = contents;
		
		// always assume the array is at least of size 1x1
		this.height = this.image.length;
		this.width = this.image[0].length;
	}
	
    public Image rotateRight() {
    	// TODO: write rotateRight
	}

    public Image flipHorizontal() {
    	// TODO: write flipHorizontal
    }

    public Image flipVertical() {
    	// TODO: write flipVertical
    }

    public Image flipDiagonal() {
    	// TODO: write flipDiagonal
    }

    public Image badDiagonal() {
    	// TODO: write badDiagonal
    }

    public void printImage() {
    	// TODO: write printImage
    }
    
    public boolean equals(Image other) {
    	// TODO: write equals
    }

    public static void main (String [] args) {
    }
}