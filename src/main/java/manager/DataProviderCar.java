package manager;


        import models.Car;
        import org.testng.annotations.DataProvider;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;


public class DataProviderCar {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> carSuccessAll() {
        List<Object[]> list = new ArrayList<>();
        list.add((new Object[]{Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Honda")
                .model("HRV")
                .year("2022")
                .fuel("Hybrid")
                .seats(5)
                .carClass("C")
                .carRegNumber("326-743")
                .price(50)
                .about("Very nice car")
                .build()}));
        list.add((new Object[]{Car.builder()
                .location("Haifa, Israel")
                .manufacture("Toyota")
                .model("Rav4")
                .year("2020")
                .fuel("Petrol")
                .seats(5)
                .carClass("C")
                .carRegNumber("031-952-")
                .price(70)
                .about("Very nice car")
                .build()}));

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> carSuccess() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader((new FileReader(new File("src/test/resources/car.csv"))));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split("/");
            list.add(new Object[]{Car.builder()
                    .location(all[0])
                    .manufacture(all[1])
                    .model(all[2])
                    .year(all[3])
                    .fuel(all[4])
                    .seats(Integer.parseInt(all[5]))
                    .carClass(all[6])
                    .carRegNumber(all[7])
                    .price(Double.parseDouble(all[8]))
                    .build()});
            line = reader.readLine();
        }

            return list.iterator();
        }
    }

