
import Algorithms.SearchAlgorithms;
import Algorithms.SortingAlgorithms;
import FileStructure.BusinessException;
import FileStructure.Directory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class of the application
 */
public class FileManagement {
    /**
     * object to read information from the console
     */
    Scanner scanner;
    /**
     * constant for the root directory folder name
     */
    public static String ROOT_DIR = "RootDirectory";
    /**
     * directory object representing the main folder
     */
    private Directory rootDirectory;
    /**
     * object to help read a file structure from disk
     */
    File rootFolder = new File(ROOT_DIR);

    /**
     * driver class constructor
     */
    public FileManagement() {
        try {
            scanner = new Scanner(System.in);
            rootDirectory = new Directory(ROOT_DIR, new File(ROOT_DIR).getCanonicalPath());
            readFilesDirectories();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * method that initializes the application file structure
     */
    public void readFilesDirectories() {
        try{
            File[] files = rootFolder.listFiles();
            for(File file :files)
            {
                if(file.isDirectory())
                    rootDirectory.getListDirectories().add(new Directory(file.getName(),file.getCanonicalPath()));
                else
                    rootDirectory.getListFiles().add(new  FileStructure.File(file.getName(),file.getCanonicalPath()));
            }
        }catch(IOException ex){
            ex.getMessage();
        }
    }

    /**
     * method that handles the insertion of a file into the file structure
     * @param fileName name of the file to add
     * @throws BusinessException business error
     */
    public void addFile(String fileName) throws BusinessException {
        List<FileStructure.File> fileList = rootDirectory.getListFiles();
        new SortingAlgorithms<FileStructure.File>().quicksort(fileList,0,fileList.size()-1);
        int pos = new SearchAlgorithms<FileStructure.File>().binarySearch(fileList,0,fileList.size()-1,new FileStructure.File(fileName, rootDirectory.getFullPath()));
        if(pos < 0) {
            rootDirectory.getListFiles().add(new FileStructure.File(fileName, rootDirectory.getFullPath()));
            System.out.printf("\nThe file '%s' has been added successfully.",fileName);
        }else
            throw new BusinessException(String.format("The file %s already exists",fileName));
    }

    /**
     * method that handles the deletion of a file
     * @param fileName name of the file to delete
     * @throws BusinessException business error
     */
    public void deleteFile(String fileName) throws BusinessException {
        List<FileStructure.File> fileList = rootDirectory.getListFiles();
        new SortingAlgorithms<FileStructure.File>().quicksort(fileList,0,fileList.size()-1);
        int pos = new SearchAlgorithms<FileStructure.File>().binarySearch(fileList,0,fileList.size()-1,new FileStructure.File(fileName, rootDirectory.getFullPath()));
        if(pos >= 0)
        {
            rootDirectory.getListFiles().remove(pos);
            System.out.printf("\nThe file '%s' has been deleted successfully.",fileName);
        }
        else
            throw new BusinessException(String.format("The file %s doesn't exists and it can't be deleted.",fileName));
    }

    /**
     * method that handles searching a file from the file structure
     * @param fileName name of the file to find
     */
    public void searchFile(String fileName){
        List<FileStructure.File> fileList = rootDirectory.getListFiles();
        new SortingAlgorithms<FileStructure.File>().quicksort(fileList,0,fileList.size()-1);
        int pos = new SearchAlgorithms<FileStructure.File>().binarySearch(fileList,0,fileList.size()-1,new FileStructure.File(fileName, rootDirectory.getFullPath()));
        if(pos >= 0)
            System.out.printf("\nThe fileName '%s' has been found.", fileName);
        else
            System.out.printf("\nThe fileName '%s' doesn't exist.",fileName);
    }

    /**
     * method that represents the UI for adding a file
     * @throws BusinessException business error
     */
    public void promptAddFile() throws BusinessException {
        System.out.println("Please specify the fileName to add: ");
        String fileName = scanner.nextLine();
        addFile(fileName);
        promptManagement();
    }

    /**
     * method that represents the UI for deleting a file
     * @throws BusinessException business error
     */
    public void promptDeleteFile() throws BusinessException {
        System.out.println("Please specify the fileName to delete: ");
        String fileName = scanner.nextLine();
        deleteFile(fileName);
        promptManagement();
    }

    /**
     * method that represents the UI for searching a file
     */
    public void promptSearchFile(){
        System.out.println("Please specify the fileName to find: ");
        String fileName = scanner.nextLine();
        searchFile(fileName);
        promptManagement();
    }

    /**
     * method that represents the UI to list files and directories
     * @param sorting flag that represents how the files are going to be shown (sorted or not)
     */
    public void promptListFiles(boolean sorting) {
        System.out.println();
        listAll(sorting);
        promptMenu();
    }

    /**
     * method that retrieves the list of files and directories
     * @param sorting flag that represents how the files are going to be shown (sorted or not)
     */
    public void listAll(boolean sorting)
    {
        List<FileStructure.File> fileList = rootDirectory.getListFiles();
        List<FileStructure.Directory> subDirectoriesList = rootDirectory.getListDirectories();

        if(sorting)
        {
            new SortingAlgorithms<FileStructure.File>().quicksort(fileList,0,fileList.size()-1);
            new SortingAlgorithms<FileStructure.Directory>().quicksort(subDirectoriesList,0,subDirectoriesList.size()-1);
        }

        System.out.printf("The sub directories in the folder '%s' are:\n", ROOT_DIR);
        for(FileStructure.Directory subDirectory : subDirectoriesList)
            System.out.println(subDirectory.getName());
        System.out.println();
        System.out.printf("The files in the folder '%s' are:\n", ROOT_DIR);
        for(FileStructure.File file : fileList)
            System.out.println(file.getName());
        System.out.println();
    }

    /**
     * method that represents the UI for prompting the options for the user
     */
    public void readOptions()  {
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                promptListFiles(false);
                break;
            case "2":
                promptListFiles(true);
                break;
            case "3":
                promptManagement();
                break;
            case "4":
                exitProgram();
                break;
            default:
                promptMenu();
        }
    }

    /**
     * method that handles the ending of the application
     */
    public void exitProgram() {
        System.out.println("The LockMe Digital software has ended. Thank you");
        // deallocate resources before exit
        if (scanner != null)
            scanner.close();
        System.exit(0);
    }

    /**
     * method that shows the main options of the application
     */
    public void showMenu()
    {
        System.out.printf("Application :  LockedMe Digitalization");
        System.out.printf("\nCreated by : Gannina Tancayllo ");
        System.out.printf("\n\nMain menu");
        System.out.printf("\n-----------");
        System.out.printf("\n1. Display files and directories (unsorted)");
        System.out.printf("\n2. Display files and directories (sorted)");
        System.out.printf("\n3. Management");
        System.out.printf("\n4. Close Application");
        System.out.printf("\n\nSelect an option from the menu:");
    }

    /**
     * method that handles the UI for the management options
     * @throws BusinessException
     */
    public void readManagementOptions() throws BusinessException {
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                promptAddFile();
                break;
            case "2":
                promptDeleteFile();
                break;
            case "3":
                promptSearchFile();
                break;
            case "4":
                promptMenu();
                break;
            default:
                promptManagement();
        }
    }

    /**
     * method that prompts the main options of the application
     */
    public void promptMenu() {
        showMenu();
        try {
            readOptions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            promptMenu();
        }
    }

    /**
     * method that prompts the management options of the application
     */
    public void promptManagement() {
        showManagement();
        try {
            readManagementOptions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            promptManagement();
        }
    }

    /**
     * method that shows the management options of the application
     */
    public void showManagement(){
        System.out.printf("\n\nOption Management");
        System.out.printf("\n-------------------");
        System.out.printf("\n1. Adding a file");
        System.out.printf("\n2. Deleting a file");
        System.out.printf("\n3. Searching a file");
        System.out.printf("\n4. Going back to main menu");
        System.out.printf("\n\nSelect an option from the menu:");
    }

    /**
     * bootstrap method of the application
     * @param args application arguments
     */
    public static void main(String[] args){
        FileManagement fileManagement = new FileManagement();
        fileManagement.promptMenu();
    }
}