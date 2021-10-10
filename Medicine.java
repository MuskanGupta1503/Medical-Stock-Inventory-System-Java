package Project;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class SingleMedicine{
    int ID;
    int qty;
    String name;
    String cmpname;
    String supname;
    float unitCost;
    float saleCost;

    public SingleMedicine()
    {
        ID=0;
        qty=0;
        name="";
        cmpname="";
        supname="";
        unitCost=0;
        saleCost=0;
    }
}

public class Medicine {

    public static SingleMedicine INPUT()
    {
        SingleMedicine myObj = new SingleMedicine();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter ID: ");
        myObj.ID= in.nextInt();
        System.out.print("Enter quantity: ");
        myObj.qty= in.nextInt();
        in.nextLine();
        System.out.print("Enter name: ");
        myObj.name= in.nextLine();
        System.out.print("Enter Company Name: ");
        myObj.cmpname= in.nextLine();
        System.out.print("Enter Supplier Name: ");
        myObj.supname= in.nextLine();
        System.out.print("Enter unitCost: ");
        myObj.unitCost= in.nextFloat();
        System.out.print("Enter saleCost: ");
        myObj.saleCost= in.nextFloat();

        return myObj;
    }
    public static SingleMedicine DECRYPT_STRING(String CombinedString)
    {
        SingleMedicine myObj = new SingleMedicine();
        String[] lineSplit = CombinedString.split("!");

        myObj.ID = Integer.parseInt(lineSplit[0]);
        myObj.name=lineSplit[1];
        myObj.qty = Integer.parseInt(lineSplit[2]);
        myObj.cmpname=lineSplit[3];
        myObj.supname=lineSplit[4];
        myObj.unitCost=Float.parseFloat(lineSplit[5]);
        myObj.saleCost=Float.parseFloat(lineSplit[6]);
        return myObj;
    }
    public static void WRITE()
    {
        SingleMedicine data=INPUT();
        try {
            File file = new File("friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {
                String nameNumberString = raf.readLine();
            }
                String nameNumberString=String.valueOf(data.ID)
                        +"!"+ data.name
                        +"!"+ String.valueOf(data.qty)
                        +"!"+ data.cmpname
                        +"!"+ data.supname
                        +"!"+ String.valueOf(data.unitCost)
                        +"!"+ String.valueOf(data.saleCost);
                raf.writeBytes(nameNumberString);
                raf.writeBytes(System.lineSeparator());
                System.out.println(" Friend added. ");
                raf.close();

        }
        catch (IOException ioe) {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {

            System.out.println(nef);
        }
    }
    public static void READ()
    {
        try {
            File file = new File("friendsContact.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.getFilePointer() < raf.length()) {

                String CombinedString = raf.readLine();
                SingleMedicine myObj = new SingleMedicine();
                myObj=DECRYPT_STRING(CombinedString);

                System.out.println("Friend ID: " + myObj.ID
                        + "\n" + "Name: " + myObj.name
                        + "\n" + "Quantity: " + myObj.qty
                        + "\n" + "Company Name: " + myObj.cmpname
                        + "\n" + "Supplier Name: " + myObj.supname
                        + "\n" + "Unit Cost: " + myObj.unitCost
                        + "\n" + "Sale Cost: " + myObj.saleCost
                        + "\n" );
            }
        }
        catch (IOException ioe)
        {
            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {
            System.out.println(nef);
        }
    }
    public static void SEARCH()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name=in.nextLine();
        try {
            File file = new File("friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {

                String CombinedString = raf.readLine();
                SingleMedicine myObj = new SingleMedicine();
                myObj=DECRYPT_STRING(CombinedString);


                if(name.equals(myObj.name))
                {
                    found=true;
                    System.out.println("Friend ID: " + myObj.ID
                            + "\n" + "Name: " + myObj.name
                            + "\n" + "Quantity: " + myObj.qty
                            + "\n" + "Company Name: " + myObj.cmpname
                            + "\n" + "Supplier Name: " + myObj.supname
                            + "\n" + "Unit Cost: " + myObj.unitCost
                            + "\n" + "Sale Cost: " + myObj.saleCost
                            + "\n" );
                    break;
                }
            }
            if(!found)
            {
                System.out.println("Record not found");
            }
        }
        catch (IOException ioe)
        {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {

            System.out.println(nef);
        }
    }
    public static void COUNT_REC()
    {
        try {

            String nameNumberString;
            int index=0;
            File file = new File("friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                index++;
            }
            System.out.println("Records in the file are-- "+index+ "\n");
        }
        catch (IOException ioe)
        {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {

            System.out.println(nef);
        }
    }
    public static void MODIFY()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String nameToBeUpdated=in.nextLine();
        try {

            File file = new File("friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
            while (raf.getFilePointer() < raf.length()) {
                String CombinedString = raf.readLine();
                SingleMedicine myObj = new SingleMedicine();
                myObj=DECRYPT_STRING(CombinedString);
                if (nameToBeUpdated.equals(myObj.name) ) {
                    found = true;
                    break;
                }
            }

            // Update the contact if record exists.
            if (found) {
                // Creating a temporary file with file pointer as tmpFile.
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

                // Set file pointer to start
                raf.seek(0);

                // Traversing the friendsContact.txt file
                while (raf.getFilePointer() < raf.length()) {

                    // Reading the contact from the file
                    String CombinedString = raf.readLine();
                    SingleMedicine myObj = new SingleMedicine();
                    myObj=DECRYPT_STRING(CombinedString);

                    if (nameToBeUpdated.equals(myObj.name)) {

                        // Update the number of this contact
                        SingleMedicine data=INPUT();
                        CombinedString=String.valueOf(data.ID)
                                +"!"+ data.name
                                +"!"+ String.valueOf(data.qty)
                                +"!"+ data.cmpname
                                +"!"+ data.supname
                                +"!"+ String.valueOf(data.unitCost)
                                +"!"+ String.valueOf(data.saleCost);
                    }

                    tmpraf.writeBytes(CombinedString);

                    tmpraf.writeBytes(
                            System.lineSeparator());
                }

                raf.seek(0);
                tmpraf.seek(0);

                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());

                // Closing the resources.
                tmpraf.close();
                raf.close();

                // Deleting the temporary file
                tmpFile.delete();

                System.out.println(" Medicine Record updated. ");
            }

            else {
                raf.close();
                System.out.println(" Input name does not exists. ");
            }
        }

        catch (IOException ioe) {
            System.out.println(ioe);
        }

        catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    }
    public static void DELETION()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String nameToBeDeleted=in.nextLine();

        try {
            File file = new File("friendsContact.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Opening file in reading and write mode.
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {
                String CombinedString = raf.readLine();
                SingleMedicine myObj = new SingleMedicine();
                myObj=DECRYPT_STRING(CombinedString);
                if (nameToBeDeleted.equals(myObj.name) ) {
                    found = true;
                    break;
                }
            }

            // Delete the contact if record exists.
            if (found) {

                File tmpFile = new File("temp.txt");

                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

                // Set file pointer to start
                raf.seek(0);

                // Traversing the friendsContact.txt file
                while (raf.getFilePointer() < raf.length()) {

                    String CombinedString = raf.readLine();
                    SingleMedicine myObj = new SingleMedicine();
                    myObj=DECRYPT_STRING(CombinedString);

                    // Check if the fetched contact
                    // is the one to be deleted
                    if (nameToBeDeleted.equals(myObj.name) ) {
                        continue;
                    }

                    // Add this contact in the temporary
                    // file
                    tmpraf.writeBytes(CombinedString);

                    // Add the line separator in the
                    // temporary file
                    tmpraf.writeBytes(System.lineSeparator());
                }

                // The contact has been deleted now
                // So copy the updated content from
                // the temporary file to original file.

                // Set both files pointers to start
                raf.seek(0);
                tmpraf.seek(0);

                // Copy the contents from
                // the temporary file to original file.
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                // Set the length of the original file
                // to that of temporary.
                raf.setLength(tmpraf.length());

                // Closing the resources.
                tmpraf.close();
                raf.close();

                // Deleting the temporary file
                tmpFile.delete();

                System.out.println(" Medicine Record deleted. ");
            }

            // The contact to be deleted
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Print the message
                System.out.println(" Input name"
                        + " does not exists. ");
            }
        }

        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    public static void ADMIN()
    {
        char ch1;
        int ch;

        do{
            System.out.print("\n WELCOME TO MEDICAL STORE");
            System.out.print("\n 1.Create a file");
            System.out.print("\n 2.Read a file");
            System.out.print("\n 3.Count total records in a file");
            System.out.print("\n 4.Search some Record");
            System.out.print("\n 5.Modify a record");
            System.out.print("\n 6.Delete a record");
            System.out.print("\n 7.Exit");
            Scanner in = new Scanner(System.in);
            ch= in.nextInt();

            switch(ch)
            {
                case 1:
                    WRITE();
                    break;
                case 2:
                    READ();
                    break;
                case 3:
                    COUNT_REC();
                    break;
                case 4:
                    SEARCH();
                    break;
                case 5:
                    MODIFY();
                    break;
                case 6:
                    DELETION();
                    break;
                case 7:
                    break;

            }
            System.out.print("\n Want to continue as ADMIN(y/n)--");
            ch1= in.next().charAt(0);

        }while(ch1=='y' || ch1=='Y');

    }
    public static void DISPLAY_FOR_CUSTOMER()
    {
        try {
            File file = new File("friendsContact.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.getFilePointer() < raf.length()) {

                String CombinedString = raf.readLine();

                String[] lineSplit = CombinedString.split("!");

                String name=lineSplit[1];
                String cmpname=lineSplit[3];
                float saleCost=Float.parseFloat(lineSplit[6]);

                System.out.println("\n" + "Name: " + name
                        + "\n" + "Company Name: " + cmpname
                        + "\n" + "Sale Cost: " + saleCost
                        + "\n" );
            }
        }
        catch (IOException ioe)
        {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {

            System.out.println(nef);
        }
    }
    public static void SEARCH_FOR_CUSTOMER()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name=in.nextLine();
        try {
            File file = new File("friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {

                String CombinedString = raf.readLine();
                SingleMedicine myObj = new SingleMedicine();
                myObj=DECRYPT_STRING(CombinedString);


                if(name.equals(myObj.name))
                {
                    found=true;
                    System.out.println("Name: " + myObj.name
                            + "\n" + "Company Name: " + myObj.cmpname
                            + "\n" + "Sale Cost: " + myObj.saleCost
                            + "\n" );
                    break;
                }
            }
            if(!found)
            {
                System.out.println("Record not found");
            }
        }
        catch (IOException ioe)
        {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {

            System.out.println(nef);
        }
    }
    public static void CUSTOMER()
    {
        char ch1;
        int ch;

        do{
            System.out.print("\n WELCOME TO MEDICAL STORE");
            System.out.print("\n 1.Explore All Available Medicines");
            System.out.print("\n 2.Search some Medicine name");
            System.out.print("\n 3.Purchase some Medicine");
            System.out.print("\n 4.Exit");
            Scanner in = new Scanner(System.in);
            ch= in.nextInt();

            switch(ch)
            {
                case 1:
                    DISPLAY_FOR_CUSTOMER();
                    break;
                case 2:
                    SEARCH_FOR_CUSTOMER();
                    break;
                case 3:
//                    PURCHASE_FOR_CUSTOMER();
                    break;
                case 4:
                    break;
            }
            System.out.print("\n Want to continue as Customer(y/n)--");
            ch1= in.next().charAt(0);
        }while(ch1=='y' || ch1=='Y');
    }
    public static boolean LOGIN()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Enter Username  ");
        String username= sc.nextLine();
        System.out.print("\n Enter Password  ");
        String password= sc.nextLine();

        return username.equals("admin") && password.equals("Hello");
    }
    public static void main(String[] args)
    {
        char ch1;
        int ch;
        do{
            System.out.print("\n WELCOME TO MEDICAL STORE");
            System.out.print("\n ENTER AS");
            System.out.print("\n 1.ADMIN");
            System.out.print("\n 2.CUSTOMER");
            System.out.print("\n 3.Exit \n");

            Scanner in = new Scanner(System.in);
            ch= in.nextInt();
            switch (ch) {
                case 1 -> {
                    boolean b = LOGIN();
                    if (b) {
                        ADMIN();
                    } else {
                        System.out.print("\n Wrong Username or Password");
                    }
                    break;
                }
                case 2 -> {
                    CUSTOMER();
                    break;
                }
                case 3 -> {
                    break;
                }
            }
            System.out.print("\n Want to continue in Medical Store(y/n)--");
            ch1= in.next().charAt(0);
        }while(ch1=='y' || ch1=='Y');

    }
}