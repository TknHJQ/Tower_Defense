package GameLogic;/*
    @Auther TknHJQ
    @Create date 2020/5/18 - 16:07
    游戏地图
*/

import Enemies.RhinoHeavyTank.RhinoHeavyTank;
import Towers.TeslaCoil.TeslaCoil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameMap extends JPanel
{
	//地图大小，格数
	private int mapWidth;
	private int mapHeight;
	
	private Point[] wayPoint;//敌人单位的移动路径点
	
	private TeslaCoil teslaCoil;
	private RhinoHeavyTank rhinoHeavyTank;
	
	GameMap(int mapWidth, int mapHeight) throws IOException//构造函数，传参为地图大小，格数
	{
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		
		this.setBackground(new Color(205, 196, 201));
		
		//初始化路径点。32+64*n即第n行/列的行/列中心，地图共16列9行。当前地图形状：
		//┏━┛
		//┗━━━
		wayPoint = new Point[]{new Point(1024, 32 + 64 * 7), new Point(32 + 64 * 2, 32 + 64 * 7), new Point()};
		
		teslaCoil = new TeslaCoil(new Point(100, 100));
		rhinoHeavyTank = new RhinoHeavyTank(new Point(0, 0));
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		teslaCoil.paint(g);
		rhinoHeavyTank.paint(g);
		
		try
		{
			synchronized(this)
			{
				wait(16);//每16毫秒刷新，60FPS
			}
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}