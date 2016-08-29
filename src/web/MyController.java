package web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import Gao.GaosiUtil;
import Gao.Test;





@Controller
@RequestMapping("/My")
public class MyController {
	

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String add() {	
		return "login";
	}
	
	//修改过添加了文件上传
		@RequestMapping(value="login",method=RequestMethod.POST)
		public String add(@RequestParam("attach")MultipartFile attach,int text,Model model) throws IOException {	
			
			
			File file =new File("D:/image/1.jpg");
		
			String path = "D:/image/1.jpg";	
			model.addAttribute("pat", path);
			gaosi(text, path);//计算这里进行高斯操作		
			
			GaosiUtil.before = new StringBuffer();
			GaosiUtil.after =new StringBuffer();
			Test.aa = null;
			return "login";
		}
		
	public static void gaosi(int text,String path) throws IOException{
		
		Test.shu=text;
		Test.size=2*text+1;
		Test.aa = GaosiUtil.get2(GaosiUtil.get2DKernalData(Test.shu,1.5f));//计算高斯权重
		GaosiUtil.sum = 0;
        BufferedImage img = ImageIO.read(new File(path));
		
        System.out.println("图片加载成功");
        int height = img.getHeight();
        int width = img.getWidth();   
  
  
        int[][] matrix = new int[Test.size][Test.size];//基础矩阵
        int[] values = new int[Test.size*Test.size];
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {	
            	if(i<width*0.1||j<height*0.1||i>0.9*width||j>0.9*height){

                Test.readPixel(img, i, j, values);//获取周边点的值
                Test.fillMatrix(matrix, values);//将周边点个点的值存到缓存矩阵中               
                img.setRGB(i, j, Test.avgMatrix(matrix));
                }else{
                	 img.setRGB(i, j, Test.avgMatrix1(img,i,j));
                }
            }
        }
        
			ImageIO.write(img, "jpeg", new File("D:/image/2.jpg"));//保存在d盘为test1.jpeg文件
			Test.shu=0;
			Test.size=0;
			
	};
		
	

}
