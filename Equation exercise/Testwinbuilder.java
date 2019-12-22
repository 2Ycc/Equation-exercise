package construction_6_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import ExerciseTest.ExerciseIOException;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;

public class Testwinbuilder extends JFrame {
	private static final long serialVersionUID = 1L;
	private final static int MAX_EQUATION_NUM = 30;
	private static BinaryEquation res[] = new BinaryEquation[MAX_EQUATION_NUM]; // 创建存储算式的数组
	private JTextField dengyu[] = new JTextField[MAX_EQUATION_NUM]; // 实例化TextField类的对象，显示出“=”号
	private JTextField textField[] = new JTextField[MAX_EQUATION_NUM]; // 实例化TextField类的对象，显示算式
	private JTextField ans[] = new JTextField[MAX_EQUATION_NUM]; // 实例化TextField类的对象，显示答案
	private JTextArea tarea = new JTextArea();
	private JPanel contentPane;
	private int correctNum = 0;
	private int errorNum = 0;
	private String correctRate = "0.00";
	private String errorRate = "0.00";
	Exercise equation = new Exercise();
	
	
	
	// 更新题目完成情况文本域
	public void textArea() {
    	tarea.setText("  统计信息：\n\n" + "  总题数： " + MAX_EQUATION_NUM 
				+ "        正确题数 ：" + correctNum + "             错误题数： " + errorNum + '\n'  
				+ "                                正确率： " + correctRate+"%" + "       错误率： " + errorRate+"%   ");	
	}
	
	// 初始化题目完成情况文本域
	public void initialTextArea() {
		tarea.setText("  统计信息：\n\n" + "  总题数： " + 30 
				+ "        正确题数 ：" + 0 + "                 错误题数： " + 0 + '\n'  
				+ "                                正确率： " + "0.00%" + "           错误率： " +"0.00%   ");
	}
	
