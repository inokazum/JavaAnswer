package kennsyuu;

//演習1-3-①
//文字列が数字(マイナス含む)だった場合、trueを返却するメソッド
public class Ensyuu1_3_1 {
	private static final String FORMAT = "^[-]?[0-9０-９]{1,}$";
	public static void main(String[] args) {
		//入力値チェック
		if(args.length != 1) {
			System.err.println("入力値がないまたは２つ以上のためエラーが発生しました。");
			System.err.println("入力値は１つにしてください。");
			System.exit(1);//異常終了
		}
		try {
			System.out.println(checkNumber(args[0]));
			System.exit(0);//正常終了
		} catch (IllegalArgumentException e) {
			System.err.println("フォーマットが変更されたためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		} catch (NullPointerException e) {
			System.err.println("入力値不正により、数字チェック処理にてエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	private static boolean checkNumber(String str) throws IllegalArgumentException, NullPointerException{
		return(str.matches(FORMAT));//文字列が数字(マイナス含む)か否かの判断
	}
}

//引数 → 結果
//123 → true
//-123 → true
//１２３ → true
//-１２３ → true
//AAA → false
//A1A2A → false
//A１A２A → false
//引数なし → 入力値がないまたは２つ以上のためエラーが発生しました。 入力値は１つにしてください。
//123 456 → 入力値がないまたは２つ以上のためエラーが発生しました。 入力値は１つにしてください。
//null → 入力値不正により、数字チェック処理にてエラーが発生しました。
