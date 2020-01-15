package repositories;

import models.DeliveryRoute;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagementRepositoryImpl implements FileManagementRepository {

    public List<DeliveryRoute> readFile(File file)  {
        List<DeliveryRoute> routes = new ArrayList<DeliveryRoute>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                routes.add(new DeliveryRoute(st));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public void writeFile(List<String> report, int reportNumber) {
        BufferedWriter writer = null;
        try {

            File logFile = new File("../output-files/out" + reportNumber + ".txt");

            writer = new BufferedWriter(new FileWriter(logFile));
            for (String status: report) {
                writer.write(status);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }

    }
}
