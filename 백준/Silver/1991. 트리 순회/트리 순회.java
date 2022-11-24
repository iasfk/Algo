
import java.util.Scanner;

public class Main {
	
	static class Node {
		private char data;
		private Node left, right;
		
		public Node(char data)
		{
			this.data = data;
		}
		public char getData()
		{
			return data;
		}
	}

	static class Tree {
		Node root; 
		void add(char data, char l_data, char r_data)
		{
			if( root == null)
			{
				root = new Node(data);
				if(l_data != '.')
					root.left = new Node(l_data);
				if(r_data != '.')
					root.right = new Node(r_data);
			}
			else 
				search(root, data, l_data, r_data);
		}
		
		void search(Node curNode, char data, char l_data, char r_data)
		{
			
			if(curNode == null) return;
			else if(curNode.data == data) 
			{
				 
				if(l_data != '.')
					curNode.left = new Node(l_data);
				if(r_data != '.')
					curNode.right = new Node(r_data);
			}
			else 
			{
				search(curNode.left, data, l_data, r_data);
				search(curNode.right, data, l_data, r_data);
			}
			
		}
		
		void  preorder(Node curNode)  
		{
			System.out.print(curNode.getData());
			if(curNode.left != null) preorder(curNode.left);
			if(curNode.right != null) preorder(curNode.right);
		}
		
		void  inorder(Node curNode) 
		{
			if(curNode.left != null) inorder(curNode.left);
			System.out.print(curNode.getData());
			if(curNode.right != null) inorder(curNode.right);
		}
		
		void  postorder(Node curNode)
		{
			if(curNode.left != null) postorder(curNode.left);
			if(curNode.right != null) postorder(curNode.right);
			System.out.print(curNode.getData());
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Tree tree = new Tree();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++)
		{
			String data = sc.next();
			String ld = sc.next();
			String rd = sc.next();
			
			tree.add(data.charAt(0),ld.charAt(0),rd.charAt(0));
		}
		
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		
		sc.close();
	}

}


