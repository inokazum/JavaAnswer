package kennsyuu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

//演習1-1-④
//渡された2つの日付(Date)の大きい値を、("YYYY/MM/DD")フォーマットの文字列で返却するメソッド
public class Ensyuu1_1_4 {
	// 引数を変更する形式の設定
	private static final String DATE_FORMAT = "yyyy/MM/dd";
	//引数の形式設定
	private static final String DATE_CHECK = "^[0-9]{4}/[0-9]{2}/[0-9]{2}$";
	
	public static void main(String[] args) {
		// 入力値チェック
		boolean result1 = false;
		boolean result2 = false;
		if(args.length != 2) {
			System.err.println("２つの日付を半角数字でyyyy/mm/dd形式で入力してください。");
			System.exit(1);
		}
		Pattern pattern = Pattern.compile(DATE_CHECK);//引数が条件に合っているか判定
		result1 = pattern.matcher(args[0]).matches();
		result2 = pattern.matcher(args[1]).matches();
		
		if(!result1 | !result2) {
			System.err.println("入力した値のどちらかもしくは両方の形式が間違っています。");
			System.err.println("半角数字でyyyy/mm/dd形式で入力してください。");
			System.exit(1);
		}
		try {
			Date date1 = getDate(args[0]);//引数(YYYY/MM/DD)をDate型に変換して返却するメソッド
			Date date2 = getDate(args[1]);//引数(YYYY/MM/DD)をDate型に変換して返却するメソッド
			System.out.println(getCompareDate(date1, date2));
			System.exit(0);//正常終了
		} catch (ParseException e) {//カレンダー上に存在しない
			System.err.println("入力した日付のどちらかもしくは両方の存在しません。");
			System.err.println("存在する日付を入力してください。");
			e.getStackTrace();
			System.exit(1);//異常終了
		} catch (IllegalArgumentException e) {
			System.err.println("フォーマットが変更されている。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	public static Date getDate(String str) throws ParseException, IllegalArgumentException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);//引数とDate型とで対応している場所の指定
		dateFormat.setLenient(false);//引数はカレンダー上に存在しているかの判定
		Date date = dateFormat.parse(str);//文字列(String型)をDate型に変換
		return(date);
	}
	//渡された2つの日付(Date)の大きい値を、("YYYY/MM/DD")フォーマットの文字列で返却するメソッド
	public static String getCompareDate(Date date1, Date date2) throws IllegalArgumentException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);//出力したい日付のフォーマットを指定
		Date strdate = null;
		if (date1.before(date2)) {//date1がdate2以前ならば
			strdate = date2;//Date型をString型に変換
		}else {//date2がdate1以前もしくは同じならば//出力したい日付のフォーマットを指定
			strdate = date1;//Date型をString型に変換
		}return(dateFormat.format(strdate).toString());
	}
}