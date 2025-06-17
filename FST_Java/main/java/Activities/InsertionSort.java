package Activities;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,9,34,7,22};
		for(int i=1;i<arr.length;i++)
		{
			int key=arr[i];
			int j=i-1;
			while(j>=0 && key<arr[j])
			{
				arr[j+1]=arr[j];
				--j;
			}
			arr[j+1]=key;
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
