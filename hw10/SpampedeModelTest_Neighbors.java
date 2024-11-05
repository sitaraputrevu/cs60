package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_Neighbors {
	/**
	 * Pictures of test boards at http://tinyurl.com/spampedeTestBoards
	 */

	@Test
	public void test_NorthNeighborWithArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = myData.getCell(2, 3);
		BoardCell neighborCell = myData.getNorthNeighbor(focalCell);
		assertEquals("[1, 3, X]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(1, 3));
	}

	@Test
	public void test_NorthNeighborWithoutArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = myData.getNorthNeighbor();
		assertEquals("[0, 2, *]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(0, 2));

	}

	@Test
	public void test_SouthNeighborWithArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = myData.getCell(2, 3);
		BoardCell neighborCell = myData.getSouthNeighbor(focalCell);
		assertEquals("[3, 3,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(3, 3));
	}

	@Test
	public void test_SouthNeighborWithoutArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = myData.getSouthNeighbor();
		assertEquals("[2, 2,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(2, 2));
	}

	@Test
	public void test_EastNeighborWithArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = myData.getCell(2, 3);
		BoardCell neighborCell = myData.getEastNeighbor(focalCell);
		assertEquals("[2, 4,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(2, 4));
	}

	@Test
	public void test_EastNeighborWithoutArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = myData.getEastNeighbor();
		assertEquals("[1, 3, X]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(1, 3));
	}

	@Test
	public void test_WestNeighborWithArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = myData.getCell(2, 3);
		BoardCell neighborCell = myData.getWestNeighbor(focalCell);
		assertEquals("[2, 2,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(2, 2));
	}

	@Test
	public void test_WestNeighborWithoutArgument() {
		SpampedeModel myData = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = myData.getWestNeighbor();
		assertEquals("[1, 1, B]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == myData.getCell(1, 1));
	}
}
