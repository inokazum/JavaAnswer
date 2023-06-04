package kennsyuu;

//演習1-2-①
//渡した文字列の配列をカンマ区切りの文字として返却するメソッド
public class Ensyuu1_2_1 {
	//文字列を分割する記号設定
	private static final String COMMA = ",";
	public static void main(String[] args) {
		// 入力値チェック
		if(args.length == 0) {
			System.err.println("引数を１つ以上にしてください。");
			System.exit(1);//異常終了
		}
		System.out.println(getCsvString(args));
		System.exit(0);//正常終了
	}
	public static String getCsvString(String[] strs) {
		String str = String.join(COMMA, strs);//配列strを","で区切り文字列に変換
		return(str);
	}
}


//引数 → 結果
//Soccer Baseball Tennis → Soccer,Baseball,Tennis
//Soccer → Soccer
//引数なし → 引数を１つ以上にしてください。