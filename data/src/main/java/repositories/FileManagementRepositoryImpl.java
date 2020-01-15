package repositories;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import models.Delivery;
import models.DeliveryRoute;
import models.Drone;
import utils.RoutesMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagementRepositoryImpl implements FileManagementRepository {

    private RoutesMapper mapper;

    @Inject
    public FileManagementRepositoryImpl(@Named("RoutesMapper") RoutesMapper mapper) {
        this.mapper = mapper;
    }

    public Delivery readFile(File file)  {
        List<DeliveryRoute> routes = new ArrayList<DeliveryRoute>();
        Delivery delivery = null;
        String id = file.getName().replaceAll("\\D+","");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                routes.add(new DeliveryRoute(mapper.apply(st)));
            }
            Drone drone = new Drone(String.valueOf(Math.random()), 10);
            delivery = new Delivery(id, routes, drone);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return delivery;
    }

    public void writeFile(Delivery delivery) {
        BufferedWriter writer = null;
        try {

            File logFile = new File("../output-files/out" + delivery.getId() + ".txt");

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("== Reporte de entregas ==");
            writer.newLine();
            for (String status: delivery.getDeliveryReport()) {
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
