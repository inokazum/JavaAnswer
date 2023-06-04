package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

//演習1-1-①
//渡された文字列(YYYY/MM/DD)をDate型に変換して返却するメソッド
public class test {
	// 引数を変更する形式の設定
	private static final String DATE_FORMAT = "yyyy/MM/dd";
	//引数の形式設定
	private static final String DATE_CHECK = "^[0-9]{4}/[0-9]{2}/[0-9]{2}$";
	
	public static void main(String[] args) {
		//引数の数チェック
		if(args.length != 1) {//引数が１つではない
			System.err.println("引数を１つにしてください。");
			System.exit(1);//異常終了
		}
		// 入力値チェック
		boolean isMatch = false;
		Pattern pattern = Pattern.compile(DATE_CHECK);//引数が条件に合っているか判定
		isMatch = pattern.matcher(args[0]).matches();//条件一致したらtrue
		
		if(!isMatch) {//条件一致
			System.err.println("半角数字でyyyy/mm/dd形式で入力してください。");
			System.exit(1);//異常終了
		}
		
		try {
			System.out.println(getDate(args[0]));
			System.exit(0);//正常終了
		} catch (ParseException e) {//カレンダー上に存在しない
			System.err.println("入力した日付は存在しません。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	public static Date getDate(String str) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);//引数のどこがDate型と一致しているか
		dateFormat.setLenient(false);//引数はカレンダー上に存在しているかの判定
		Date date = dateFormat.parse(str);//Date型に変換
		return date;
	}
}