package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class test {
	// 引数を変更する形式設定
	private static final String DATE_FORMAT = "yyyy/MM/dd";
	
	//引数の形式設定
	private static final String DATE_CHECK = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
	
	public static void main(String[] args) {
		//引数の数チェック
		if(args.length != 1) {//引数が１つではない
			System.err.println("引数を１つにしてください。");
			System.exit(1);//異常終了
		}
		
		// 入力値チェック
		boolean isMatch = false; //初期値設定
		Pattern pattern = Pattern.compile(DATE_CHECK);//引数が"YYYY-MM-DDのフォーマットに合っているかを確認"
		isMatch = pattern.matcher(args[0]).matches();//条件一致したらtrue
		
		if(!isMatch) {//条件不一致
			System.err.println("半角数字でyyyy-mm-dd形式で入力してください。");
			System.exit(1);//異常終了
		}
		
		try {
			Date dateresult = datecast(args[0]);
			System.out.println(args[0]);
			System.out.println(dateresult);
			System.exit(0);//正常終了
		} catch (ParseException e) {//カレンダー上に存在しない
			System.err.println("入力した日付は存在しません。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	public static Date datecast(String str) throws ParseException {
		str = str.replace('-', '/');//"-"を、"/"に置き換え
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		dateFormat.setLenient(false);//引数はカレンダー上に存在しているかの判定
		Date date = dateFormat.parse(str);
		return date;
	}
}