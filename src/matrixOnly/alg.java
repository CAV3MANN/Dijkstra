package matrixOnly;
import java.util.Scanner;

public class alg 
{
    /*
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[][] matrix = new int[9][9];
		int [] distance = new int[9];
		int[] visited = new int[9];
		int[] preD = new int[9];int min;
		int nextNode = 0;
		
		System.out.println("Enter your matrix: ");
		
		for(int i = 0; i < 9; i++)
		{
			visited[i] = 0;
			preD[i] = 0;
			
			for(int j = 0; j < 9; j++)
			{
				matrix[i][j] = scan.nextInt();
				if(matrix[i][j] == 0)
				{
					matrix[i][j] = 999;
				}
			}
		}
		distance = matrix[0];
		distance[0] = 0;
		visited[0] = 1;
		
		//start alg
		for(int i = 0; i < 9; i++)
		{
			min = 999;
			for(int j = 0; j < 9; j++)
			{
				if(min > distance[j] && visited[j] != 1)
				{
					min = distance[j];
					nextNode = j;
				}
			}
			visited[nextNode] = 1;
			//actual start of alg
			for(int c = 0; c < 9; c++)
			{
				if(visited[c] != 1)
				{
					if(min + matrix[nextNode][c] < distance[c])
					{
						distance[c] = min + matrix[nextNode][c];
						preD[c] = nextNode;
					}
				}
			}
		}
		for(int i = 0; i < 9; i++)
		{
			System.out.print("|" + distance[i]);
			
		}
		System.out.print("|");
	}
    */
}
