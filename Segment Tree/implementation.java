import java.util.*;

public class segmentTree_implementation {

	public static void buildTree(int arr[], int tree[], int start, int end, int treeNode) {
		
		if(start==end) {
			tree[treeNode]=arr[start];
			return;
		}
		
		int mid = (start+end)/2;
		
		buildTree(arr,tree,start,mid,2*treeNode);
		buildTree(arr,tree,mid+1,end, 2*treeNode+1);
		
		tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
		
	}

	
	static void updateTree(int arr[], int tree[], int start, int end, int treeNode, int idx, int value) {
		
		if(start==end) {
			arr[idx]=value;
			tree[treeNode]=value;
			return;
		}
			
		
		int mid=(start+end)/2;
		if(idx>mid) {
			// move right
			updateTree(arr,tree,mid+1,end,2*treeNode+1,idx,value);
		}
		
		else {
			// move left
			updateTree(arr,tree,start,mid,2*treeNode,idx,value);
		}
		
		tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
		
	}
	
	
	static int query(int tree[], int start, int end, int treeNode, int left, int right) {
		
	  //out of range
		if(start>right || end<left) {
			return 0;
		}
		
	  //completely in a range
		if(start>=left && end<=right) {
			return tree[treeNode];
		}
		
	 // partially in a range
		int mid = (start+end)/2;
		int ans1 =  query(tree,start,mid,2*treeNode,left,right);
		int ans2 =  query(tree,mid+1,end,2*treeNode+1,left,right);
		
		return ans1+ans2;
		
	}
	
	
	public static void main(String[] args) {
	 int arr[]= {1,2,3,4,5,6,7,8,9};
	 int[] tree = new int[18];	
	 
	 buildTree(arr,tree,0,8,1);
	 
	 System.out.print("build Tree: ");
	 for(int i=1; i<18; i++) {
		System.out.print(tree[i]+" ");
	 }
	  System.out.println();
	  
	 updateTree(arr,tree,0,8,1,4,20);
	
	 System.out.print("after update: ");
	 for(int i=1; i<18; i++){
		 System.out.print(tree[i]+" ");
	 }
	 System.out.println();
	 
	 
	 int ans = query(tree,0,8,1,2,4);
	 System.out.print("Sum between given range: " + ans);
	
   }
}
