package GameLogic;/*
    @Auther TknHJQ
    @Create date 2020/6/5 - 12:24
*/

import Enemies.Enemy;
import Enemies.RhinoHeavyTank.RhinoHeavyTank;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class EnemyManager extends Thread
{
	private GameWindow win;
	private GameMap map;
	private ArrayList<Enemy> enemyList;
	
	public EnemyManager(GameMap map, ArrayList<Enemy> enemyList)
	{
		this.map = map;
		this.enemyList = enemyList;
		
		System.out.println("已构造：敌人管理器");
	}
	
	@Override
	public void run()
	{
		super.run();
		
		try
		{
			//生成3个犀牛坦克对象
			for(int i = 0; i < 3; i++)
			{
				if(win.getRunning())//判断游戏是否结束
					enemyList.add(new RhinoHeavyTank(map).startController(2000));
			}
			
			synchronized(this)
			{
				wait(10000);//两组单位的出生间隔
			}
			
			for(int i = 0; i < 6; i++)//生成6个犀牛坦克对象
			{
				if(win.getRunning())//判断游戏是否结束
					enemyList.add(new RhinoHeavyTank(map).startController(2000));
			}
			
		}catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "读取图片文件失败！", "奇怪的错误出现了！", JOptionPane.ERROR_MESSAGE);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void start(GameWindow win)
	{
		System.out.println("已启动：敌人管理器");
		
		this.win = win;
		
		super.start();
	}
}