import java.io.File;
import java.util.Scanner;

public class FileDirectory {

    public static void main(String[] args) {

        // Check command line argument
        if (args.length != 1) {
            System.out.println("Please provide a file or directory path.");
            System.out.println("Example: java FileDirectoryDemo test.txt");
            return;
        }

        File f = new File(args[0]);

        // Check whether path exists
        if (!f.exists()) {
            System.out.println("File or directory does not exist.");
            return;
        }

        // If it is a file
        if (f.isFile()) {

            System.out.println("It is a FILE.");
            System.out.println("\nFile Information:");
            System.out.println("Name       : " + f.getName());
            System.out.println("Path       : " + f.getPath());
            System.out.println("Absolute Path : " + f.getAbsolutePath());
            System.out.println("Size       : " + f.length() + " bytes");
            System.out.println("Readable   : " + f.canRead());
            System.out.println("Writable   : " + f.canWrite());
            System.out.println("Executable : " + f.canExecute());
            System.out.println("Hidden     : " + f.isHidden());

        }

        // If it is a directory
        else if (f.isDirectory()) {

            System.out.println("It is a DIRECTORY.");

            File[] files = f.listFiles();

            if (files == null) {
                System.out.println("Cannot access directory.");
                return;
            }

            System.out.println("\nContents of directory:");

            int fileCount = 0;

            for (File item : files) {

                System.out.println(item.getName());

                if (item.isFile()) {
                    fileCount++;
                }
            }

            System.out.println("\nNumber of files: " + fileCount);

            // Ask user whether to delete .txt files
            Scanner sc = new Scanner(System.in);

            System.out.print(
                "\nDo you want to delete all .txt files? (yes/no): "
            );

            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("yes")) {

                int deletedCount = 0;

                for (File item : files) {

                    if (item.isFile() &&
                        item.getName().toLowerCase().endsWith(".txt")) {

                        if (item.delete()) {
                            System.out.println(
                                "Deleted: " + item.getName()
                            );
                            deletedCount++;
                        } else {
                            System.out.println(
                                "Could not delete: " + item.getName()
                            );
                        }
                    }
                }

                System.out.println(
                    "Total .txt files deleted: " + deletedCount
                );

            } else {
                System.out.println("No files were deleted.");
            }

            sc.close();
        }
    }
}
