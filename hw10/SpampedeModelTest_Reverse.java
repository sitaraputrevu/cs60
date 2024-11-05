package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_Reverse {
	/**
	 * Pictures of test boards at http://tinyurl.com/spampedeTestBoards
	 */
	
	@Test
	public void test_ReverseNorth() {
		SpampedeModel myData = new SpampedeModel(TestGame.G14);
		myData.reverseSnake();
		BoardCell nextCell = myData.getNextCellInDir();
		assertEquals("[1, 2,  ]", nextCell.toString());
	}

	@Test
	public void test_ReverseSouth() {
	  SpampedeModel myData = new SpampedeModel(TestGame.G13);
    myData.reverseSnake();
    BoardCell nextCell = myData.getNextCellInDir();
    assertEquals("[4, 2,  ]", nextCell.toString());
	}

	@Test
	public void test_ReverseEast() {
	  SpampedeModel myData = new SpampedeModel(TestGame.G12);
    myData.reverseSnake();
    BoardCell nextCell = myData.getNextCellInDir();
    assertEquals("[2, 4,  ]", nextCell.toString());
	}

	@Test
	public void test_ReverseWest() {
	  SpampedeModel myData = new SpampedeModel(TestGame.G15);
    myData.reverseSnake();
    BoardCell nextCell = myData.getNextCellInDir();
    assertEquals("[3, 1,  ]", nextCell.toString());
	}

}
