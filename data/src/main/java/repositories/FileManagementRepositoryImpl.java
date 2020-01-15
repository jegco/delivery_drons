package repositories;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import models.DeliveryRoute;
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

    public List<DeliveryRoute> readFile(File file)  {
        List<DeliveryRoute> routes = new ArrayList<DeliveryRoute>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                routes.add(new DeliveryRoute(mapper.apply(st)));
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
