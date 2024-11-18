package logica.dt;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formato deseado

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, dateFormatter);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(dateFormatter);
    }
}