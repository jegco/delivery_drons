package repositories;

import models.Delivery;

import java.io.File;

public interface FileManagementRepository {
    Delivery readFile(File file);

    void writeFile(Delivery delivery);
}
