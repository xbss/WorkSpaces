package _01QuickSort;

public class test {
	// 快速排序的实现  
    public static void main(String[] args) {  
    	int length = (int)(Math.random() * 50);
    	
        int[] nums = new int[length];
        
        for (int i = 0; i < nums.length; i++)
        	nums[i] = (int)(Math.random() * 50);
        System.out.println("快速排序前：");
        for (int i = 0; i < nums.length; i++)
        	System.out.print(" " + nums[i]);
        System.out.println();
        
        System.out.println("快速排序过程：");
        QuickSort(nums, 0, nums.length-1);   
        
        System.out.println("快速排序后：");
        for (int i = 0; i < nums.length; i++)
        	System.out.print(" " + nums[i]);
    }  
	
    private static void QuickSort(int[] a, int l, int r) {
    	int s;
        if(l < r){
        	s = Partition(a,l,r);
        	
        	QuickSort(a, l, s - 1);
        	QuickSort(a, s + 1, r);
        }
        
        

    }

	private static int Partition(int[] a, int l, int r) {
		int p = a[l];
        int i = l;
        int j = r + 1;
        for (;;) {
            do {
                i++;
            } while (i <= r && a[i] < p);
            do {
                j--;
            } while (a[j] > p);
            if (i > j) {
                break;
            }
            swap(i,j,a);
        }
        swap(l,j,a);
        for (int k = 0; k < a.length; k++)
        	System.out.print(" " + a[k]);
        System.out.println();
		
		return j;
	}

	private static void swap(int i, int j, int[] a) {
		int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
		
	}
}
