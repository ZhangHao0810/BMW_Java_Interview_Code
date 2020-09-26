/**
 * Administrator

 * 2020-9-19
 */
package 多线程;

/** 
 * @author ZhangHao: 
 * @date 创建时间:2020-9-19 15:57:24  
 * @version 1.0 
 
*/
/**
 * @author ZhangHao
 */
public class 指令重排 {

//	int a = 0;
//	boolean flag = false;
//
//	public void writer() {
//		// 下面两句执行顺序可能会在指令重排等场景下发生变化.
//		a = 1;
//		flag = true;
//	}
//
//	public void reader() {
//		if (flag) {
//			int i = a + 1;
//		}
//	}
	
	
	volatile int a = 0;//加了这个 volatile之后, 执行到这条语句 前面的语句都是执行完了的, 后面的一定是还没执行的, 不会出现重排的现象.
//	这就是内存屏障, 防止指令重排.
	boolean flag = false;

	public void writer() {
		// 下面两句执行顺序可能会在指令重排等场景下发生变化.
		a = 1;
		flag = true;
	}

	public void reader() {
		if (flag) {
			int i = a + 1;
		}
	}

}
