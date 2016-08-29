package Gao;


public class GaosiUtil {
	//�����ܺ��� 
	public static float sum=0;
	public static   StringBuffer before = new StringBuffer();
	public static  StringBuffer after = new StringBuffer();
	public static float[][] get2DKernalData(int n, float sigma) {  
	    int size = 2*n +1;  
	    float sigma22 = 2*sigma*sigma;  
	    float sigma22PI = (float)Math.PI * sigma22;  
	    float[][] kernalData = new float[size][size];  	       
	    int row = 0;  
	    for(int i=-n; i<=n; i++) {  
	        int column = 0;  
	        for(int j=-n; j<=n; j++) {  
	            float xDistance = i*i;  
	            float yDistance = j*j;  
	            kernalData[row][column] = (float)Math.exp(-(xDistance + yDistance)/sigma22)/sigma22PI;  
	            column++;  
	        }  
	        row++;  
	    }  
	    System.out.println("��ά��˹���"); 
	    for(int i=0; i<size; i++) {  
	        for(int j=0; j<size; j++) {  
	        	sum +=kernalData[i][j];
	        	before = before.append("\t" +kernalData[i][j]);	          
	        }  	     
	       before = before.append("\n");	        
	    } 
	    System.out.println(before);
	    return kernalData;  
	}  
	public static float[][] get2(float[][] kernalData) { 
			System.out.println("��ֵ��"); 
			for(int i=0; i<kernalData.length; i++) {  
		        for(int j=0; j<kernalData.length; j++) {  
		        	kernalData[i][j] = kernalData[i][j]/sum;
		        	after = after.append("\t" +kernalData[i][j] );
		        }  		   
		        	after = after.append("\n");
		    }  
			System.out.println(after);
		    return kernalData;  		  
		}  	
}
