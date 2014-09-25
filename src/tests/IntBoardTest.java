package tests;

import java.util.LinkedList;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import classes.BoardCell;
import classes.IntBoard;

public class IntBoardTest {
	public IntBoard board;

	@Before
	public void init(){
		 board = new IntBoard();
		 board.calcAdjacencies();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void adjListTL() {
		BoardCell cell = board.getCell(0,0);
		LinkedList<BoardCell> list = board.getAdjList(cell);
		Assert.assertTrue(list.contains(board.getCell(1, 0)));
		Assert.assertTrue(list.contains(board.getCell(0, 1)));
		Assert.assertEquals(2, list.size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void adjListBR(){
		BoardCell cell = board.getCell(3, 3);
		LinkedList<BoardCell> list = board.getAdjList(cell);
		Assert.assertTrue(list.contains(board.getCell(2,3)));
		Assert.assertTrue(list.contains(board.getCell(3,2)));
		Assert.assertEquals(2, list.size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void adjListRE(){
		BoardCell cell = board.getCell(1, 3);
		LinkedList<BoardCell> list = board.getAdjList(cell);
		Assert.assertTrue(list.contains(board.getCell(0,3)));
		Assert.assertTrue(list.contains(board.getCell(2,3)));
		Assert.assertTrue(list.contains(board.getCell(1,2)));
		Assert.assertEquals(3, list.size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void adjListLE(){
		BoardCell cell = board.getCell(3, 0);
		LinkedList<BoardCell> list = board.getAdjList(cell);
		Assert.assertTrue(list.contains(board.getCell(3,1)));
		Assert.assertTrue(list.contains(board.getCell(2,0)));
		Assert.assertEquals(2, list.size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void adjListM(){
		BoardCell cell = board.getCell(2, 2);
		LinkedList<BoardCell> list = board.getAdjList(cell);
		Assert.assertTrue(list.contains(board.getCell(2,3)));
		Assert.assertTrue(list.contains(board.getCell(2,1)));
		Assert.assertTrue(list.contains(board.getCell(1,2)));
		Assert.assertTrue(list.contains(board.getCell(3,2)));
		Assert.assertEquals(4, list.size());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void adjList2C(){
		BoardCell cell = board.getCell(1, 1);
		LinkedList<BoardCell> list = board.getAdjList(cell);
		Assert.assertTrue(list.contains(board.getCell(1,2)));
		Assert.assertTrue(list.contains(board.getCell(0,1)));
		Assert.assertTrue(list.contains(board.getCell(2,1)));
		Assert.assertTrue(list.contains(board.getCell(1,0)));
		Assert.assertEquals(4, list.size());
	}
	
	// Test path creation
	@Test
	public void testTargets_TL_3()
	{
		BoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 3);
		Set targets = board.getTargets();
		Assert.assertTrue(targets.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(0, 3)));
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
		Assert.assertEquals(6, targets.size());
	}
	
	@Test
	public void testTargets_BR_1()
	{
		BoardCell cell = board.getCell(3, 3);
		board.calcTargets(cell, 3);
		Set targets = board.getTargets();

		Assert.assertTrue(targets.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(2, 3)));
		Assert.assertTrue(targets.contains(board.getCell(3, 2)));
		Assert.assertTrue(targets.contains(board.getCell(0, 3)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertEquals(6, targets.size());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testTargets_RE_2()
	{
		BoardCell cell = board.getCell(1, 3);
		board.calcTargets(cell, 2);
		Set targets = board.getTargets();

		Assert.assertTrue(targets.contains(board.getCell(0, 2)));
		Assert.assertTrue(targets.contains(board.getCell(2, 2)));
		Assert.assertTrue(targets.contains(board.getCell(1, 1)));
		Assert.assertTrue(targets.contains(board.getCell(3, 3)));
		Assert.assertEquals(4, targets.size());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testTargets_C1_1()
	{
		BoardCell cell = board.getCell(1, 1);
		board.calcTargets(cell, 1);
		Set targets = board.getTargets();

		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertEquals(4, targets.size());

	}
	@SuppressWarnings("deprecation")
	@Test
	public void testTargets_C2_2()
	{
		BoardCell cell = board.getCell(2, 2);
		board.calcTargets(cell, 2);
		Set targets = board.getTargets();

		Assert.assertTrue(targets.contains(board.getCell(0, 2)));
		Assert.assertTrue(targets.contains(board.getCell(2, 0)));
		Assert.assertTrue(targets.contains(board.getCell(1, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 3)));
		Assert.assertTrue(targets.contains(board.getCell(3, 1)));
		Assert.assertTrue(targets.contains(board.getCell(3, 3)));
		Assert.assertEquals(6, targets.size());
	}
	@Test
	public void testTargets_C2_3()
	{
		BoardCell cell = board.getCell(2, 2);
		board.calcTargets(cell, 3);
		Set targets = board.getTargets();
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 3)));
		Assert.assertTrue(targets.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(3, 2)));
		Assert.assertTrue(targets.contains(board.getCell(2, 3)));
		Assert.assertEquals(8, targets.size());
	}
	@Test
	public void testTargets_LE_2()
	{
		BoardCell cell = board.getCell(0, 2);
		board.calcTargets(cell, 2);
		Set targets = board.getTargets();

		Assert.assertTrue(targets.contains(board.getCell(0, 0)));
		Assert.assertTrue(targets.contains(board.getCell(1, 1)));
		Assert.assertTrue(targets.contains(board.getCell(2, 2)));
		Assert.assertTrue(targets.contains(board.getCell(1, 3)));
		Assert.assertEquals(4, targets.size());
	}

}
