package application;

import entities.Contract;
import entities.Installment;
import serivce.ContractService;
import serivce.PaypalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Data: ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.print("Valor do contrato: ");
        Double totalValue = sc.nextDouble();
        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Entre numero de parcelas: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, n);

        System.out.println("\nParcelas: ");
        for (Installment installment : contract.getInstallment()){
            System.out.println(installment);
        }

        sc.close();
    }
}
