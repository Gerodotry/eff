package org.example.sessions;

import org.example.entities.Customer;
import org.example.entities.InsuranceA;
import org.example.entities.InsuranceK;
import org.example.filters.InsuranceBFilter;
import org.example.filters.InsuranceAFilter;
import org.example.services.CustomerService;
import org.example.services.InsuranceAService;
import org.example.services.InsuranceBService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ConsoleMenu {
    private CustomerService customerService;
    private InsuranceAService insuranceAService;
    private InsuranceBService insuranceBService;
    private Scanner scanner;

    public ConsoleMenu() {
        this.disableLogging();
        this.customerService = new CustomerService();
        this.insuranceAService = new InsuranceAService();
        this.insuranceBService = new InsuranceBService();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("===== Main Menu =====");
            System.out.println("1. Customer Operations");
            System.out.println("2. InsuranceA Operations");
            System.out.println("3. InsuranceK Operations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = this.scanner.nextInt();
            this.scanner.nextLine();

            switch (choice) {
                case 1 -> this.customerMenu();
                case 2 -> this.insuranceAMenu();
                case 3 -> this.insuranceBMenu();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void customerMenu() {
        int choice;
        do {
            System.out.println("===== Customer Menu =====");
            System.out.println("1. Find Customer by ID");
            System.out.println("2. Find All Customers");
            System.out.println("3. Count All Customers");
            System.out.println("4. Save Customer");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Add InsuranceK to Customer");
            System.out.println("8. Remove InsuranceK from Customer");
            System.out.println("9. Add InsuranceA to Customer");
            System.out.println("10. Remove InsuranceA from Customer");
            System.out.println("11. Find All of DerativeB for Customer");
            System.out.println("12. Find All DerativeA for Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter customer ID: ");
                    long customerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer customer = this.customerService.findById(customerId);
                    if (customer != null) {
                        System.out.println("Customer found: " + customer.getName());
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 2 -> {
                    List<Customer> customers = this.customerService.findAll();
                    if (customers.isEmpty()) {
                        System.out.println("No customers");
                    } else {
                        for (Customer c : customers) {
                            System.out.println(c);
                        }
                    }
                }
                case 3 -> {
                    Long customerCount = this.customerService.countAll();
                    System.out.println("Total number of customers: " + customerCount);
                }
                case 4 -> {
                    System.out.println("Enter customer name:");
                    String name = this.scanner.nextLine();
                    if (name != null) {
                        this.customerService.saveCustomer(new Customer(name));
                    }
                    else {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter customer ID to update: ");
                    long updateCustomerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer updatedCustomer = this.customerService.findById(updateCustomerId);
                    if (updatedCustomer != null) {
                        System.out.println(updatedCustomer);
                        System.out.println("Enter updated customer name:");
                        String name = this.scanner.nextLine();
                        if (name != null) {
                            updatedCustomer.setName(name);
                            this.customerService.updateCustomer(updatedCustomer);
                        }
                        else {
                            System.out.println("Invalid input. Please try again.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter customer ID to delete: ");
                    long deleteCustomerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer deleteCustomer = this.customerService.findById(deleteCustomerId);
                    if (deleteCustomer != null) {
                        this.customerService.deleteCustomer(deleteCustomer);
                        System.out.println("Customer deleted.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 7 -> {
                    System.out.print("Enter customer ID to add InsuranceB: ");
                    long customerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer customer = this.customerService.findById(customerId);
                    if (customer != null) {
                        System.out.print("Enter InsuranceB ID to add: ");
                        long insuranceBId = this.scanner.nextInt();
                        this.scanner.nextLine();
                        InsuranceK insuranceK = this.insuranceBService.findById(insuranceBId);
                        if(insuranceK != null) {
                            this.customerService.addInsuranceB(customer, insuranceK);
                        } else {
                            System.out.println("insuranceB not found .");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 8 -> {
                    System.out.print("Enter customer ID to delete insuranceB: ");
                    long customerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer customer = this.customerService.findById(customerId);
                    if (customer != null) {
                        System.out.print("Enter insuranceB ID to delete: ");
                        long insuranceBId = this.scanner.nextInt();
                        this.scanner.nextLine();
                        InsuranceK insuranceK = this.insuranceBService.findById(insuranceBId);
                        if(insuranceK != null) {
                            this.customerService.removeInsuranceB(customer, insuranceK);
                        } else {
                            System.out.println("insuranceK not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 9 -> {
                    System.out.print("Enter customer ID to add insuranceA: ");
                    long customerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer customer = this.customerService.findById(customerId);
                    if (customer != null) {
                        System.out.print("Enter InsuranceA ID to add: ");
                        long insuranceAId = this.scanner.nextInt();
                        this.scanner.nextLine();
                        InsuranceA insuranceA = this.insuranceAService.findById(insuranceAId);
                        if(insuranceA != null) {
                            this.customerService.addInsuranceB(customer, insuranceA);
                        } else {
                            System.out.println("insuranceA not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 10 -> {
                    System.out.print("Enter customer ID to remove insuranceA: ");
                    long customerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer customer = this.customerService.findById(customerId);
                    if (customer != null) {
                        System.out.print("Enter insuranceA ID to remove: ");
                        long insuranceAId = this.scanner.nextInt();
                        this.scanner.nextLine();
                        InsuranceA insuranceA = this.insuranceAService.findById(insuranceAId);
                        if(insuranceA != null) {
                            this.customerService.removeInsuranceA(customer, insuranceA);
                        } else {
                            System.out.println("insuranceA not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 11 -> {
                    System.out.print("Enter customer ID to get their insuranceB: ");
                    long customerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer customer = this.customerService.findById(customerId);
                    if (customer != null) {
                        Set<InsuranceK> insuranceKS = customer.getRiffs();
                        double totalMonthlyCost = 0.0;
                        for (InsuranceK insuranceK : insuranceKS) {
                            totalMonthlyCost += insuranceK.getPricePerMonth();
                        }
                        System.out.println(totalMonthlyCost);
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 12 -> {
                    System.out.print("Enter customer ID to get their insuranceA: ");
                    long customerId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Customer customer = this.customerService.findById(customerId);
                    if (customer != null) {
                        Set<InsuranceA> insuranceA = customer.getInsuranceAs();
                        double totalMonth = 0.0;
                        for (InsuranceA insuranceAS : insuranceA) {
                            totalMonth += insuranceAS.getPricePerMonth();
                        }
                        System.out.println(totalMonth);
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 0 -> {
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }


    private void insuranceBMenu() {
        int choice;
        do {
            System.out.println("===== InsuranceK Menu =====");
            System.out.println("1. Find  InsuranceK by ID");
            System.out.println("2. Find All derativeB");
            System.out.println("3. Sort insuranceB by Price");
            System.out.println("4. Count All insuranceB");
            System.out.println("5. Save InsuranceK");
            System.out.println("6. Update  InsuranceK");
            System.out.println("7. Delete InsuranceK");
            System.out.println("8. Find insuranceB by Filter");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter insuranceK ID: ");
                    long insuranceBId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    InsuranceK insuranceK = this.insuranceBService.findById(insuranceBId);
                    if (insuranceK != null) {
                        System.out.println(insuranceK);
                    } else {
                        System.out.println(" InsuranceK  not found.");
                    }
                }
                case 2 -> {
                    List<InsuranceK> insuranceKS = this.insuranceBService.findAll();
                    for (InsuranceK mt : insuranceKS) {
                        System.out.println(mt);
                    }
                }
                case 3 -> {
                    List<InsuranceK> sortedinsuranceKS = this.insuranceBService.sortByPrice();
                    for (InsuranceK mt : sortedinsuranceKS) {
                        System.out.println(mt);
                    }
                }
                case 4 -> {
                    Long insuranceBCount = this.insuranceBService.countAll();
                    System.out.println("Total number of insuranceB: " + insuranceBCount);
                }
                case 5 -> {
                    System.out.println("Enter insuranceB info");

                    String name = this.getStringInput("Enter insuranceB name:");
                    Integer pricePerMonth = this.getIntegerInput("Enter insuranceB price per month:");
                    Integer minutes = this.getIntegerInput("Enter insuranceB risk:");
                    Integer coverage = this.getIntegerInput("Enter Coverage:");

                    if(name != null && pricePerMonth != null && minutes != null && coverage != null) {
                        this.insuranceBService.saveInsuranceB(new InsuranceK(name, pricePerMonth, minutes, coverage));
                    }

                    else{
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter insuranceB ID to update: ");
                    long updateInsuranceBId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    InsuranceK updatedInsuranceK = this.insuranceBService.findById(updateInsuranceBId);
                    if (updatedInsuranceK != null) {
                        System.out.println("Enter updated InsuranceK details... (skip if no updates)");

                        String name = this.getStringInput("Enter InsuranceK new name:");
                        Integer pricePerMonth = this.getIntegerInput("Enter mInsuranceB new price per month:");
                        Integer minutes = this.getIntegerInput("Enter InsuranceK new risk:");
                        Integer coverage = this.getIntegerInput("Enter InsuranceK new Coverage:");

                        if (name != null) {
                            updatedInsuranceK.setName(name);
                        }
                        if (pricePerMonth != null) {
                            updatedInsuranceK.setPricePerMonth(pricePerMonth);
                        }
                        if (minutes != null) {
                            updatedInsuranceK.setMinutes(minutes);
                        }
                        if (coverage != null) {
                            updatedInsuranceK.setCoverage(coverage);
                        }

                        this.insuranceBService.updateInsuranceB(updatedInsuranceK);
                    } else {
                        System.out.println(" InsuranceK not found.");
                    }
                }
                case 7 -> {
                    System.out.print("Enter InsuranceK ID to delete: ");
                    long deleteInsuranceBId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    InsuranceK deleteInsuranceK = this.insuranceBService.findById(deleteInsuranceBId);
                    if (deleteInsuranceK != null) {
                        this.insuranceBService.deleteInsuranceB(deleteInsuranceK);
                        System.out.println(" InsuranceK deleted.");
                    } else {
                        System.out.println(" InsuranceK not found.");
                    }
                }
                case 8 -> {
                    InsuranceBFilter filter = new InsuranceBFilter();

                    Integer minPrice = this.getIntegerInput("Enter minimal price:");
                    Integer maxPrice = this.getIntegerInput("Enter maximum price:");
                    Integer minMinutes = this.getIntegerInput("Enter minimal risk:");
                    Integer maxMinutes = this.getIntegerInput("Enter maximum risk:");
                    Integer minSms = this.getIntegerInput("Enter minimum Cov:");
                    Integer maxSms = this.getIntegerInput("Enter maximum Cov:");

                    if (minPrice != null) {
                        filter.setMinPricePerMonth(minPrice);
                    }
                    if (maxPrice != null) {
                        filter.setMaxPricePerMonth(maxPrice);
                    }
                    if (minMinutes != null) {
                        filter.setMinMinutes(minMinutes);
                    }
                    if (maxMinutes != null) {
                        filter.setMaxMinutes(maxMinutes);
                    }
                    if (minSms != null) {
                        filter.setMinSms(minSms);
                    }
                    if (maxSms != null) {
                        filter.setMaxSms(maxSms);
                    }

                    List<InsuranceK> insuranceK = this.insuranceBService.findByFilter(filter);
                    if (insuranceK.isEmpty()) {
                        System.out.println("No InsuranceK within such a range");
                    } else {
                        for (InsuranceK m : insuranceK) {
                            System.out.println(m);
                        }
                    }
                }
                case 0 -> {
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }while (choice != 0);
    }

    private void insuranceAMenu() {
        int choice;
        do {
            System.out.println("===== Home Tariff Menu =====");
            System.out.println("1. Find InsuranceA by ID");
            System.out.println("2. Find All InsuranceA");
            System.out.println("3. Sort InsuranceA by Risk");
            System.out.println("5. Save InsuranceA");
            System.out.println("6. Update InsuranceA");
            System.out.println("7. Delete InsuranceA");
            System.out.println("8. Find InsuranceA by Filter");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter InsuranceA ID: ");
                    long InsuranceAId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    InsuranceA insuranceA = this.insuranceAService.findById(InsuranceAId);
                    if (insuranceA != null) {
                        System.out.println(insuranceA);
                    } else {
                        System.out.println(" InsuranceA not found.");
                    }
                }
                case 2 -> {
                    List<InsuranceA> insuranceAs = this.insuranceAService.findAll();
                    for (InsuranceA ht : insuranceAs) {
                        System.out.println(ht);
                    }
                }
                case 3 -> {
                    List<InsuranceA> sortedInsuranceA = this.insuranceAService.sortByPrice();
                    for (InsuranceA ht : sortedInsuranceA) {
                        System.out.println(ht);
                    }
                }
                case 4 -> {
                    Long insuranceACount = this.insuranceAService.countAll();
                    System.out.println("Total number of insuranceA: " + insuranceACount);
                }
                case 5 -> {
                    System.out.println("Enter InsuranceB info");

                    String name = this.getStringInput("EnterinsuranceA name:");
                    Integer pricePerMonth = this.getIntegerInput("Enter insuranceA price per month:");
                    Integer dataAllowance = this.getIntegerInput("Enter insuranceA risk");
                    Integer speedMbps = this.getIntegerInput("Enter insuranceA cov per month:");

                    if(name != null && pricePerMonth != null && dataAllowance != null && speedMbps != null) {
                        this.insuranceAService.saveInsuranceA(
                                new InsuranceA(name, pricePerMonth, dataAllowance, speedMbps));
                    }

                    else{
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter InsuranceA ID to update: ");
                    long updateHomeTariffId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    InsuranceA updatedHomeTariff = this.insuranceAService.findById(updateHomeTariffId);
                    if (updatedHomeTariff != null) {
                        System.out.println("Enter updated InsuranceA details... (skip if no updates)");

                        String name = this.getStringInput("Enter InsuranceA new name:");
                        Integer pricePerMonth = this.getIntegerInput("Enter InsuranceA new price per month:");
                        Integer dataAllowance = this.getIntegerInput("Enter InsuranceAnew Risk:");
                        Integer speedMbps = this.getIntegerInput("Enter InsuranceA new cov:");

                        if (name != null) {
                            updatedHomeTariff.setName(name);
                        }
                        if (pricePerMonth != null) {
                            updatedHomeTariff.setPricePerMonth(pricePerMonth);
                        }
                        if (dataAllowance != null) {
                            updatedHomeTariff.setRisk(dataAllowance);
                        }
                        if (speedMbps != null) {
                            updatedHomeTariff.setSpeedMbps(speedMbps);
                        }

                        this.insuranceAService.updateInsuranceA(updatedHomeTariff);
                    } else {
                        System.out.println("Home Tariff not found.");
                    }
                }
                case 7 -> {
                    System.out.print("Enter InsuranceA ID to delete: ");
                    long deleteHomeTariffId = this.scanner.nextInt();
                    this.scanner.nextLine();
                    InsuranceA deleteHomeTariff = this.insuranceAService.findById(deleteHomeTariffId);
                    if (deleteHomeTariff != null) {
                        this.insuranceAService.deleteInsuranceA(deleteHomeTariff);
                        System.out.println("InsuranceA deleted.");
                    } else {
                        System.out.println("InsuranceA not found.");
                    }
                }
                case 8 -> {
                    InsuranceAFilter filter = new InsuranceAFilter();

                    Integer minPrice = this.getIntegerInput("Enter minimal price:");
                    Integer maxPrice = this.getIntegerInput("Enter maximum price:");
                    Integer minDataAllowanceMb = this.getIntegerInput("Enter minimal risk:");
                    Integer maxDataAllowanceMb = this.getIntegerInput("Enter maximum risk:");
                    Integer minCovered = this.getIntegerInput("Enter minimal cov:");
                    Integer maxCovered = this.getIntegerInput("Enter maximum cov:");

                    if (minPrice != null) {
                        filter.setMinPricePerMonth(minPrice);
                    }
                    if (maxPrice != null) {
                        filter.setMaxPricePerMonth(maxPrice);
                    }
                    if (minDataAllowanceMb != null) {
                        filter.setMinRisk(minDataAllowanceMb);
                    }
                    if (maxDataAllowanceMb != null) {
                        filter.setMaxRisk(maxDataAllowanceMb);
                    }
                    if (minCovered != null) {
                        filter.setMinCovered(minCovered);
                    }
                    if (maxCovered != null) {
                        filter.setMaxCovered(maxCovered);
                    }

                    List<InsuranceA> homeTariffs = this.insuranceAService.findByFilter(filter);
                    if (homeTariffs.isEmpty()) {
                        System.out.println("No InsuranceA within such a range");
                    } else {
                        for (InsuranceA ht : homeTariffs) {
                            System.out.println(ht);
                        }
                    }
                }
                case 0 -> {
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private String getStringInput(String message) {
        System.out.print(message);
        String input = this.scanner.nextLine().trim();
        return input.isEmpty() ? null : input;
    }

    private Long getLongInput(String message) {
        while (true) {
            System.out.print(message);
            String input = this.scanner.nextLine();
            if (input.isEmpty()) {
                return null; // Input is empty, return null to indicate "skip"
            }
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private Integer getIntegerInput(String message) {
        while (true) {
            System.out.print(message);
            String input = this.scanner.nextLine();
            if (input.isEmpty()) {
                return null; // Input is empty, return null to indicate "skip"
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void disableLogging() {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE); //could be Level.OFF
    }

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.displayMenu();
    }
}

