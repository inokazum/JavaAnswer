package kennsyuu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Pattern;

//演習1-1-③
//渡された2つの日付(Date)の大きい値から小さい値を引き、秒で返却するメソッド
public class Ensyuu1_1_3 {
	// 引数を変更する形式の設定
	private static final String DATE_FORMAT1 = "yyyy/MM/dd_HH:mm:ss";
	private static final String DATE_FORMAT2 = "yyyy/MM/dd";
	//表現方法の設定
	private static final String DATE_CHECK = "^[0-9]{4}/[0-9]{2}/[0-9]{2}_([01][0-9]||2[0-3]):[0-5][0-9]:[0-5][0-9]$";
	
	public static void main(String[] args){
		// 入力値チェック
		boolean isFormatMatch1 = false;
		boolean isFormatMatch2 = false;
		if(args.length != 2) {//引数が２つではない
			System.err.println("２つの日付を半角数字でyyyy/MM/dd_HH:mm:ss形式で入力してください。");
			System.exit(1);//異常終了
		}
		Pattern pattern = Pattern.compile(DATE_CHECK);//引数が条件に合っているか判定
		isFormatMatch1 = pattern.matcher(args[0]).matches();//条件一致したらtrue
		isFormatMatch2 = pattern.matcher(args[1]).matches();//条件一致したらtrue
		
		if(!isFormatMatch1 | !isFormatMatch2) {//引数どちらか一方でも条件不一致の場合
			System.err.println("入力した値のどちらかもしくは両方の形式が間違っています。");
			System.err.println("半角数字でyyyy/MM/dd_HH:mm:ss形式で入力してください。");
			System.exit(1);//異常終了
		}
		String day1 = args[0].substring(0, 10);//yyyy/MM/ddの部分を取り出す
		String day2 = args[1].substring(0, 10);//yyyy/MM/ddの部分を取り出す
		boolean isDateMatch1 = datecheck(day1);// 日付チェック
		boolean isDateMatch2 = datecheck(day2);// 日付チェック
		if(!isDateMatch1 | !isDateMatch2) {//引数どちらか一方でも条件不一致の場合(カレンダーに存在していない)
			System.err.println("入力した日付のどちらかもしくは両方の存在しません。");
			System.err.println("存在する日付を入力してください。");
			System.exit(1);//異常終了
		}
		try {
			Date date1 = getDate(args[0]);//引数(YYYY/MM/DD/hh/mm/ss)をDate型に変換して返却するメソッド
			Date date2 = getDate(args[1]);//引数(YYYY/MM/DD/hh/mm/ss)をDate型に変換して返却するメソッド
			System.out.println(getDateDiff(date1, date2));
			System.exit(0);//正常終了
		} catch (ParseException e) {
			System.err.println("値が変更されている。");
			e.getStackTrace();
			System.exit(1);//異常終了
		} catch (IllegalArgumentException e) {
			System.err.println("フォーマットが変更されている。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	
	public static boolean datecheck(String str){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT2);
			sdf.setLenient(false);
			sdf.parse(str);
			return true;
		}catch(ParseException ex){
			return false;
		}
	}

	public static Date getDate(String str) throws ParseException, IllegalArgumentException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT1);//引数とDate型とで対応している場所の指定
		Date date = dateFormat.parse(str);//文字列(String型)をDate型に変換
		return(date);
	}
	
	public static long getDateDiff(Date date1, Date date2) {
		LocalDateTime dt1 = LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault());
		LocalDateTime dt2 = LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault());
		long diff = ChronoUnit.SECONDS.between(dt1,dt2);
		return Math.abs(diff);
	}
}

//引数 → 結果
//2021/06/14_23:59:59 2021/06/15_00:00:00 → 1
//2021/06/14_11:15:59 2021/06/14_11:16:00 → 1
