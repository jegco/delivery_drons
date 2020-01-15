package repositories;

import models.DeliveryRoute;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileManagementRepository {
    List<DeliveryRoute> readFile(File file);

    void writeFile(List<String> report, int reportNumber);
}
