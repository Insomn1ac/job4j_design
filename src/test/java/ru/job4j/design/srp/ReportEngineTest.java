package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenGeneratedForDevelopers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new DevelopersReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("<!DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<title>").append("Report for developers").append("</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;").append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenGeneratedForCounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new CountingReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(String.format("%.1f", worker.getSalary() / 73.65)).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee developer = new Employee("Stepan", now, now, 123);
        store.add(developer);
        Report engine = new HRReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;").append(System.lineSeparator())
                .append(developer.getName()).append(";")
                .append(developer.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new JsonReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("[{\"name\":\"Ivan\",")
                .append("\"hired\":{\"year\":" + worker.getHired().get(Calendar.YEAR) + ",\"month\":" + worker.getHired().get(Calendar.MONTH))
                .append(",\"dayOfMonth\":" + worker.getHired().get(Calendar.DAY_OF_MONTH) + ",\"hourOfDay\":" + worker.getHired().get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":" + worker.getHired().get(Calendar.MINUTE) + ",\"second\":" + worker.getHired().get(Calendar.SECOND) + "},")
                .append("\"fired\":{\"year\":" + worker.getFired().get(Calendar.YEAR) + ",\"month\":" + worker.getFired().get(Calendar.MONTH))
                .append(",\"dayOfMonth\":" + worker.getFired().get(Calendar.DAY_OF_MONTH) + ",\"hourOfDay\":" + worker.getFired().get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":" + worker.getFired().get(Calendar.MINUTE) + ",\"second\":" + worker.getFired().get(Calendar.SECOND) + "},")
                .append("\"salary\":" + worker.getSalary() + "}]");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new XmlReportEngine(store);
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <fired>").append(formatter.format(worker.getFired().getTime())).append("</fired>").append("\n")
                .append("        <hired>").append(formatter.format(worker.getHired().getTime())).append("</hired>").append("\n")
                .append("        <name>Ivan</name>").append("\n")
                .append("        <salary>100.0</salary>").append("\n")
                .append("    </employee>\n")
                .append("</employees>\n");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }
}