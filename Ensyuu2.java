package kennsyuu;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ensyuu2 {
	//カレンダーの年月日設定
	private static final int YEAR = 2019;
	private static final int MONTH = 0;//月は0から表すため

	//日付フォーマット定数の設定
	private static final String SLASH_DATE_FORMAT = "yyyy/M/d";
	private static final String KANJI_DATE_FORMAT = "yyyy年M月d日";
	private static final String NUMBER_DATE_FORMAT = "yyyyMMdd";
	private static final String PAYDATE_FORMAT = "MM月25日";
	private static final int PAYDATE = 25;

	//splitで使う正規表現の設定
	private static final String CUT = "";

	//メッセージの設定
	private static final String SPACE = "  ";
	private static final String[] WEEK_NAME = {"日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日" };
	private static final String PAYDAY = "は給料日です。";
	/**
	 *2019/1/1から2019/12/31までの表を出力するメソッド<br>
	 *
	 *1カラム目はyyyy/M/d形式に変更した日付を表示<br>
	 *2カラム目はyyyy年M月d形式に変更した日付を表示<br>
	 *3カラム目はyyyyMMdd形式に変更した日付を表示<br>
	 *4カラム目は3カラム目の数字をすべて足した数を表示<br>
	 *5カラム目は日付に対応した曜日を表示<br>
	 *6カラム目は日付が25日のときだけ"y月M日は給料日です。"と表示<br>
	 *
	 *@param なし
	 *@return 2019/1/1から2019/12/31までの表
	 *@throws NumberFormatException
	 */
	public static void main(String[] args) {
		SimpleDateFormat slashDateFormat = new SimpleDateFormat(SLASH_DATE_FORMAT);
		SimpleDateFormat kanjiDateFormat = new SimpleDateFormat(KANJI_DATE_FORMAT);
		SimpleDateFormat numberDateFormat = new SimpleDateFormat(NUMBER_DATE_FORMAT);
		try {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, YEAR);
			for (int day = 1; day <= cal.getActualMaximum(Calendar.DAY_OF_YEAR); day++) {
				GregorianCalendar gc = new GregorianCalendar(YEAR, MONTH, day);
				Date date = gc.getTime();
				int w = gc.get(Calendar.DAY_OF_WEEK) - 1;
				System.out.println(slashDateFormat.format(date) + SPACE + kanjiDateFormat.format(date) + SPACE + numberDateFormat.format(date) + SPACE+ sumDateNumber(numberDateFormat.format(date)) + SPACE + WEEK_NAME[w] + SPACE + payday(date, gc));
			}
			System.exit(0);
		} catch (NumberFormatException e) {
			System.err.println("Parse失敗しました。");
			System.exit(1);
		}
	}
	/**
	 *3カラム目の数字をすべて足すメソッド
	 *
	 *@param str 3カラム目の文字列
	 *@return すべて足した数
	 *@throws NumberFormatException
	 */
	private static int sumDateNumber(String str) {
		String[] number = str.split(CUT);
		int sum = 0;
		for (String num : number) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}
	/**
	 *給料日チェックメソッド
	 *
	 *@param date Date型の日付
	 *@param gc GregorianCalendar型の日付
	 *@return y月25日は給料日です。(日付が25日ならば)
	 *@return ""(日付が25日以外ならば)
	 */
	private static String payday(Date date, GregorianCalendar gc) {
		SimpleDateFormat paydateFormat = new SimpleDateFormat(PAYDATE_FORMAT);
		if (gc.get(Calendar.DAY_OF_MONTH) == PAYDATE) {
			return paydateFormat.format(date) + PAYDAY;
		}return "";
	}
}
