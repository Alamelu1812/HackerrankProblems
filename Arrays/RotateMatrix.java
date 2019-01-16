
public class RotateMatrix {
	
	public void rotateMatrix(int[][] nums) {

		if(nums == null || nums.length == 0 || nums.length != nums[0].length)
			return ;
		
		int n = nums.length;
		for(int layer = 0;layer < n/2; layer++) {
			int first = layer;
			int last = n - layer - 1;

			for(int i = first;i <last;i++) {
				
				int offset = i - first;	
				
				//Store top element
				int temp = nums[first][i];
			
				//Replace top left with bottom left
				nums[first][i] = nums[last-offset][first];
				
				//Replace bottom left with bottom right
				nums[last-offset][first] = nums[last][last-offset];
				
				//Replace bottom right with top right
				nums[last][last-offset] = nums[i][last];
				
				//Replace top right with top left
				nums[i][last] = temp;
				
				
			}
		}
	}
	
	public static void main(String[] args) {
		RotateMatrix object = new RotateMatrix();
		
		int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		//Display Input
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums[0].length;j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
		
		//Call object
		object.rotateMatrix(nums);
		System.out.println();
		
		//Display Output
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums[0].length;j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
	}

}
