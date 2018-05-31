package com.yard42.learn.java.graph;

import org.junit.Test;

import com.yard42.learn.java.DataUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestGraphSearch
{
   TreeNode root = DataUtils.buildRandomTree(3, 3, true);

   @Test
   public void testBFS()
   {
      assertFalse(BFS.hasNode(root, new TreeNode(30)));
      assertTrue(BFS.hasNode(root, new TreeNode(3)));
   }

   @Test
   public void testDFS()
   {
      assertFalse(DFS.hasNode(root, new TreeNode(30)));
      assertTrue(DFS.hasNode(root, new TreeNode(3)));
   }
}