	// 导入文件
	private void impExercise() {
		//导入题目
		JFileChooser jfc = new JFileChooser();//新建一个文件选择器
		jfc.showOpenDialog(null);//设置参数的值可以改变文件选择器在屏幕上的弹出位置
		File file = jfc.getSelectedFile();
		try {
			res = Exercise.loadObject(file.getAbsolutePath());
			JOptionPane.showMessageDialog(null, "导入题目成功！"
					,"提示",JOptionPane.INFORMATION_MESSAGE);
			openEquationFile();//显示算式
			initialTextArea();//初始化题目完成情况文本域
		}catch(NullPointerException npe) {
			
		}catch(ExerciseIOException e) {
			JOptionPane.showMessageDialog(null, "导入题目失败，可能是因为选择了错误的文件",
					"错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// 导出题目
	private void expExercise() {	
		//导出题目
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();
		try {
			equation.saveObject(file.getAbsolutePath(), res);
			//把这题目导出到文件里面
			JOptionPane.showMessageDialog(null, "导出题目成功！"
					,"提示",JOptionPane.INFORMATION_MESSAGE);
		}catch(NullPointerException npe) {
			npe.printStackTrace();
		}catch(ExerciseIOException e) {
			JOptionPane.showMessageDialog(null, "导出题目失败，可能是因为选择了错误的文件",
					"错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// 显示答案
	public void displayAns() {
		for(int i=0; i<MAX_EQUATION_NUM; i++) {// 将此文本组件显示的文本设置为算式
			ans[i].setText( String.valueOf(res[i].getValue()).trim() );
		}  
	}
	
	// 清空答案
	public void clearAns() {
		for(int i=0; i<MAX_EQUATION_NUM; i++) {// 将此文本组件显示的文本设置为算式
			ans[i].setText(null);
			ans[i].setBackground(Color.white);
		}
		initialTextArea(); // 初始化算式清空文本域
	}
	
	// 提交答案并判断，通过背景颜色进行反馈。绿色正确，红色错误
	public void submintAns() {
		int count = 0; // 定义计数器，记录正确的题目数量
		for(int i=0; i<textField.length; i++) {// 将此文本组件显示的文本设置为算式
			ans[i].setText( ans[i].getText().trim() ); // 去除用户输入得到空格
			res[i].setValue_User( ans[i].getText() ); // 将用户填写的答案赋于对象（以便保存）
    		String answer = ans[i].getText().trim();
    		String result = String.valueOf(res[i].getValue());
    		if( answer.contentEquals(result)) {
    			ans[i].setBackground(Color.green);
    			count++;
    		}
    		else 
    			ans[i].setBackground(Color.red);
		}
		correctNum = count;
		errorNum = MAX_EQUATION_NUM - this.correctNum;
		correctRate = String.format("%.2f", 100*(float)correctNum/(float)MAX_EQUATION_NUM);
		errorRate = String.format("%.2f", 100*(float)errorNum/(float)MAX_EQUATION_NUM);
		textArea();
	}
	
	// 单击“打开”按钮时不产生新的算式，读取存储算式文件中的算式
	public void openEquationFile() {
    	for(int i=0; i<textField.length; i++) {// 将此文本组件显示的文本设置为算式
    		ans[i].setText(res[i].getValue_User().trim()); // 初始化答案，从文件中读出保存前用户保存的答案
    		ans[i].setBackground(Color.white); // 初始化答案
			textField[i].setText(res[i].toString()); // 将此文本组件显示的文本设置为算式
		}
	}
	
	// 显示算式
	public void displayEquation() {
		try {
			res = equation.getEquations();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	for(int i=0; i<textField.length; i++) {// 将此文本组件显示的文本设置为算式
    		ans[i].setText(""); // 初始化答案
    		ans[i].setBackground(Color.white); // 初始化答案
			textField[i].setText(res[i].toString().trim()); // 将此文本组件显示的文本设置为算式
		}
    	initialTextArea();//初始化题目完成情况文本域
	}
	
	// 构造函数
	public Testwinbuilder() {
		
		setTitle("100\u4EE5\u5185\u7684\u53E3\u7B97\u7EC3\u4E60\u7A0B\u5E8F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 368);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JButton button1 = new JButton("\u6253\u5F00");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //打开文件
				impExercise(); // 打开文件
			}
		});
		button1.setFont(new Font("宋体", Font.BOLD, 13));
		mnNewMenu.add(button1);
		
		JButton button_1 = new JButton("\u4FDD\u5B58");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //保存文件
				expExercise(); // 保存文件
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 13));
		mnNewMenu.add(button_1);
		
		JMenu menu = new JMenu("\u7F16\u8F91");
		menu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(menu);
		
		JButton button_2 = new JButton("\u663E\u793A\u7B97\u5F0F");
		button_2.addActionListener(new ActionListener() { // 产生算式
            public void actionPerformed(ActionEvent e) {
            	displayEquation();
            }
         });
		button_2.setFont(new Font("宋体", Font.BOLD, 13));
		menu.add(button_2);
		
		// 显示答案
		JButton button3 = new JButton("\u6b63\u786e\u7b54\u6848");
		button3.addActionListener(new ActionListener() { // 显示答案
            public void actionPerformed(ActionEvent e) {
            	displayAns();
            }
         });
		button3.setFont(new Font("宋体", Font.BOLD, 13));
		menu.add(button3);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		// 打开文件
		JButton btnNewButton = new JButton("\u6253\u5F00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				impExercise(); 
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
		toolBar.add(btnNewButton);
		
		// 保存文件
		JButton btnNewButton_1 = new JButton("\u4FDD\u5B58");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				expExercise(); 
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 12));
		toolBar.add(btnNewButton_1);
		
		// 清空答案
		JButton btnButton = new JButton("\u6e05\u7a7a");
		btnButton.setBounds(0,0,10,10);
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAns(); 
			}
		});
		btnButton.setFont(new Font("宋体", Font.BOLD, 12));
		toolBar.add(btnButton);
		
		tarea.setBounds(230,20,22,22);
		initialTextArea();// 初始化算式计算情况文本域
    	tarea.setEditable(false);
		
		for(int i=0; i<MAX_EQUATION_NUM; i++) { // 循环设置
			textField[i] = new JTextField(4);	// 设置文本框为4列
			textField[i].setEditable(false);	// 设置文本框为不可编辑
			
			dengyu[i] = new JTextField(1);// 显示“=”
 			dengyu[i].setEditable(false);
 			dengyu[i].setText("=");
 			
 			ans[i] = new JTextField(2);// 显示答案框
		}
			
		// 产生算式
    	JButton button = new JButton("\u4ea7\u751f\u7b97\u5f0f"); // 按钮命名"产生算式"
    	button.addActionListener(new ActionListener() {// 产生算式
            public void actionPerformed(ActionEvent e) {
            	displayEquation(); // 显示算式
            }
         });
    	
    	
    	// 提交答案
    	JButton button4 = new JButton("\u63d0\u4ea4\u7b54\u6848"); // 按钮命名"提交答案"
    	button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	submintAns();
            }
         });
    	
    	Panel panel = new Panel(); // 创建Panel容器
  	 
    	 for(int i=0; i<textField.length; i++) {// 将算式文本域加入panel
 			panel.add(textField[i]);
 			panel.add(dengyu[i]);
 			panel.add(ans[i]);
 		}
    	 	 
        panel.add(button);// 将按钮加入此窗体
        panel.add(button4);// 将按钮加入此窗体
        panel.add(tarea);
        this.add(panel); // 将panel加入此窗体
		displayEquation();  // 打开程序时便显示算式
	}

}

