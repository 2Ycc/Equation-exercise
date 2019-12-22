package equationLast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ToFile
{
	public static Equation res[] = new Equation[60];
	// 将得到的60个算式存储到文件中去
		public void EquationOutputStream(BinaryEquation[] res2) throws IOException {
			FileOutputStream fileOut = new FileOutputStream("Equations1.ser");// 实例化FileOutputStream类，文件名为Equations.ser
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);// 实例化ObjectOutputStream类
			try {
	            out.writeObject(res2); // 将数组res写入文件
	            out.flush();	// 刷新该流的缓冲
	            out.close();	// 关闭连接
	            fileOut.close(); // 关闭连接            
	        } catch (IOException e) { // 异常处理
	            e.printStackTrace(); // 抛出异常
	        }
			System.out.println("------------------------------------------");
			System.out.println("Serialized data is saved in Equations.ser");
			System.out.println("------------------------------------------");
		}
		
		// 将得到的60个算式从文件中读出
		public void EquationInputStream() throws IOException {
			Equation res1[] = new Equation[60]; // 定义接收输入流的数组
			FileInputStream fileIn = new FileInputStream("Equations1.ser");// 实例化FileInputStream类，文件名为Equations.ser
	        ObjectInputStream in = new ObjectInputStream(fileIn); // 实例化ObjectInputStream类
	        try {
	            res1 = (Equation[]) in.readObject(); // 接收输入流中的数组对象
	            in.close();	// 关闭连接
	            fileIn.close();	// 关闭连接
	        } catch (IOException e) { // 异常处理
	            e.printStackTrace(); // 抛出异常
	        } catch (ClassNotFoundException c) { // 异常处理
	            c.printStackTrace(); // 抛出异常
	        }	
	        // 格式化输出
	        for(int i=0; i<res1.length; i++) {
	        	System.out.printf("%2d:%3d %c %2d=%3d\t\t",i+1,res1[i].getOperand1(),res1[i].getOperator(),res1[i].getOperand2(),res1[i].getResult());
	        	if((i+1)%5==0)
	        		System.out.println();
	        }
		}
	
}
