package Gao;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;   
 
public class Test
{
	 public static float [][]aa;//计算高斯后的权重矩阵
	 public static int shu;//高斯模糊半径
	 public static int  size ;//数组大小	


 /**
     * 简单高斯模糊算法
     * 
     * @param args
     * @throws IOException [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
   
     

	public static void readPixel(BufferedImage img, int x, int y, int[] pixels)
    {//读取像素
        int xStart = x - shu;
        int yStart = y - shu;
        int current = 0;
        for (int i = xStart; i < size + xStart; i++)
        {
            for (int j = yStart; j < size + yStart; j++)
            {
                int tx = i;
                if (tx < 0)//处理边界情况左溢出
                {
                    tx = -tx;
                }
                else if (tx >= img.getWidth())//处理边界情况右溢出
                {
                    tx = x;
                }
                 
                int ty = j;
                if (ty < 0)
                {
                    ty = -ty;
                }
                else if (ty >= img.getHeight())
                {
                    ty = y;
                }
                pixels[current++] = img.getRGB(tx, ty);//获取
               
            }
        }
    }
     
    public static void fillMatrix(int[][] matrix, int... values)
    {
        int filled = 0;
        for (int i = 0; i < matrix.length; i++)
        {       
            for (int j = 0; j <size; j++)
            {         	
            	matrix[i][j] = values[filled++];
            }
        }
    }
     
    public static int avgMatrix(int[][] matrix)
    {	
       float r = 0;
       float g = 0;
       float b = 0;
        for (int i = 0; i < matrix.length; i++)
        {
         
            for (int j = 0; j <matrix.length; j++)
            {
   
                Color c = new Color(matrix[i][j]);            
                r += c.getRed()*aa[i][j];              
                g += c.getGreen()*aa[i][j];
                b += c.getBlue()*aa[i][j];
            }
          
        }

        return new Color((int)r, (int)g, (int)b).getRGB();
    }

	public static int avgMatrix1(BufferedImage img, int i, int j) {
	
    	return  new Color(img.getRGB(i,j)).getRGB();
		
	}
}