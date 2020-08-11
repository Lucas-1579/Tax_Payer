package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> payers = new ArrayList<>();

		System.out.print("Enter the number of taxpayers: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Taxpayer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			if (type == 'i') {
				System.out.print("Health expenditures: ");
				double healthExnpenditures = sc.nextDouble();
				payers.add(new Individual(name, anualIncome, healthExnpenditures));

			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				payers.add(new Company(name, anualIncome, numberOfEmployees));
			}
			System.out.println();
		}

		System.out.println("TAXES PAID:");
		for (TaxPayer x : payers) {
			System.out.println(x.getName() + ": $" + String.format("%.2f", x.tax()));
		}
		System.out.println();
		double sum = 0.0;
		for (TaxPayer x : payers) {
			sum += x.tax();
		}
		System.out.print("TOTAL TAXES : $" + String.format("%.2f", sum));

		sc.close();

	}

}
