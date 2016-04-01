package _4matrixChainMultiplication;

public class MatrixChainMultiplication1 {
	public static int n;
	public String dataString = "30,35,15,45,10,20,25";
	public String[] dataSplit;
	public static int[][] position; //position[i][j]=k，表示子序列被分为i,...,k和k+1,...,j两组
    public static int[][] value;//value[i][j]表示子序列i，...，j相乘所需最小次数
    public static int[] dimentions; //数组i的维数是dimentions[i-1]行dimentions[i]列
	
	public MatrixChainMultiplication1(){
		// 初始化 分割字符串得到相乘矩阵
		this.dataSplit = this.dataString.split(",");
		this.n = dataSplit.length-1;
		this.position = new int[n+1][n+1];
		this.value = new int[n+1][n+1];
		this.dimentions = new int[n+1];
		
		for (int i = 0; i < n; i++) {
			this.dimentions[i]  = Integer.valueOf(this.dataSplit[i]);
		}
	}
	
	public static void main(String[] args)
	{
	      MatrixChainMultiplication1 matrixChainMultiplication1 = new MatrixChainMultiplication1();
	      
	       int i,j,L;
	 
	       for(j=0;j<n;j++)
	           for(i=1;i+j<=n;i++)
	               value[i][i+j]=MatrixChainMultiplication1.m_value(i,i+j,value,n+1,dimentions, position);
	 
	      
	    System.out.println("Show the position[i][j]:\n");       
	    for(i=1;i<=n;i++)
	    {
	           for   (j=1;j<=n;j++)
	               System.out.printf("%5d, ",position[i][j]);
	           System.out.println();
	    }
	     
	    System.out.println("Show the value[i][j]:\n");       
	    for(i=1;i<=n;i++)
	    {
	           for   (j=1;j<=n;j++)
	               System.out.printf("%7d,",value[i][j]);
	           System.out.println();
	    }
	 
	       System.out.println("\nThe path is:\n");
	       show(position,1,6);
	 
	}
	 
	public static int m_value(int i,int j,int value[][],int Num1,int dimentions[],int position[][])
	{
	       if(j==i)
	       {
	              position[i][j]=i;
	              return 0;
	       }
	             
	       int k,min;
	       min=dimentions[i-1]*dimentions[i]*dimentions[j]+value[i+1][j];
	       position[i][j]=i;
	       for(k=i+1;k<j;k++)
	           if(min>dimentions[i-1]*dimentions[k]*dimentions[j]+value[i][k]+value[k+1][j])
	           {
	               min=dimentions[i-1]*dimentions[k]*dimentions[j]+value[i][k]+value[k+1][j];
	               position[i][j]=k;
	              }
	      
	       return min;
	}
	      
	public static void show(int position[][],int i,int j)
	//用递归的方法去显示完整路径，调用的方式是 show(1，n）
	{
	       if (j<=i)
	           return;
	       int a;
	       a=position[i][j];
	       System.out.printf("position[%d][%d]=%d  \n",i,j,position[i][j]);
	       show(position,i,a);
	       show(position,a+1,j);
	}

}
