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
	
	//�޸Ĺ�������ļ��ϴ�
		@RequestMapping(value="login",method=RequestMethod.POST)
		public String add(@RequestParam("attach")MultipartFile attach,int text,Model model) throws IOException {	
			
			
			File file =new File("D:/image/1.jpg");
		
			String path = "D:/image/1.jpg";	
			model.addAttribute("pat", path);
			gaosi(text, path);//����������и�˹����		
			
			GaosiUtil.before = new StringBuffer();
			GaosiUtil.after =new StringBuffer();
			Test.aa = null;
			return "login";
		}
		
	public static void gaosi(int text,String path) throws IOException{
		
		Test.shu=text;
		Test.size=2*text+1;
		Test.aa = GaosiUtil.get2(GaosiUtil.get2DKernalData(Test.shu,1.5f));//�����˹Ȩ��
		GaosiUtil.sum = 0;
        BufferedImage img = ImageIO.read(new File(path));
		
        System.out.println("ͼƬ���سɹ�");
        int height = img.getHeight();
        int width = img.getWidth();   
  
  
        int[][] matrix = new int[Test.size][Test.size];//��������
        int[] values = new int[Test.size*Test.size];
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {	
            	if(i<width*0.1||j<height*0.1||i>0.9*width||j>0.9*height){

                Test.readPixel(img, i, j, values);//��ȡ�ܱߵ��ֵ
                Test.fillMatrix(matrix, values);//���ܱߵ�����ֵ�浽���������               
                img.setRGB(i, j, Test.avgMatrix(matrix));
                }else{
                	 img.setRGB(i, j, Test.avgMatrix1(img,i,j));
                }
            }
        }
        
			ImageIO.write(img, "jpeg", new File("D:/image/2.jpg"));//������d��Ϊtest1.jpeg�ļ�
			Test.shu=0;
			Test.size=0;
			
	};
		
	

}
