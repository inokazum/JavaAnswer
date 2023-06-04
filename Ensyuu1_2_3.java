package kennsyuu;

import java.util.regex.Pattern;

//演習1-2-③
//渡した数値を3桁毎のカンマ区切りの文字列に変換して返すメソッド
public class Ensyuu1_2_3 {
	//区切り文字カンマ設定
	private static final String COMMA = "%,d";
	//数字のみの正規表現
	private static final String ARGS_CHECK = "[0-9０-９]+";
	public static void main(String[] args) {
		//入力値チェック
		if(args.length != 1) {
			System.err.println("引数を１つにしてください。");
			System.exit(1);//異常終了
		}
		Pattern pattern = Pattern.compile(ARGS_CHECK);//引数が条件に合っているか判定
		boolean isFormatMatch = pattern.matcher(args[0]).matches();//条件一致したらtrue
		if(!isFormatMatch) {
			System.err.println("数字のみで入力してください。");
			System.exit(1);//異常終了
		}
		try {
			System.out.println(format(args[0]));
			System.exit(0);//正常終了
		} catch (NumberFormatException e) {
			System.err.println("e");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	public static String format(String str) throws NumberFormatException{
		return String.format(COMMA, Integer.parseInt(str));//int型に変換し3桁ごとにカンマで区切る
	}
}

//引数 → 結果
//12345678 → 12,345,678
//12 → Soccer カンマがないためそのままです。
//引数なし → 引数を１つにしてください。
//AAA → 数字のみで入力してください。
//123,456,78 → 数字のみで入力してください。
//１２３４５６７８ → 12,345,678
//１２ → 12