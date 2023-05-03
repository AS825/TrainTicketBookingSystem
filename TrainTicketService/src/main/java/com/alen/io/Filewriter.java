package com.alen.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class Filewriter {

    public String TopWebPie = (
            """
                    <html>
                      <head>
                          <style>
                              @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@1,300&display=swap');
                              *{
                                  font-family: 'Poppins', sans-serif;
                              }
                          </style>
                        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                        <script type="text/javascript">
                          google.charts.load("current", {packages:["corechart"]});
                          google.charts.setOnLoadCallback(drawChart);
                          function drawChart() {
                            var data = google.visualization.arrayToDataTable([
                              ['Train', 'workload'],   
                    """);
    public String BottomWebPie = (
            """
                     ]);
                            var options = {
                              title: 'Train Workload Passenger',
                              pieHole: 0.35,
                            };

                            var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                            chart.draw(data, options);
                          }
                        </script>
                      </head>
                      <body>
                        <div id="donutchart" style="width: 1500px; height: 700px;"></div>
                      </body>
                    </html>
                    """);

    public void createPieChart(Map<String, Integer> trainMap) throws FileNotFoundException {
        File pieChart = new File("src/main/resources/Webchart.html");
        PrintWriter webChart = new PrintWriter(pieChart);
        webChart.println(TopWebPie);
        for (Map.Entry<String, Integer> entry : trainMap.entrySet()) {
            webChart.printf("['%s', %d],\n", entry.getKey(),entry.getValue());
        }



        webChart.println(BottomWebPie);
        webChart.close();
        System.out.println("html created");
    }
}
