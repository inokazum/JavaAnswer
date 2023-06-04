package kennsyuu;

import java.util.regex.Pattern;

//演習1-4-④
//小数点の値2つを引数とし、その小数部分を切り上げた整数値を掛けあわせた値を、16進数で返却するメソッド
public class Ensyuu1_4_4 {
	
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
		}catch (ArithmeticException e) {//数値変換失敗エラー処理
			System.err.println("オーバーフローしたためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	private static String getTimesValue(double data1, double data2){
		//return Integer.toHexString(Math.multiplyExact((int)Math.ceil(data1),(int)Math.ceil(data2)));//①
		
		return Integer.toHexString(Math.toIntExact(Math.multiplyExact((long)Math.ceil(data1),(long)Math.ceil(data2))));//②
	}
}


//引数 → 結果
//1.0 10.0→ a
//1.0 11.0→ b
//1.0 12.0→ c
//1.0 13.0→ d
//1.0 14.0→ e
//1.0 15.0→ f
//1.0 16.0→ 10
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
//2147483647.0 1.0 → 7fffffff
//2147483648.0 1.0 → オーバーフローしたためエラーが発生しました。
//-2147483648.0 1.0 → 80000000
//-2147483649.0 1.0 → オーバーフローしたためエラーが発生しました。
//-2147483648.0 -1.0 → オーバーフローしたためエラーが発生しました。