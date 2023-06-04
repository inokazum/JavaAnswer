package kennsyuu;

import java.util.regex.Pattern;

//演習1-4-③
//渡した2つの数字で割り算を行い、端数は四捨五入して値を返すメソッド
public class Ensyuu1_4_3 {
	
	private static final int ARGS_LIMIT = 2;//引数の数指定
	private static final String NUMBER = "^-?[1-9１-９][0-9０-９]{0,}|[0０]$";//整数の正規表現
	
	public static void main(String[] args) {
		try{
			if(args == null || args.length != ARGS_LIMIT) {//引数が2つ以外外す
				throw new NullPointerException(); 
			}
			Pattern pattern = Pattern.compile(NUMBER);
			if(!pattern.matcher(args[0]).matches() || !pattern.matcher(args[1]).matches()){//引数のどちらかがフォーマット不一致の場合
				System.err.println("入力値不正のためエラーが発生しました。");
				System.exit(1);//異常終了
			}
			System.out.println(getDividedValue (Long.parseLong(args[0]), Long.parseLong(args[1])));
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
			System.err.println("０で割っているか計算結果がオーバーフローしたためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	private static int getDividedValue (long data1, long data2 ){
		return Math.toIntExact(Math.round((double)data1 / (double)data2));
	}
}

//引数 → 結果
//2 1 → 2
//２ １ → 2
//-2 1 → -2
//2 -1 → -2
//-2 -1 → 2
//5 2 → 3
//0 1 → 0
//2 0 → 0で割っているか計算結果がオーバーフローしたためエラーが発生しました。
//2.0 1 → 入力値不正のためエラーが発生しました。
//2 1.0 → 入力値不正のためエラーが発生しました。
//A 1 → 入力値不正のためエラーが発生しました
//2 A → 入力値不正のためエラーが発生しました。
//"" 1 → 入力値不正のためエラーが発生しました。
//2 "" → 入力値不正のためエラーが発生しました。
//null 1 →入力値不正のためエラーが発生しました。
//2 null → 入力値不正のためエラーが発生しました。
//2147483647 1 → 2147483647
//2147483648 1 → ０で割っているか計算結果がオーバーフローしたためエラーが発生しました。
//2147483648 2 → 1073741824
//-2147483648 1 → -2147483648
//-2147483649 1 → ０で割っているか計算結果がオーバーフローしたためエラーが発生しました。
//-2147483649 2 → -1073741824
//9223372036854775807 1 → ０で割っているか計算結果がオーバーフローしたためエラーが発生しました。
//9223372036854775807 4294967298 → 2147483647
//9223372036854775807 4294967297 → ０で割っているか計算結果がオーバーフローしたためエラーが発生しました。
//9223372036854775808 1 → 変換ができないためエラーが発生しました。
//9223372036854775808 4294967298 → 変換ができないためエラーが発生しました。
//-9223372036854775808 1 → ０で割っているか計算結果がオーバーフローしたためエラーが発生しました。
//-9223372036854775808 4294967295 → -2147483648
//-9223372036854775808 4294967294 → ０で割っているか計算結果がオーバーフローしたためエラーが発生しました。
//-9223372036854775809 1 → 変換ができないためエラーが発生しました。
//-9223372036854775809 4294967295 → 変換ができないためエラーが発生しました。
//引数なし → 入力値不正のためエラーが発生しました。
//2 1 5 → 入力値不正のためエラーが発生しました。