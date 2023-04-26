package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"inna_83@gmail.com","Aa13579$"});
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list= new ArrayList<>();

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list= new ArrayList<>();
        // read from file --> add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test.csv")));
        String line =  reader.readLine();  ///   "noa@gmail.com,Nnoa12345$"
        while (line!=null){
            String[] all= line.split(",");// ["noa@gmail.com"] ["Nnoa12345$"]
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line=reader.readLine();   // "sonya@gmail.com,Ss12345$"   //"noa@gmail.com,Nnoa12345$"  // null
        }


        return list.iterator();
    }
}
