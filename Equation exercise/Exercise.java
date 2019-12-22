package construction_6_gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Random;

import ExerciseTest.ExerciseIOException;

public class Exercise {
	private static final short OPERATION_NUMBER=30;// 定义最大算数式为60个
	private static int equCount = 0;// 当前已有算式的数量
	BinaryEquation res[] = new BinaryEquation[OPERATION_NUMBER]; // 定义数组存放BinaryEquation类的对象
	HashSet<BinaryEquation> hashSet = new HashSet<BinaryEquation>();// 存储算式的容器
	
	public static void equCountAdd() { // 进行算式数加一操作
		equCount++;					   // 当前算式数加一
	}
	public static void reSetCount() {
		equCount = 0;
	}
	public static int getEquCount() {
		return equCount;			   // 返回当前算式数量
	}
	
	// 判断加法算式结果是否大于100或小于0，是则返回false，否则返回true
	public boolean isValidAddEqu(BinaryEquation bop) {
		if (bop.getValue() >= 100 || bop.getValue() <= 0) 
			return false;
		else 
			return true;
	}
	
	public void saveObject(String filename, BinaryEquation[] res) throws ExerciseIOException{		
		//串行化存储对象
		FileOutputStream f = null;
		try {
			 f = new FileOutputStream(filename);
			 //可以传入一个字符串的文件地址,地址不为空时,自动为字符串创建File对象
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ObjectOutputStream s = null;
		try {
			 s = new ObjectOutputStream(f);
			 //定义ObjectOutputStream对象需要用一个FileOutputStream来构造文件字节输出流对象
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			s.writeObject(res);//向文件中输出算式
			s.flush();
			//刷新此输出流并强制写出所有缓冲的输出字节。
			//flush 的常规协定是：如果此输出流的实现已经缓冲了以前写入的任何字节，则调用此方法指示应将这些字节立即写入它们预期的目标。
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static BinaryEquation[] loadObject(String filename) throws ExerciseIOException{	
		//串行化载入对象
		FileInputStream in = null;
		try {
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectInputStream s = null;
		try {
			s = new ObjectInputStream(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BinaryEquation[] res = null;
		try {
			res = (BinaryEquation[]) s.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	// 产生算式，根据随机产生的1或0来判断产生加法或是减法
	public BinaryEquation genEquations() {
		int op;							// 判断数
		Random random = new Random();	
		op = random.nextInt(2);
		BinaryEquation bop;			
		if (op == 1) {
			bop = new AddEquation();	// 当op为1时bop为加法式对象
		} else {
			bop = new SubEquation();	// bop为减法式对象
		}
		return bop;						// 返回bop对象
	}
	
	public BinaryEquation[] getEquations() throws IOException {
		reSetCount();  // 每次执行此方法时便重置算式计数器
		hashSet = new HashSet<BinaryEquation>();// 存储算式的容器
		while (getEquCount() < OPERATION_NUMBER) { // 循环产生30个算式
			BinaryEquation bop = genEquations();// 随机返回一个算式
			if(!isValidAddEqu(bop))
				continue;
			if(hashSet.add(bop)) {	// 如果算式可以存入hashSet即当前产生的算式未重复
				res[getEquCount()] = bop; // 将算式存入数组
				equCountAdd();	// 当前算式数量加一	
			}
		}
		return res;
	}
	
}