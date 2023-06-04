package kennsyuu;
//演習1-3-②
//渡した文字列をチェックし、文字長が8文字以内であればtrueを返すメソッド
public class Ensyuu1_3_2 {
	private static final int ARGS_LIMIT = 1;
	private static final int LEN_MAX = 8;
	public static void main(String[] args) {
		try {
			if(args == null || args.length != ARGS_LIMIT) {
				throw new NullPointerException();
			}
			System.out.println(checkLength(args[0]));
			System.exit(0);//正常終了
		}catch (NullPointerException e) {
			System.err.println("入力値不正のためエラーが発生しました。");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	private static boolean checkLength(String str) throws NullPointerException{
		return(str.length() <= LEN_MAX);
	}
}

//引数 → 結果
//12345678 → true
//123456789 → false
//ABCDEFGH → true
//ABCDEFGHI → false
//"" → true
//引数なし → 入力値不正のためエラーが発生しました。
//123 456 → 入力値不正のためエラーが発生しました。
