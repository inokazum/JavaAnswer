package kennsyuu;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Ensyuu3 {
	//形式定義
	private static final String DATE_FORMAT = "yyyy年M月d日(E)";
	//定数定義
	private static final int SATURDAY = 6;
	private static final int SUNDAY = 0;
	private static final int MAX = 360;
	private static final int PAYDAY = 25;
	
	/**
	 *今後360回分の給料日を出力するメソッド
	 *
	 *@param なし
	 *@return 360回分の給料日
	 *@throws NullPointerException
	 */
	public static void main(String[] args) {
		try{
			payday();
			System.exit(0);
		}catch(NullPointerException e){
			System.err.println("値が存在しません。");
			System.exit(1);
		}
	}
	
	/**
	 *今後360回分の給料日を出力するメソッド
	 *
	 *@param なし
	 *@return count回目の給料日はyyyy年M月d日(E)です。
	 */
	private static void payday() {
		GregorianCalendar gc = new GregorianCalendar();
		int count = 1;
		while(count <= MAX) {
			int day = gc.get(Calendar.DATE);
			if(day == PAYDAY) {
				System.out.println(count + "回目の給料日は" + check(gc) + "です。");
				count++;
			}
			gc.add(Calendar.DATE, 1);
		}
	}
	
	/**
	 *給料日が平日に変換し形式変換するメソッド<br>
	 *
	 *給料日が土曜日なら1日前倒し<br>
	 *給料日が日曜日なら2日前倒し
	 *
	 *@param gc 給料日
	 *@return yyyy年M月d日(E)
	 */
	private static String check(GregorianCalendar gc) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		int week_name = gc.get(Calendar.DAY_OF_WEEK) - 1;
		Date date;
		if(week_name == SATURDAY) {
			gc.add(Calendar.DATE, -1);
			date = gc.getTime();
			gc.add(Calendar.DATE, 1);
		}else if (week_name == SUNDAY) {
			gc.add(Calendar.DATE, -2);
			date = gc.getTime();
			gc.add(Calendar.DATE, 2);
		}else {
			date = gc.getTime();
		}
		return dateFormat.format(date);
	}
}
