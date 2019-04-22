package apperence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.regex.*;

class BackgroundPanel extends JPanel{
    private static final long serialVersionUID = -6352788025440244338L;
    private Image image = (Image) new ImageIcon("C:\\Users\\13055\\Desktop\\1.png").getImage();
    protected void paintComponent(Graphics2D g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    }

public class View {
    private JPanel panel1;
    private JPanel p1;
    private JRadioButton 深度过滤RadioButton;
    private JRadioButton 不过滤RadioButton;
    private JRadioButton 普通过滤RadioButton;
    private JTextField startTime;
    private JTextField endTime;
    private JTextField awardCount;
    private JButton 确定Button;
    private JTextArea result;
    private JRadioButton 我要换组RadioButton;
    private JRadioButton 我爱软工实践RadioButton;
    private JRadioButton 我要红包RadioButton;
    private JLabel error;
    private ButtonGroup rg=new ButtonGroup();
    private ButtonGroup rg1=new ButtonGroup();

    public View() {

        result.setColumns(30);
        result.setRows(5);
        rg.add(深度过滤RadioButton);
        rg.add(不过滤RadioButton);
        rg.add(普通过滤RadioButton);
        rg1.add(我要换组RadioButton);
        rg1.add(我爱软工实践RadioButton);
        rg1.add(我要红包RadioButton);

        确定Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取点击的单选框文本（过滤方式）
                String filerWay = null;//过滤方式
                Enumeration<AbstractButton> modelBtns=rg.getElements();
                while (modelBtns.hasMoreElements()) {
                    AbstractButton modelbtn = modelBtns.nextElement();
                    if(modelbtn.isSelected()){
                        filerWay=modelbtn.getText();
                        break;
                    }
                }
                //获取点击的单选框文本本（抽奖关键词）
                String kword = null;//抽奖关键词
                Enumeration<AbstractButton> modelBtns1=rg1.getElements();
                while (modelBtns.hasMoreElements()) {
                    AbstractButton modelbtn = modelBtns.nextElement();
                    if(modelbtn.isSelected()){
                        kword=modelbtn.getText();
                        break;
                    }
                }
                // String stime=startTime.getText();//抽奖开始时间
                String etime=endTime.getText();//抽奖结束时间
                String stime=startTime.getText();
                String acount=awardCount.getText();//奖品数量
                String pattern = "\\d\\d\\d\\d-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d";//判断是否为时间的正则表达式
                Pattern pattern1 = Pattern.compile("^[-\\+]?[\\d]*$");//判断是否为整数的正则表达式
                boolean  isDigit = pattern1.matcher(acount).matches();
                boolean isMatch = Pattern.matches(pattern, stime);
                boolean isMatch1 = Pattern.matches(pattern, etime);
                if(!isMatch||!isMatch1||!isDigit){//输入时间格式错误
                    error.setText("输入格式输入错误");
                }
                else
                {
                    error.setText("");
                    if(filerWay.equals("深度过滤"))
                    {

                    }
                    else if(filerWay.equals("不过滤"))
                    {

                    }
                    else
                    {

                    }

                }

                result.setText("abchsbdvdshhhhhhhhhhhhhhhhhhhhhhhhjv");

            }
        });
    }
    public static void setBackground(JFrame frame){
        JPanel imagePanel;
        ImageIcon background= new ImageIcon("D:\1.png");
        JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面

        // 把标签的大小位置设置为图片刚好填充整个面板

        label.setBounds(0, 0, background.getIconWidth(),

                background.getIconHeight());

        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明

        imagePanel = (JPanel) frame.getContentPane();

        imagePanel.setOpaque(false);

        // 内容窗格默认的布局管理器为BorderLayout

        imagePanel.setLayout(new FlowLayout());

        imagePanel.add(new JButton("测试按钮"));



        frame.getLayeredPane().setLayout(null);

        // 把背景图片添加到分层窗格的最底层作为背景

        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(background.getIconWidth(), background.getIconHeight());

        frame.setResizable(false);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("抽奖");
        setBackground(frame);
        JPanel panel =new View().panel1;
        frame.setContentPane(new View().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
