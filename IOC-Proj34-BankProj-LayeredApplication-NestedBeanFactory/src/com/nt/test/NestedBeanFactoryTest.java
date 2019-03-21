package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.bo.BankBO;
import com.nt.controller.MainController;
import com.nt.vo.BankVO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		//get parent IOC
		DefaultListableBeanFactory pFactory=null;
		XmlBeanDefinitionReader reader1=null;
		pFactory=new DefaultListableBeanFactory();
		reader1=new XmlBeanDefinitionReader(pFactory);
		reader1.loadBeanDefinitions("com/nt/cfgs/business-beans.xml");
		
		//get child IOC 
		DefaultListableBeanFactory cFactory=null;
		XmlBeanDefinitionReader reader2=null;
		MainController controller=null;
		cFactory=new DefaultListableBeanFactory(pFactory);
		reader2=new XmlBeanDefinitionReader(cFactory);
		reader2.loadBeanDefinitions("com/nt/cfgs/presentation-beans.xml");
		controller=cFactory.getBean("controller",MainController.class);
		
		int key=0,accno=0,amount=0,srcAccno=0,targetAccno=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Money Transfer");
		System.out.println("Choice your option:::");
		key=sc.nextInt();
		try {
			switch (key) {
			case 1:
				System.out.println("Enter account Number");
				accno=sc.nextInt();
				System.out.println("Enter amount");
				amount=sc.nextInt();
				System.out.println(controller.deposit(accno, amount));
				break;

			case 2:
				System.out.println("Enter account Number");
				accno=sc.nextInt();
				System.out.println("Enter amount");
				amount=sc.nextInt();
				System.out.println(controller.withdraw(accno, amount));
				break;
			
			case 3:
				System.out.println("Enter source account Number");
				srcAccno=sc.nextInt();
				System.out.println("Enter target account Number");
				targetAccno=sc.nextInt();
				System.out.println("Enter amount");
				amount=sc.nextInt();
				System.out.println(controller.moneyTransfer(srcAccno, targetAccno, amount));
				break;
			default:
				System.out.println("Invalid Option");
				break;
			
			}
			List<BankVO> listVO=controller.getAccDetails("hyd");
			listVO.forEach(vo->{
				System.out.println(vo.getSno()+" "+vo.getAccno()+" "+vo.getHolderName()+" "+vo.getAddrs()+" "+vo.getBalance());
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
