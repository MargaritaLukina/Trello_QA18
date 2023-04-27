package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{ User.builder().email("hatum.testing@gmail.com").password("Hatum21$").build()});
        list.add(new Object[]{ User.builder().email("juliyabee@gmail.com").password("Pass@word1").build()});
        return  list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> wrongEmailData() throws IOException {
            List<Object[]> list=new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));

        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{User.builder().email(split[0]).password(split[1]).build()});
            line = reader.readLine();

        }

        return list.iterator();
        }

    @DataProvider
    public Iterator<Object[]> wrongPasswordData(){
        List<Object[]> list=new ArrayList<>();
        return list.iterator();
    }

}
