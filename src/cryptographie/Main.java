package cryptographie;

import javax.crypto.spec.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.Scanner;

import javax.crypto.*;
  
public class Main
{

   
   public static void main(String []args) throws Exception {
		System.out.println("TO USE AES [1] RC4 [2]");
		Scanner sc = new Scanner(System.in);
		String algo = sc.nextLine();
		System.out.println("TO ENC [1] DEC [2]");
		String op = sc.nextLine();
		System.out.println("Password");
		String pass = sc.nextLine();
		System.out.println("File PATH");
		String path = sc.nextLine();
		System.out.println("new file PATH");
		String newPath = sc.nextLine();
		if(algo.equalsIgnoreCase("1")) {
			if(op.equalsIgnoreCase("1")) {
				try {
			    	  AES aes = new AES();
			    	  File myObj = new File(path);
			          Scanner myReader = new Scanner(myObj);
			          while (myReader.hasNextLine()) {
			            String data = myReader.nextLine();
			            System.out.println("Encrypting...");
			            String encrypted = aes.encrypt(data, pass);
			            System.out.println(encrypted);
			            File file = new File(newPath);
			            file.createNewFile();
			            FileWriter writer = new FileWriter(file);
			            writer.write(new String(encrypted));
			            writer.close();
			          }
			          myReader.close();
			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
			}
			if(op.equalsIgnoreCase("2")) {
				try {
			    	  AES aes = new AES();
			          File myObj = new File(path);
			          Scanner myReader = new Scanner(myObj);
			          while (myReader.hasNextLine()) {
			            String data = myReader.nextLine();
			            System.out.println("Encrypting...");
			            String decrypted = aes.decrypt(data, pass);
			            System.out.println(decrypted);
			            File file = new File(newPath);
			            file.createNewFile();
			            FileWriter writer = new FileWriter(file);
			            writer.write(new String(decrypted));
			            writer.close();
			          }
			          myReader.close();
			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
			}
			
		}
        if(algo.equalsIgnoreCase("2")) {
        	if(op.equalsIgnoreCase("1")) {
        		try {
        			RC4 rc4 = new RC4();
			          File myObj = new File(path);
			          Scanner myReader = new Scanner(myObj);
			          while (myReader.hasNextLine()) {
			            String data = myReader.nextLine();
			            System.out.println("Encrypting...");
			            byte[]  encrypted = rc4.encrypt(data, pass);
			            System.out.println(encrypted);
			            File file = new File(newPath);
			            file.createNewFile();
			            FileWriter writer = new FileWriter(file);
			            writer.write(new String(encrypted));
			            writer.close();
			          }
			          myReader.close();
			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
        	}
			if(op.equalsIgnoreCase("2")) {
				try {
        			RC4 rc4 = new RC4();
			          File myObj = new File(path);
			          Scanner myReader = new Scanner(myObj);
			          while (myReader.hasNextLine()) {
			            String data = myReader.nextLine();
			            System.out.println("Encrypting...");
			            byte[]  decrypted = rc4.decrypt(data.getBytes("UTF-8"), pass);
			            System.out.println(decrypted);
			            File file = new File(newPath);
			            file.createNewFile();
			            FileWriter writer = new FileWriter(file);
			            writer.write(new String(decrypted));
			            writer.close();
			          }
			          myReader.close();
			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
			}
		}
   }
  
}

