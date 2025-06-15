package com.banck.Operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.banck.Config.SessionProvider;
import com.banck.Entity.BanckAccount;

public class Operations {
	Scanner sc=new Scanner(System.in);
	
	
	public void addBanckAccount() {
		SessionProvider s=new SessionProvider();
		Session ses = s.seesionGiven();
		System.out.println("Enter the Account no :");
		int accNum = sc.nextInt();
		System.out.println("Enter thr account name :");
		String accName = sc.next();
		System.out.println("Enter the Account Balance :");
		double balance = sc.nextDouble();
		
		BanckAccount b=new BanckAccount(accNum, accName, balance);
		
		ses.save(b);
		
		ses.beginTransaction().commit();
		
	

	}
	
	public void showData() {
		SessionProvider s=new SessionProvider();
		Session ses = s.seesionGiven();
		System.out.println("Enter the Account no to show data :");
		int accno = sc.nextInt();
		BanckAccount banckAccount = ses.get(BanckAccount.class,accno);
		
		System.out.println(banckAccount);
		
		ses.beginTransaction().commit();
		
		
	}
	
	public void deleteData() {
		SessionProvider s=new SessionProvider();
		Session ses = s.seesionGiven();
		System.out.println("Enter the Account no to delete data :");
		int accno = sc.nextInt();
		BanckAccount account=ses.get(BanckAccount.class, accno);
		ses.delete(account);
		
		ses.beginTransaction().commit();
	}
	
	public void updateData() {
		SessionProvider s=new SessionProvider();
		Session ses = s.seesionGiven();

		System.out.println("Enter the Account no to update :");
		int accNum = sc.nextInt();
		System.out.println("Enter thr account name updated name :");
		String accName = sc.next();
		System.out.println("Enter the Account Balance updated balance :");
		double balance = sc.nextDouble();
		
		
		BanckAccount b=new BanckAccount(accNum, accName, balance);
		ses.update(b);
		ses.beginTransaction().commit();
	}
	
	public List<BanckAccount> getAccountsByIds(){
		ArrayList<Integer> accountNum= new ArrayList<Integer>();
		System.out.println("How many account no you want :");
		int count=sc.nextInt();
		for (int i = 1; i <=count; i++) {
			System.out.println("Enter account no :");
			int acc=sc.nextInt();
			accountNum.add(acc);
			
		}
		
		SessionProvider s=new SessionProvider();
		Session ses = s.seesionGiven();
		List<BanckAccount> acccounts = ses.byMultipleIds(BanckAccount.class).multiLoad(accountNum);
		
		
		
		
		return acccounts;
		
	}
	
	public List<BanckAccount> getAllAccounts(){
		SessionProvider sf=new SessionProvider();
		Session ses = sf.seesionGiven();
		Criteria criteria = ses.createCriteria(BanckAccount.class);
		List<BanckAccount> list = criteria.list();
		
		
		return list;
	}
	
	
	
	public void MenueBanck() {
		int a=1;
		while(a!=0) {
		System.out.println("Enter 1 for Create banck Account ");
		System.out.println("Enter 2 for delete banck Account ");
		System.out.println("Enter 3 for update banck Account ");
		System.out.println("Enter 4 for show banck Account ");
		System.out.println("Enter 5 for Multiple accounts get by ids :");
		System.out.println("Enter 6 for get All Accounts :");
		System.out.println("Enter 0  for exit :");
		
		int value = sc.nextInt();
		
		switch (value) {
		case 1: addBanckAccount();
			
			break;
			
		case 2: deleteData();
		break;
		case 3: updateData();
		break;
		case 4: showData();
		break;
		
		case 5:{ List<BanckAccount> accountsByIds = getAccountsByIds();
		        for (BanckAccount banckAccount : accountsByIds) {
					System.out.println(banckAccount);
				}
		}
		break;
		
		case 6:{ List<BanckAccount> accountsByIds = getAllAccounts();
        for (BanckAccount banckAccount : accountsByIds) {
			System.out.println(banckAccount);
		}
}
break;

		default: System.exit(0);
			break;
		}
		}
		
	}

}
