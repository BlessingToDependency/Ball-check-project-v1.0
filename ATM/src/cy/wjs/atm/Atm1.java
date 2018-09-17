package cy.wjs.atm;

import java.util.Scanner;

public class Atm1
{

	public static void main(String[] args)
	{
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		String  a="ssss";
		boolean isLog = false;
		
		String Name1 = "123";
		
		String Pass1 = "123";
		while (isLog == false)
		{
			for (int i = 0; i < 3; i++)
			{
				System.out.print("璇疯緭鍏ヨ处鍙凤細");
				String Name = sc2.nextLine();
				System.out.print("璇疯緭鍏ュ瘑鐮侊細");
				String Pass = sc2.nextLine();

				if (Name.length() != 0 && Pass.length() != 0)
				{
					if (Name.equals(Name1) && Pass.equals(Pass1))
					{
						System.out.println("娆㈣繋浣跨敤");
						i = 3;
						isLog = true;
					} else
					{
						System.out.println("鎮ㄧ殑璐﹀彿鎴栧瘑鐮侀敊璇紝鎮ㄨ繕鍙互杈撳叆" + (2 - i) + "娆�");
						 if(i==2) {
							 System.out.println("鎮ㄨ緭鍏ョ殑娆℃暟宸叉弧");
							 System.exit(0);
						 }
					}

				} else
				{
					System.out.println("鎮ㄧ殑璐﹀彿鎴栧瘑鐮佷笉鑳戒负绌猴紝鎮ㄨ繕鍙互杈撳叆" + (2 - i) + "娆�");
					if(i==2) {System.out.println("鎮ㄨ緭鍏ョ殑娆℃暟宸叉弧");
						
						 System.exit(0);
					 }
				}

			}
		}
		Double qu=0.0;
		   
		   Double  sum=0.0;
			int cun=0;
			
		while (true)
		{

			System.out.println("1銆佽鎮ㄨ緭鍏ユ寚浠�1瀛樻锛�");
			System.out.println("2銆佽鎮ㄨ緭鍏ユ寚浠�2鍙栨");
			System.out.println("3銆佽鎮ㄨ緭鍏ユ寚浠�3鏌ョ湅浣欓");
			System.out.print("4銆佽杈撳叆鎸囦护4閫�鍑虹▼搴�");
			int y = sc1.nextInt();
			switch (y)
			{
			 
			case 1:
				System.out.println("璇锋偍杈撳叆瀛樻閲戦锛�");
				cun = sc1.nextInt();
				  
				 sum=sum+cun;
				System.out.println("鎮ㄥ凡瀛樺叆锛�"+sum+"鍏�");
				break;
			case 2:
				System.out.println("璇锋偍杈撳叆鍙栨閲戦锛�");
				 
				 if(sum>=qu) {
						System.out.println("璇疯緭鍏ユ偍鐨勫彇娆鹃噾棰濓細");
						qu = sc1.nextDouble();
					}else {
						System.out.println("鎮ㄧ殑璐︽埛浣欓涓嶈冻");
					}

				 
				 

				break;
			case 3:
				System.out.println("鐩墠浣犵殑璐﹀彿浣欓涓猴細"+(sum-qu));


				break;

			case 4:

				System.exit(0);

				break;

			}

		}

	}

}
