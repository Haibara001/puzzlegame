package com.itheima.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {

    //创建一个二维数组
    int[][] date = new int [4][4];
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initDate();

        //初始化图片
        initImage();

        //让界面显示出来
        this.setVisible(true);

    }


    private void initDate() {
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for(int i = 0;i<arr1.length;i++) {
            int index = r.nextInt(arr1.length);  //代表着生成一个范围在 0 ~ arr.length 内的任意正整数
            int temp = arr1[i];
            arr1[i] = arr1[index];
            arr1[index] = temp;
        }
        for(int i = 0;i<arr1.length;i++) {
            System.out.print(arr1[i] + " " );
        }
        System.out.println();
        for(int i = 0;i<arr1.length;i++) {
            date[i/4][i%4] = arr1[i];
        }
    }

    //初始化图片
    //添加照片的时候，就需要按照二维数组中管理的数据添加照片
    private void initImage() {


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取加载图片的位置
                int num = date[i][j];
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon("E:\\IDEA\\puzzlegame\\image\\animal\\animal1\\"+num+".jpg"));
                //指定照片的位置
                jLabel.setBounds(105 * j, 105*i, 105, 105);
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }



    }

    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象 （功能 关于我们）
        JMenu functionJMenu = new JMenu("菜单");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("微信");

        //将每一个选项下面的条目添加到选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("拼图小游戏");
        //设置页面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中方式，只有取消了才会按照XY轴的形态添加组件
        this.setLayout(null);
    }
}
