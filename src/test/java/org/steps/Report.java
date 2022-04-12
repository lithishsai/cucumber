package org.steps;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;



public class Report {
public static void report(String json) {
File f=new File("C:\\Users\\DELL\\eclipse-workspace\\Cucumbermarch\\target\\final.html");
Configuration c =new Configuration(f, "report");
c.addClassifications("Browser", "Chrome");
c.addClassifications("Client", "Adactinhotelapp");
List <String> li = new ArrayList();
li.add(json);
ReportBuilder r =new ReportBuilder(li, c);
r.generateReports();
}
}
