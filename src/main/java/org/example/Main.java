package org.example;

import org.example.model.Neo;
import org.example.model.NeoFeedResponse;
import org.example.service.NASAService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        System.out.println("Hello to my Near Earth Object App!");
        System.out.println("Enter start date (YYYY-MM-DD): ");
        String sDate = userInput.nextLine();

        System.out.println("Enter end date (YYYY-MM-DD): ");
        String eDate = userInput.nextLine();

       //initialize date variables to be passed to the service
        LocalDate startDate = null;
        LocalDate endDate = null;

        //validate the dates
        try {
            startDate = LocalDate.parse(sDate);

            if (eDate != null && !eDate.trim().isEmpty()) {
                endDate = LocalDate.parse(eDate);
                if (endDate.isBefore(startDate)) {
                    System.out.println("\033[31mEnd date must be on or after start date.\033[0m");
                    return;
                }
            }
        } catch (DateTimeParseException ex) {
            System.out.println("\033[31mInvalid date format. Please use YYYY-MM-DD.\033[0m");
            return;
        }

        NASAService service = new NASAService();

        NeoFeedResponse response = service.getAllNeos(startDate.toString(), endDate==null?null:endDate.toString());

        //for each loop -- we are looping through the keys
        for (String key: response.getNearEarthObjects().keySet()){
            //grab the list based(values) on the key (date)
            List<Neo> neoList = response.getNearEarthObjects().get(key);
            int count = neoList.size();
            System.out.println("\n\033[1;34mFor Date: " + key + " there are " + count + " near earth objects\033[0m\n");

            String code = "\u001B[0m";
            for (Neo n: neoList){
                if (n.isPotentiallyHazardousAsteroid()){
                    code = "\u001B[31m";
                } else {
                    code = "\u001B[0m";
                }

                System.out.print(code);
                System.out.println("Id: " + n.getId());
                System.out.println("Name: " + n.getName());
                System.out.println("Potentionally hazardous: " + n.isPotentiallyHazardousAsteroid());
                System.out.println("Esitmated Diameter: ");
                System.out.println("\tMax in Miles: " +
                            n.getEstimatedDiameter().getMiles().getEstimatedDiameterMax());
                System.out.println("\tMin In Miles: " +
                            n.getEstimatedDiameter().getMiles().getEstimatedDiameterMin());
                System.out.println("\tMax in Feet: " +
                            n.getEstimatedDiameter().getFeet().getEstimatedDiameterMax());
                System.out.println("\tMin in Feet: " +
                            n.getEstimatedDiameter().getFeet().getEstimatedDiameterMin());
                System.out.println("\n**********************************************************");

            }
        }




    }
}


