package kennsyuu;

import java.util.regex.Pattern;

//演習1-4-①
//小数点の値2つを引数とし、その小数部分を切り上げた整数値を掛けあわせた値を返却するメソッド
public class Ensyuu1_4_1 {
	private static final int ARGS_LIMIT = 2;//引数の数指定
	private static final String DEC = "^-?([1-9１-９][0-9０-９]{0,}|[0０])(.[0-9０-９]{1,})$";//小数の正規表現
	
	public static void main(String[] args) {
		try{
			if(args == null || args.length != ARGS_LIMIT) {//引数が2つ以外外す
				throw new NullPointerException();
			}
			Pattern pattern = Pattern.compile(DEC);
			if(!pattern.matcher(args[0]).matches() || !pattern.matcher(args[1]).matches()){//引数どれかがフォーマット不一致の場合
				System.err.println("入力値不正のためエラーが発生しました。");
				System.exit(1);//異常終了
			}
			System.out.println(getTimesValue(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
			System.exit(0);//正常終了
		}catch (NullPointerException e) {//引数が指定以外の場合・null値の場合のエラー処理
			System.err.println("入力値不正のためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}catch (NumberFormatException e) {//数値変換失敗エラー処理
			System.err.println("変換ができないためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	private static long getTimesValue(double data1, double data2) {
		return Math.multiplyExact((long)Math.ceil(data1), (long)Math.ceil(data2));
	}
}

//引数 → 結果
//0.1 0.009→ 1
//1.0 999.999→ 1000
//1 1.0 → 入力値不正のためエラーが発生しました。
//1.0 1 → 入力値不正のためエラーが発生しました。
//A 1.0 → 入力値不正のためエラーが発生しました。
//1.0 A → 入力値不正のためエラーが発生しました。
//"" 1.0 → 入力値不正のためエラーが発生しました。
//1.0 "" → 入力値不正のためエラーが発生しました。
//null 1.0 → 入力値不正のためエラーが発生しました。
//1.0 null → 入力値不正のためエラーが発生しました。
//引数なし → 入力値不正のためエラーが発生しました。
//1.0 1.0 1.0 → 入力値不正のためエラーが発生しました。
