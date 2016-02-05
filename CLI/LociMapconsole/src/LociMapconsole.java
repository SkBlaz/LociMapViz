/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author bibaleze
 */
public class LociMapconsole {

   
      
        
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
         BufferedReader in = null;
         final long startTime = System.currentTimeMillis();
         
         if (args[0].equals("-opts")){
             
             
             System.out.println(" __                            __  __       __                      __     __  __           \n" +
"/  |                          /  |/  \\     /  |                    /  |   /  |/  |          \n" +
"$$ |        ______    _______ $$/ $$  \\   /$$ |  ______    ______  $$ |   $$ |$$/  ________ \n" +
"$$ |       /      \\  /       |/  |$$$  \\ /$$$ | /      \\  /      \\ $$ |   $$ |/  |/        |\n" +
"$$ |      /$$$$$$  |/$$$$$$$/ $$ |$$$$  /$$$$ | $$$$$$  |/$$$$$$  |$$  \\ /$$/ $$ |$$$$$$$$/ \n" +
"$$ |      $$ |  $$ |$$ |      $$ |$$ $$ $$/$$ | /    $$ |$$ |  $$ | $$  /$$/  $$ |  /  $$/  \n" +
"$$ |_____ $$ \\__$$ |$$ \\_____ $$ |$$ |$$$/ $$ |/$$$$$$$ |$$ |__$$ |  $$ $$/   $$ | /$$$$/__ \n" +
"$$       |$$    $$/ $$       |$$ |$$ | $/  $$ |$$    $$ |$$    $$/    $$$/    $$ |/$$      |\n" +
"$$$$$$$$/  $$$$$$/   $$$$$$$/ $$/ $$/      $$/  $$$$$$$/ $$$$$$$/      $/     $$/ $$$$$$$$/ \n" +
"                                                         $$ |                               \n" +
"                                                         $$ |                               \n" +
"                                                         $$/      "+"\n"+"By Integromics-TIME research group"+"\n\n\n");
         
               System.out.println("This is console implementation of LociMapViz algorithm." +"\n"+
                       "Input file must be aligned and inputed in FASTA format. To visualise results, use LociMapViz GUI"+
                       "\n"+" or R functions in folder Rfun."+"\n"+
                       "Basic usage is as follows:"+"\n"+"java LociMapViz.java alignments.fa loci.txt output.txt");
               
         
         }else{
         
         
         
        
            
            HashMap<String, String> hmap = new HashMap<String, String>();
            HashMap<String, Integer> AAcounts = new HashMap<String, Integer>();
            final StringBuilder Rsection=new StringBuilder(""); 
            
          in = new BufferedReader(new FileReader(args[0]));
                        

                        
                        String line;
                        String header = "";
                        String sequence = "";
                        StringBuilder stringBuilder = new StringBuilder();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        System.out.println("loci, "+"type," + "count"+"\n");
                        if (args[2] != null){
                        Rsection.append("loci, "+"type," + "count"+"\n");
                        }
                        while((line=in.readLine())!=null){
                            
                            if(line.startsWith(">"))
                            {
                                stringBuilder2.append(line);
                                
                                
                                while((line=in.readLine())!=null){
                                    
                                    if (line.startsWith(">")){
                                        
                                        hmap.put(stringBuilder2.toString(),stringBuilder.toString());
                                        
                                        stringBuilder.setLength(0);
                                        
                                        stringBuilder2.setLength(0);
                                        
                                        stringBuilder2.append(line);
                                        
                                        
                                        
                                        
                                    }else{
                                        stringBuilder.append(line);
                                        
                                    }
                                    
                                }
                            }
                            
                        }
                        in.close();
                        
                        
                        
                            
                            
                                
                                  
                            
                        //jTextField4.setText("1,2,3,4,5,");
                         try {
                            Scanner a = new Scanner (new FileInputStream (args[1]));

                            while (a.hasNext()){
                                //System.out.println(a.nextLine()); //this works correctly, all the lines are displayed
                                String locuses = a.nextLine();
                                //System.out.println(line); //this works correctly, all the lines are displayed
                                String[] lociS = locuses.split(",");


                            
                        //String[] lociS = args[1].split(",");
                        int[] loci = new int[lociS.length];
                        
                        for (int i = 0; i < lociS.length; i++) {
                            String numberAsString = lociS[i];
                            loci[i] = Integer.parseInt(numberAsString);
                         }
                        
                        
                        for (int chr : loci){
                            
                            chr=chr-1;
                            
                            int ala = 0;
                            int arg = 0;
                            int asn = 0;
                            int asp = 0;
                            int cys = 0;
                            int glu = 0;
                            int gln = 0;
                            int gly = 0;
                            int his = 0;
                            int ile = 0;
                            int leu = 0;
                            int lys = 0;
                            int met = 0;
                            int phe = 0;
                            int pro = 0;
                            int ser = 0;
                            int thr = 0;
                            int trp = 0;
                            int tyr = 0;
                            int val = 0;
                            int uracil=0;
                            
                            Set set = hmap.entrySet();
                            Iterator iterator = set.iterator();
                            //System.out.println("Currently analysing loci: "+chr);
                            while(iterator.hasNext()) {
                                Map.Entry mentry = (Map.Entry)iterator.next();
                                String tempstring = (String) mentry.getValue();
                                if (tempstring.charAt(chr)=='A' || tempstring.charAt(chr)=='a'){
                                    ala++;
                                }else if(tempstring.charAt(chr)=='R'){
                                    arg++;
                                }
                                else if(tempstring.charAt(chr)=='N'){
                                    asn++;
                                }
                                else if(tempstring.charAt(chr)=='D'){
                                    asp++;
                                }
                                else if(tempstring.charAt(chr)=='C' || tempstring.charAt(chr)=='c'){
                                    cys++;
                                }
                                else if(tempstring.charAt(chr)=='E'){
                                    glu++;
                                }
                                else if(tempstring.charAt(chr)=='Q'){
                                    gln++;
                                }
                                else if(tempstring.charAt(chr)=='G' || tempstring.charAt(chr)=='g'){
                                    gly++;
                                }
                                else if(tempstring.charAt(chr)=='H'){
                                    his++;
                                }
                                else if(tempstring.charAt(chr)=='I'){
                                    ile++;
                                }
                                else if(tempstring.charAt(chr)=='L'){
                                    leu++;
                                }
                                else if(tempstring.charAt(chr)=='K'){
                                    lys++;
                                }
                                else if(tempstring.charAt(chr)=='M'){
                                    met++;
                                }
                                else if(tempstring.charAt(chr)=='F'){
                                    phe++;
                                }
                                else if(tempstring.charAt(chr)=='P'){
                                    pro++;
                                }
                                else if(tempstring.charAt(chr)=='S'){
                                    ser++;
                                }
                                else if(tempstring.charAt(chr)=='T' || tempstring.charAt(chr)=='t'){
                                    thr++;
                                }
                                else if(tempstring.charAt(chr)=='W'){
                                    trp++;
                                }
                                else if(tempstring.charAt(chr)=='Y'){
                                    tyr++;
                                }
                                else if(tempstring.charAt(chr)=='V'){
                                    val++;
                                }
                                else if(tempstring.charAt(chr)=='u'|| tempstring.charAt(chr)=='U'){
                                    uracil++;
                                }
                                else {
                                    //System.out.println("gap found..");
                                    //System.out.println("Gap found..");
                                }
                                
                                
                                
                            }
                            AAcounts.put("U",uracil);
                            AAcounts.put("A",ala);
                            AAcounts.put("R",arg);
                            AAcounts.put("N",asn);
                            AAcounts.put("D",asp);
                            AAcounts.put("C",cys);
                            AAcounts.put("E",glu);
                            AAcounts.put("Q",gln);
                            AAcounts.put("G",gly);
                            AAcounts.put("H",his);
                            AAcounts.put("I",ile);
                            AAcounts.put("L",leu);
                            AAcounts.put("K",lys);
                            AAcounts.put("M",met);
                            AAcounts.put("F",phe);
                            AAcounts.put("P",pro);
                            AAcounts.put("S",ser);
                            AAcounts.put("T",thr);
                            AAcounts.put("W",trp);
                            AAcounts.put("Y",tyr);
                            AAcounts.put("V",val);
                        
//            Integer var= AAcounts.get("M");
//            System.out.println(var);
                            //System.out.println("loci, "+"AA," + "count");
                            
                            Iterator<String> keySetIterator = AAcounts.keySet().iterator(); 
            while(keySetIterator.hasNext()){ 
                
                String key = keySetIterator.next(); 
                //System.out.println(chr+","+key+","+AAcounts.get(key));
                if (AAcounts.get(key) != 0){
                    if (args[2] !=null){
                Rsection.append((chr+1)+","+key+","+AAcounts.get(key)+"\n");
                    }
                System.out.println((chr+1)+", "+key+", "+AAcounts.get(key)+"\n");
                
                
                }
            }
            
            if (args[2] != null){
            Writer writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(args[2]), "utf-8"));
                writer.write(Rsection.toString());
            } catch (IOException ex) {
              // report
            } finally {
               try {writer.close();} catch (Exception ex) {/*ignore*/}
            }
            
            }else{
            
            System.out.println("To write to file, please use file option.");
            
            
            }
      }
                        }
                            a.close();

                        }catch (FileNotFoundException e){
                            System.out.println("File not found");
                        }
                        
                        final long endTime = System.currentTimeMillis();

                        System.out.println("Finished. "+"Total execution time: " + (endTime - startTime) + "ms" );
                     
             
                
                
                
                
                
                
      
                        
                
                //JOptionPane.showMessageDialog(null, "Finished analysis");
                
                
    //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			
         }
        
        
        
    }
    
}
