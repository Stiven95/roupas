package br.com.fiap.mock;

import java.util.Random;

import br.com.fiap.entity.Customer;
import br.com.fiap.service.CustomerService;

public class CustomerMock {
	
	static String[] name = {"Stiven","Evair","Lucas","Amanda","Luzia","Raquel","Raphael","Adriano","Renata","Julio"};
	static String[] middlename = {"Oliveira","Sousa","Prado","Santos","Jardim","Vanini","Campos","Sales","Kremmer","Hubrecht"};
	static String[] lastname = {"Bezerra","Costa","Pereira","Rodrigues","Finn","Martin","Henckes","Cristensen","Rebel","Rabelo"};
	
	public static void populateCustomer(CustomerService customerService) {

		try {

			for (int i = 0; i < 100; i++) {
				Customer customer = new Customer();
				customer.setName(name[ran(9)] + " " + middlename[ran(9)] + " " + lastname[ran(9)]);
				customer.setCpfCnpj(cpf());
				
				customerService.createCustomer(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String cpf() {
		Random rand = new Random();
		long value = rand.nextInt()+10000000000L;
		return String.valueOf(value);
	}

	private static int ran(int p) {
		Random rand = new Random();
		int value = rand.nextInt(p);
		return value;
	}
}
