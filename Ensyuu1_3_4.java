package kennsyuu;

//演習1-3-④
//渡した文字列をチェックし、英数字のみであればtrueを返すメソッド
public class Ensyuu1_3_4 {
	private static final int ARGS_LIMIT = 1;
	private static final String FORMAT = "^[a-zA-Z0-9０-９]{1,}$";
	public static void main(String[] args) {
		try {
			if(args == null || args.length != ARGS_LIMIT) {
				throw new NullPointerException();
			}
			System.out.println(checkString(args[0]));
			System.exit(0);//正常終了
		}catch (NullPointerException e){
			System.err.println("入力値不正のためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
		catch (IllegalArgumentException e){
			System.err.println("フォーマットが変更されたためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	private static boolean checkString(String str) throws NullPointerException, IllegalArgumentException{
		return(str.matches(FORMAT));
	}
}

//引数 → 結果
//1 → true
//１２ → true
//a → true
//AB → true
//1２cD → true
//!! → false
//123!! → false
//引数なし → 入力値不正のためエラーが発生しました。
//123 456 → 入力値不正のためエラーが発生しました。
