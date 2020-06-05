package GameLogic;/*
    @Auther TknHJQ
    @Create date 2020/5/18 - 16:07
    游戏地图
*/

import Enemies.Enemy;
import Towers.TeslaCoil.TeslaCoil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GameMap extends JPanel
{
	//地图大小，格数
	private int mapWidth;
	private int mapHeight;
	
	private GameWindow window;//窗口
	private GameJudger gameJudger;//裁判
	
	private Point wayPoint[];//敌人单位的移动路径点
	
	private int money = 1000;//玩家持有的金钱
	private JLabel moneyLabel;//玩家金钱的标签
	
	private Icon menu;//右侧的菜单栏
	private JLabel menuLabel;
	
	private TeslaCoil teslaCoil;
	
	private ArrayList<Enemy> enemyList;//存放敌人单位的列表
	private Iterator enemyIterator;
	
	GameMap(int mapWidth, int mapHeight, GameWindow window) throws IOException//构造函数，传参为地图大小
	{
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		this.gameJudger = window.getGameJudger();
		this.window = window;
		
		this.setBackground(new Color(205, 196, 201));
		
		this.menu = new ImageIcon("src\\Images\\Menu\\Menu.jpg");//载入图片
		
		this.setLayout(null);//禁用布局管理器
		
		//设置金钱显示器的参数并添加进JPanel
		this.moneyLabel = new JLabel(String.valueOf(money));
		this.moneyLabel.setSize(64, 16);
		this.moneyLabel.setLocation(805, 11);
		this.moneyLabel.setForeground(Color.yellow);
		this.add(moneyLabel);
		
		//添加右侧的菜单栏
		this.menuLabel = new JLabel(menu);
		this.menuLabel.setSize(360, 720);
		this.menuLabel.setLocation(640, 0);
		this.add(menuLabel);
		
		//初始化路径点。60+120*n即第n行/列的行/列中心，地图共5列5行。当前地图形状：
		//┏━┛
		//┗━━━
		wayPoint = new Point[]{new Point(960, 60 + 120 * 4), new Point(60 + 120 * 2, 60 + 120 * 4), new Point(60 + 120 * 2, 60 + 120 * 2), new Point(60 + 120 * 4, 60 + 120 * 2), new Point(60 + 120 * 4, -96)};
		
		teslaCoil = new TeslaCoil(new Point(100, 100));
		
		enemyList = new ArrayList<Enemy>();
		enemyIterator = enemyList.iterator();
		new EnemyManager(this, enemyList);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		teslaCoil.paint(g);
		
		for(int i = 0; i < enemyList.size(); i++)
		{
			enemyList.get(i).paint(g);
		}
	}
	
	public Point[] getWayPoint()
	{
		return wayPoint;
	}
	
	public GameJudger getGameJudger()
	{
		return gameJudger;
	}
	
	public GameWindow getWindow()
	{
		return window;
	}
}