package kennsyuu;

//演習1-2-②
//渡したカンマ区切りの文字列をカンマで分割して文字列の配列として返却するメソッド
public class Ensyuu1_2_2 {
	private static final String COMMA = ",";
	public static void main(String[] args) {
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
			String[] list = getValues(args[0]);
			for(int i = 0; i < list.length; i++){//リストを0番目から順番に表示する
				System.out.println(list[i]);
			}
			System.exit(0);//正常終了
		} catch (NullPointerException e) {
			System.err.println("e");
			e.getStackTrace();
			System.exit(1);//異常終了
		}
	}
	public static String[] getValues(String csv) throws NullPointerException{
		String[] csvs= csv.split(COMMA);//文字列を","で区切り文字配列に変換
		return csvs;
	}
}

//引数 → 結果
//Soccer,Baseball,Tennis → Soccer Baseball Tennis
//Soccer → Soccer カンマがないためそのままです。
//引数なし → 引数を１つにしてください。
//Soccer,Baseball,,Tennis → Soccer  Baseball   Tennis
//,Soccer,Baseball,Tennis →   Soccer Baseball Tennis
//,,, → (何も表示されない)