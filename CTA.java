import java.io.*;
import java.util.*;
import java.lang.*;

public class CTA
{
    public static void main(String[] args)throws IOException
    {

        Scanner sc= new Scanner(System.in);
        while(true)
        {   
            System.out.println();
            System.out.println("Do you want to:");
            System.out.println("1. Encrypt \n2. Decrypt \n3. Exit");
            int choice= sc.nextInt();

            switch(choice)
            {
                case 1: encrypt();
                        break;
                
                case 2: decrypt();
                        break;
                    
                case 3: System.out.println("Thank you!!");
                        System.exit(0);
                        break;

                default: System.out.println("Wrong choice");
                        break;
            }
        }
    }
        
        public static void encrypt()throws IOException
        {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            String encmsg, key;
            int msglen, keylen, count;
            count=0;

            //Input for Message 
            System.out.println("Enter the text to be encrypted");
            encmsg= br.readLine();
            encmsg+="\0";
            msglen=encmsg.length();
            
            //Input for Keyword
            System.out.println("Enter the keyword(All the letters must be distinct)");
            key= br.readLine();
            keylen=key.length();

            //Display of input
            System.out.println("The Entered message is: "+encmsg);
            System.out.println("The Entered key is: "+key);

            //Insertion of key into array
            char arr[][]=new char[msglen/2][keylen];
            for(int j=0; j<keylen; j++)
                arr[0][j]=key.charAt(j);
            System.out.println();

            //Insertion of Message into array
            boolean flag=false;
            for(int i=1; i<msglen/2; i++)
            {
                for(int j=0; j<keylen; j++)
                {
                    if(encmsg.charAt(count)=='\0')
                    {
                        flag=true;
                        break;
                    }
                    else
                    {
                        arr[i][j]=encmsg.charAt(count);
                        count++;
                    }
                
                }
                if(flag)
                    break;
            }
       
            //Insertion of special character for completion of matrix
            for(int i=0; i<msglen/2; i++)
            {
                for(int j=0; j<keylen; j++)
                    if(arr[i][j]==0)
                        arr[i][j]='`';
            }

            //Display of array
            // System.out.println("Message in the form of array");
            // for(int i=0; i<msglen/2; i++)
            // {
            //     for(int j=0; j<keylen; j++)
            //         System.out.print(arr[i][j]+"\t");
            //     System.out.println();
            // }
            // System.out.println();
        
            char Earr[][]= new char[msglen/2][keylen], temp;
            char akey[]= new char[keylen];

            //Spliting of Key into array
            for(int i=0; i<keylen; i++)
                akey[i]=key.charAt(i);
        
            //Arranging key in alphabetical order
            for(int i=0; i<keylen; i++)
            {
                for(int j=0; j<keylen-1; j++)
                {
                    if(akey[j]>akey[j+1])
                    {
                        temp=akey[j];
                        akey[j]=akey[j+1];
                        akey[j+1]=temp;
                    }
                }
            }

            //Insertion of arranged key into array
            for(int i=0; i<keylen; i++)
                Earr[0][i]=akey[i];
            // for(int i=0; i<keylen; i++)
            //     System.out.println(Earr[i]);

            //Encrypting the message
            for(int k=0; k<keylen; k++)
            {
                for(int j=0; j<keylen; j++)
                {
                    if(arr[0][k]==Earr[0][j])
                    {
                        for(int i=1; i<msglen/2; i++)
                        {
                            Earr[i][j]=arr[i][k];
                        }
                    }
                }
            }

            //Printing the encrypted message stored in the array
            System.out.println("The encrypted text is:");
            for(int i=0; i<msglen/2; i++)
            {
                for(int j=0; j<keylen; j++)
                    System.out.print(Earr[i][j]);
            }
            System.out.println();
        }

        public static void decrypt()throws IOException
        {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

            //Input of decrypted text from user
            System.out.println("Enter the text to be decrypted");
            String decmsg=br.readLine();
            decmsg+= "\0";
            int dmsglen=(decmsg.length()/2);

            //Input of keyword from the user to encrypt the text
            System.out.println("Enter the Keyword used to encrypt the message");
            String key1=br.readLine();

            
            char Decarr[][]=new char[dmsglen][key1.length()];
            int count1;
            boolean checkflag=false;
            count1=0;

            //Insert the decrypted message into the array
            for(int i=0; i<dmsglen; i++)
            {
                for(int j=0; j<key1.length(); j++)
                {
                    if(decmsg.charAt(count1)=='\0')
                    {
                        checkflag=true;
                        break;
                    }
                    else
                    {
                        Decarr[i][j]=decmsg.charAt(count1);
                        count1++;
                    }
                
                }
                if(checkflag)
                    break;
            }

            //Print the Decrypted array
            // for(int i=0; i<dmsglen; i++)
            // {
            //     for(int j=0; j<key1.length(); j++)
            //     {
            //         System.out.print(Decarr[i][j]+"\t");
            //     }
            //     System.out.println();
            // }


            char outarr[][]= new char[dmsglen][key1.length()];

            //Insert the key into the output array
            for(int i=0; i<key1.length(); i++)
                outarr[0][i]=key1.charAt(i);
                
            //Decrypt and store in the array
            for(int k=0; k<key1.length() ; k++)
            {
                for(int j=0; j<key1.length(); j++)
                {
                    if(outarr[0][k]==Decarr[0][j])
                    {
                        for(int i=1; i<dmsglen; i++)
                        {
                            outarr[i][k]=Decarr[i][j];
                        }
                    }
                }
            }

            //Display the contents
            System.out.println("The message entered is: "+decmsg);
            System.out.println("The keyword used is: "+key1);
            System.out.println();
            System.out.println("The Decrypted message is");
            for(int i=1; i<dmsglen; i++)
            {
                for(int j=0; j<key1.length(); j++)
                {
                    if(!(outarr[i][j]=='`'))
                    System.out.print(outarr[i][j]);
                }
            }
            System.out.println();
        }


    }
 