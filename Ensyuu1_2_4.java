package kennsyuu;

import java.util.Arrays;
import java.util.Collections;
//演習1-2-④
//渡したカンマ区切りの文字列をカンマで分割して降順で返却するメソッド
public class Ensyuu1_2_4 {
	//区切り文字カンマ設定
	private static final String COMMA = ",";
	public static void main(String[] args) {
		//入力値チェック
		if(args.length != 1) {
			System.err.println("引数を１つにしてください。");
			System.exit(1);//異常終了
		}
		if(args[0].indexOf(COMMA) == -1) {//文字列に","が存在しない場合
			System.out.println(args[0]);
			System.err.println("カンマがないためそのままです。");
			System.exit(1);//異常終了
		}
		try {
			System.out.println(getSortValues(args[0]));
			System.exit(0);//正常終了
		} catch (NullPointerException e) {
			System.err.println("e");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	public static String getSortValues(String str) throws NullPointerException{
		String[] num = str.split(COMMA);//文字列を","で区切り文字配列に変換
		Arrays.sort(num, Collections.reverseOrder());//降順に並び替え
		return String.join(COMMA, num);
	}
}

//引数 → 結果
//A,C,B → C,B,A
//A,CA,B,CC → CC,CA,B,A
//1,2,5,3,4 → 5,4,3,2,1
//1,10,2,4,3 → 4,3,2,10,1
//ABC → ABC カンマがないためそのままです。
//123 → 123 カンマがないためそのままです。
//,A,C,B → C,B,A,
//A,,C,B → C,B,A,
//引数なし → 引数を１つにしてください。
//1,B,3,C,2,A → C,B,A,3,2,1
