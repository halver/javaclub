package timeSheat;

public class WorkDay {
	public static String day(){
		System.out.println("日付(yyyy/MM/dd)を入力してください");
		@SuppressWarnings("resource")
		String data = new java.util.Scanner(System.in).nextLine();
		while(!data.matches("^[0-9]{4}/[01]?[0-9]/[0123]?[0-9]$")){
			System.out.println("日付の入力形式が正しくありません。日付(yyyy/MM/dd)を入力しなおしてください。");
			data = new java.util.Scanner(System.in).nextLine();
		}
		return data;
	}
}
