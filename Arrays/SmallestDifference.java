import java.util.Arrays;

public class SmallestDifference {
	
	public int computeSmallestDifference(int[] nums1, int[] nums2) {
		
		//Sort both arrays
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		//Initialize pointers to iterate through array
		//Initialize the answer to max value possible
		int nums1Pointer = 0, nums2Pointer = 0;
		int minDifference = Integer.MAX_VALUE;
		
		
		while(nums1Pointer < nums1.length && nums2Pointer < nums2.length) {
			//If the new difference is less than minimum difference, update the minimum difference
			if(Math.abs(nums1[nums1Pointer]-nums2[nums2Pointer]) < minDifference) {
				minDifference = Math.abs(nums1[nums1Pointer]-nums2[nums2Pointer]);
			}
			
			//Move the pointer in an array which has the lowest element
			if(nums1[nums1Pointer] <= nums2[nums2Pointer])
				nums1Pointer++;
			else
				nums2Pointer++;	
		}
		
		//Return minimum difference
		return minDifference;
	}
	
	public static void main(String[] args) {
		SmallestDifference object = new SmallestDifference();
		
		//TestCase
		int[] nums1 = {1,2,11,15};
		int[] nums2 = {4,12,19,23,127,275};
		System.out.println(object.computeSmallestDifference(nums1, nums2));
	}

}
