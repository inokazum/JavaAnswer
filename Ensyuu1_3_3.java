package kennsyuu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

//演習1-3-③
//渡した年月日の文字列(年、月、日は別の引数)が年月日として正しいかをチェックし、正しい場合はtrueを返すメソッド
public class Ensyuu1_3_3 {
	private static final int ARGS_LIMIT = 3;
	private static final String SLASH = "/";
	private static final String DATE_FORMAT = "yyyy/MM/dd";
	private static final String YEAR_CHECK = "^[0-9０-９]{1,4}$";
	private static final String MONTH_CHECK = "^[0-9０-９]{1,2}$";
	private static final String DAY_CHECK = "^[0-9０-９]{1,2}$";
	public static void main(String[] args) {
		try{
			if(args == null || args.length != ARGS_LIMIT) {
				throw new NullPointerException();
			}
			Pattern year = Pattern.compile(YEAR_CHECK);
			Pattern month = Pattern.compile(MONTH_CHECK);
			Pattern day = Pattern.compile(DAY_CHECK);
			if(!year.matcher(args[0]).matches() || !month.matcher(args[1]).matches() || !day.matcher(args[2]).matches()) {//引数どれかがフォーマット不一致の場合
				System.err.println("入力値不正のためエラーが発生しました。");
				System.exit(1);//異常終了
			}
			System.out.println(checkYMD(args[0], args[1], args[2]));
			System.exit(0);//正常終了
		}catch (NullPointerException e) {
			System.err.println("入力値不正のためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}catch (IllegalArgumentException e) {
			System.err.println("フォーマットが変更されたためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	private static boolean checkYMD(String year, String month, String day) throws IllegalArgumentException{
		String date = year + SLASH + month + SLASH + day;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		}catch(ParseException e){
			return false;
		}
	}
}

//引数 → 結果
//1 1 1 → true
//１ １ １ → true
//2020 2 29 → true
//2021 2 29 → false
//引数なし → 入力値不正のためエラーが発生しました。
//1 1 1 1 → 入力値不正のためエラーが発生しました。
//11111 1 1 → 入力値不正のためエラーが発生しました。
//1 111 1 → 入力値不正のためエラーが発生しました。
//1 1 111 → 入力値不正のためエラーが発生しました。
//A 1 1 → 入力値不正のためエラーが発生しました。
//1 A 1 → 入力値不正のためエラーが発生しました。。
//1 1 A → 入力値不正のためエラーが発生しました。
//"" 1 1 → 入力値不正のためエラーが発生しました。
//1 "" 1 → 入力値不正のためエラーが発生しました。
//1 1 "" → 入力値不正のためエラーが発生しました。
