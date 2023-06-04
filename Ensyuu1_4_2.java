package kennsyuu;

import java.util.Random;

//演習1-4-②
//ランダムの0～999の値を返却するメソッド
public class Ensyuu1_4_2 {
	//範囲設定
	private static final int RAN_RANGE = 1000;
	public static void main(String[] args) {
		System.out.println(getRandomValue());
		System.exit(0);//正常終了
	}
	private static int getRandomValue() {
		Random random = new Random();
		return random.nextInt(RAN_RANGE);
	}
}

//引数 → 結果
//引数なし → 835
//1 → 757
//1 2 → 439
