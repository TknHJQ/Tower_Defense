package Towers;/*
    @Auther TknHJQ
    @Create date 2020/5/18 - 16:07
    塔的父类
*/

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tower
{
	private Point position;//位置
	private int size;//占地面积
	private int price;//价格
	private int powerRequired;//塔需要的电力
	private boolean isActivated;//是否启用
	Image image;//塔图标
	
	protected Tower(String imageURL)throws IOException//构造函数
	{
		image = ImageIO.read(new File(imageURL));//载入图片
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(image, 64, 32, 512, 512, null);
	}
}