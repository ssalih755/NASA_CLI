package org.example;

import org.example.model.Neo;
import org.example.model.NeoFeedResponse;
import org.example.service.NASAService;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        System.out.println("Hello to my Near Earth Object App!");
        System.out.println("Enter start date (YYYY-MM-DD): ");
        String sDate = userInput.nextLine();



        NASAService service = new NASAService();


        NeoFeedResponse response = service.getAllNeos(sDate, sDate);

        //for each loop -- we are looping through the keys
        for (String key: response.getNearEarthObjects().keySet()){
            //grab the list based(values) on the key (date)
            List<Neo> neoList = response.getNearEarthObjects().get(key);
            int count = neoList.size();
            System.out.println("For Date: " + key + " there are " + count + " near earth objects");

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