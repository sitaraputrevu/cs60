package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_CellInDir {

	@Test
	public void test_getNextCellNorth() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		myData.setDirectionNorth();
		BoardCell neighborCell = myData.getNextCellInDir();
		assertEquals("[0, 2, *]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(0, 2));
	}

	@Test
	public void test_getNextCellSouth() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		myData.setDirectionSouth();
		BoardCell neighborCell = myData.getNextCellInDir();
		assertEquals("[2, 2,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(2, 2));
	}

	@Test
	public void test_getNextCellEast() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		myData.setDirectionEast();
		BoardCell neighborCell = myData.getNextCellInDir();
		assertEquals("[1, 3, X]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(1, 3));
	}

	@Test
	public void test_getNextCellWest() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		myData.setDirectionWest();
		BoardCell neighborCell = myData.getNextCellInDir();
		assertEquals("[1, 1, B]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(1, 1));
	}

}
