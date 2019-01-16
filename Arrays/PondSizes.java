/*
 * You have an integer matrix representing a plot of land, where the value of that location represents the height above the sea level. A value of 
 * zero indicates water. A pond is a region of water connected vertically, horizontally or diagonally. The size of the pond is the total number of
 * connected water cells. Write a method to compute the sizes of the all ponds in the matrix.
 */

import java.util.*;

public class PondSizes {
	List<Integer> pondSizes = new ArrayList<Integer>();
	
	public void computePondSizes(int[][] landMass) {
		
		//When water is encountered call function to compute the size of the pond
		// Idea: DFS
		for(int r=0;r<landMass.length;r++) {
			for(int c=0;c<landMass[0].length;c++) {
				if(landMass[r][c] == 0)
					pondSizes.add(computeSize(landMass,r,c));
			}
		}
	}
	
	public int computeSize(int[][] landMass, int r,int c) {
		if(r>=0 && c>=0 && r<landMass.length && c< landMass[0].length && landMass[r][c] == 0) {
			int size = 1;
			landMass[r][c] = -1; // Mark as visited by setting -1
			
			//Check for all surrounding cells 8 directionally
			for(int dr=r-1;dr<=r+1;dr++) {
				for(int dc=c-1;dc<=c+1;dc++) {
					size += computeSize(landMass,dr,dc);
				}
			}
			
			return size;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		PondSizes object = new PondSizes();
		
		//TestCase
		int[][] landMass = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
		object.computePondSizes(landMass);
		for(Integer p:object.pondSizes)
			System.out.println(p);
	}
}
