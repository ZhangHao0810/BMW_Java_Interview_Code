/**
 * Administrator

 * 2020-9-19
 */
package ���߳�;

/** 
 * @author ZhangHao: 
 * @date ����ʱ��:2020-9-19 15:57:24  
 * @version 1.0 
 
*/
/**
 * @author ZhangHao
 */
public class ָ������ {

//	int a = 0;
//	boolean flag = false;
//
//	public void writer() {
//		// ��������ִ��˳����ܻ���ָ�����ŵȳ����·����仯.
//		a = 1;
//		flag = true;
//	}
//
//	public void reader() {
//		if (flag) {
//			int i = a + 1;
//		}
//	}
	
	
	volatile int a = 0;//������� volatile֮��, ִ�е�������� ǰ�����䶼��ִ�����˵�, �����һ���ǻ�ûִ�е�, ����������ŵ�����.
//	������ڴ�����, ��ָֹ������.
	boolean flag = false;

	public void writer() {
		// ��������ִ��˳����ܻ���ָ�����ŵȳ����·����仯.
		a = 1;
		flag = true;
	}

	public void reader() {
		if (flag) {
			int i = a + 1;
		}
	}

}
