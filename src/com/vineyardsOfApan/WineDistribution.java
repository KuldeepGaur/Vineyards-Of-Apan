package com.vineyardsOfApan;

import java.io.*;
import java.util.*;


/**
 *
 * Class is used to distribute wine across people.
 * @author Kuldeep Gaur
 *
 */
public class WineDistribution {

    public static void main(String[] arg) throws Exception {

        Map<Wine,Person> winePersonMap = genarateWinePersonMap(System.getProperty("user.dir")+"/src/com/vineyardsOfApan/person_wine_3.txt");
        System.out.println("total wine can be sold according to  person_wine_3.txt = "+winePersonMap.size());
        System.out.println("Now generating the output file person_wine_3_opt.txt........");
        genarateOutPutFile("person_wine_3_opt.txt",winePersonMap);

        winePersonMap=null;
        Runtime.getRuntime().gc();

        File f = new File(System.getProperty("user.dir")+"/src/com/vineyardsOfApan/person_wine_4.txt");
        if(f.exists()) {
            winePersonMap = genarateWinePersonMap(System.getProperty("user.dir")+"/src/com/vineyardsOfApan/person_wine_4.txt");
            System.out.println("\n\ntotal wine can be sold according to person_wine_4.txt = "+winePersonMap.size());
            System.out.println("Now generating the output file person_wine_4_opt.txt........");
            genarateOutPutFile("person_wine_4_opt.txt",winePersonMap);

            winePersonMap=null;
            Runtime.getRuntime().gc();
        }

        f = new File(System.getProperty("user.dir")+"/src/com/vineyardsOfApan/person_wine_5.txt");
        if(f.exists()) {
            winePersonMap = genarateWinePersonMap(System.getProperty("user.dir")+"/src/com/vineyardsOfApan/person_wine_5.txt");
            System.out.println("\n\ntotal wine can be sold according to person_wine_5.txt = "+winePersonMap.size());
            System.out.println("Now generating the output file person_wine_5_opt.txt........");
            genarateOutPutFile("person_wine_5_opt.txt",winePersonMap);

            winePersonMap=null;
            Runtime.getRuntime().gc();
        }
    }


    /**
     * This method is used to analyze the person wine mapping in the given file and check if wine is already sold or not
     * this will return the unique wine-person combination
     *
     * @param  fileName Filename which has to be analyzed
     * @return Map which contains wine and person mapping
     */
    private static Map<Wine,Person> genarateWinePersonMap(String fileName) throws Exception{
        StringTokenizer st ;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String dataRow = bufferedReader.readLine(); // Read first line.
        Map<Person,Byte> personCounterMap = new LinkedHashMap<Person,Byte>();
        Map<Wine,Person> winePersonMap = new LinkedHashMap<Wine,Person>();

        while (dataRow != null){
            st = new StringTokenizer(dataRow,"\t");
            List<String> dataArray = new ArrayList<String>() ;
            while(st.hasMoreElements()){
                dataArray.add(st.nextElement().toString());
            }

            if(dataArray.size()>1){
                Wine wine = new Wine(dataArray.get(1));
                Person person = new Person(dataArray.get(0));
                if(!winePersonMap.containsKey(wine)){
                    final boolean personAlreadyExist = personCounterMap.containsKey(person);
                    Byte counter = personAlreadyExist?personCounterMap.get(person):0;
                    if(counter<3 || !personAlreadyExist){
                        personCounterMap.put(person,++counter);
                        winePersonMap.put(wine,person);
                    }
                }
            }

            dataRow = bufferedReader.readLine(); // Read next line of data.
        }
        // Close the file once all data has been read.
        bufferedReader.close();

        return winePersonMap;
    }

    /**
     *This will genarate the output in the given output file
     *
     * @param  fileName Output Filename in which data to be stored
     */
    private static Map<Wine,Person> genarateOutPutFile(String fileName,Map<Wine,Person> winePersonMap) throws Exception{
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(winePersonMap.size());
        for (Map.Entry<Wine, Person> entry : winePersonMap.entrySet()) {
            printWriter.println(entry.getValue().nameOfPerson+" "+entry.getKey().nameOfWine);
        }

        printWriter.close();

        return winePersonMap;
    }

}
