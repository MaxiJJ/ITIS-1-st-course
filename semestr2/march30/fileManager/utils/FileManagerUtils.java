package course1.march30.fileManager.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManagerUtils {

    private URI currentPath;
    private static FileManagerUtils instance;

    private FileManagerUtils() {
        currentPath = getDefaultDirectory();
    }

    public static FileManagerUtils getInstance() {
        if (instance == null) {
            instance = new FileManagerUtils();
        }
        return instance;
    }

    private URI getDefaultDirectory() {
        String homePath = System.getProperty("user.home");
        return Paths.get(homePath).toUri();
    }

    public List<File> getFiles(boolean hiddenFile, boolean optionalInfo) throws FileNotFoundException {
        File files = new File(currentPath);
        if (!files.exists()) {
            throw new FileNotFoundException();
        }

        File[] fileLists = files.listFiles();
        if (fileLists == null) return null;

        List<File> list = new ArrayList<>();

        for (File file : fileLists) {
            if (!file.isHidden() || hiddenFile == file.isHidden()) {
                list.add(file);
            }
        }

        return list;
    }

    public boolean pickPath(String path) {
        File directory = null;
        if (Paths.get(path).isAbsolute()) {
            directory = new File(Paths.get(path).toUri());
        }
        if (path.equals("~")) {
            directory = new File(currentPath);
            currentPath = getDefaultDirectory();
        }
        if (directory == null) {
            directory = findFileInDirectory(path);
        }

        if (!directory.isDirectory()) return false;

        if (path.contains("..")) {
            Path basePath = Paths.get(currentPath);
            Path absolutePath = basePath.resolve(path).normalize();
            directory = new File(absolutePath.toUri());
        }

        currentPath = directory.toURI();
        return true;
    }

    public boolean remove(String file, boolean deleteDirectory, boolean deleteAnyway) {
        if (deleteDirectory) {
            File directory = new File(Paths.get(getCurrentPath() + "\\" + file).toUri());
            return removeDirectory(directory, deleteAnyway);
        }
        File deleteFile = findFileInDirectory(file);
        if (deleteFile == null) return false;

        if (deleteFile.isFile()) {
            return deleteFile.delete();
        }

        File[] files = deleteFile.listFiles();
        if (files == null) return false;
        if (files.length != 0) {
            System.out.println("Can not delete catalog, it is not empty!");
        } else {
            try {
                Files.delete(deleteFile.toPath());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private boolean removeDirectory(File folder, boolean deleteAnyway) {
        try {
            File[] files = folder.listFiles();
            if (files == null) return false;
            if (files.length != 0 && !deleteAnyway) return false;

            for (File file : files) {
                if (file.isDirectory()) {
                    removeDirectory(file, deleteAnyway);
                } else {
                    file.delete();
                }
                if (folder.listFiles().length == 0) Files.delete(folder.toPath());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean move(String file1, String file2) {
        File file = findFileInDirectory(file1);
        if (file == null) return false;
        if (Paths.get(file2).isAbsolute()) {
            File movePathFile = new File(Paths.get(file2 + "\\" + file.getName()).toUri());
            return file.renameTo(movePathFile);
        } else {
            File moveFile = new File(Paths.get(getCurrentPath() + "\\" + file2).toUri());
            if (moveFile.isDirectory()) {
                File movePathFile = new File(Paths.get(getCurrentPath() + "\\" + file2 + "\\" + file.getName()).toUri());
                return file.renameTo(movePathFile);
            } else {
                return file.renameTo(moveFile);
            }
        }
    }

    public boolean copy(String fileName, String directory) {
        File file = findFileInDirectory(fileName);
        if (file == null) return false;
        File copyPathFile;
        String pathDistance = getCurrentPath() + "\\" + directory;
        if (Paths.get(directory).isAbsolute()) {
            copyPathFile = new File(Paths.get(directory).toUri());
        } else {
            copyPathFile = new File(Paths.get(pathDistance).toUri());
        }

        if (!copyPathFile.isDirectory()) return false;
        try {
            Files.copy(file.toPath(), (new File(copyPathFile, fileName)).toPath());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private File findFileInDirectory(String fileName) {
        return new File(new File(currentPath), fileName);
    }

    public String getCurrentPath() {
        return Paths.get(currentPath).toString();
    }
}
