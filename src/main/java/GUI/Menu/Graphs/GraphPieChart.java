package GUI.Menu.Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import javax.imageio.ImageIO;
import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class GraphPieChart extends JPanel {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        public GraphPieChart() {
            // novy dataset
            DefaultPieDataset dataset = new DefaultPieDataset();
            int result1 = 0;
            int result2 = 0;
            try {
                transaction.begin();
                // ziskanie dat z databazy - JPQL
                TypedQuery<Long> query1 = entityManager.createQuery(
                        "SELECT COUNT (p.idPoruchy) " +
                                "FROM BPorucha p " +
                                " WHERE p.poruchaDo IS NOT NULL ", Long.class);
                result1 = Math.toIntExact(query1.getSingleResult());

                TypedQuery<Long> query2 = entityManager.createQuery(
                        "SELECT COUNT (p.idPoruchy) " +
                                "FROM BPorucha p " +
                                " WHERE p.poruchaDo IS NULL ", Long.class);
                result2 = Math.toIntExact(query2.getSingleResult());
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Nastala chyba pri načítavaní údajov: " + e.getMessage() + " Skúste to znovu!");
                if (transaction.isActive()) {
                    transaction.rollback();
                }
            }

            DecimalFormat df = new DecimalFormat("#.##");
            double activePercentage = (100.0 * result1) / (result1 + result2);
            double resolvedPercentage = (100.0 * result2) / (result1 + result2);
            dataset.setValue("Aktívne poruchy: " + df.format(activePercentage) + "%", result1);
            dataset.setValue("Vyriešené poruchy: " + df.format(resolvedPercentage) + "%", result2);

            // vytvorenie grafu
            JFreeChart chart = ChartFactory.createPieChart(
                    "Aktuálny stav porúch",
                    dataset,
                    true, // Include legend
                    true, // Include tooltips
                    false // Include URLs
            );

            PiePlot plot = (PiePlot) chart.getPlot();
            // nazov grafu
            TextTitle title = chart.getTitle();
            // nastavenie fontu
            title.setFont(new Font("Arial", Font.BOLD, 18)); // Set font size to 18
            // zmena farby
            plot.setSectionPaint("Aktívne poruchy: " + df.format(activePercentage) + "%", new Color(30,144,255));
            plot.setSectionPaint("Vyriešené poruchy: " + df.format(resolvedPercentage) + "%", new Color(250,128,114));
            // nastavenie farieb "labelov"
            plot.setLabelBackgroundPaint(new Color(255, 204, 153));
            // nastavenie farby pozadia
            chart.getPlot().setBackgroundPaint(new Color(220,220,220));
            // zobrazenie grafu v ChartPaneli
            ChartPanel chartPanel = new ChartPanel(chart);
            // Set preferred size
            chartPanel.setPreferredSize(new Dimension(435, 225));
            add(chartPanel);

            //TODO

            BufferedImage chartImage = new BufferedImage(435, 225, BufferedImage.TYPE_INT_RGB);
            Graphics2D chartGraphics = chartImage.createGraphics();
            chartPanel.paint(chartGraphics);
            chartGraphics.dispose();

            // Save the image to the desktop directory
            String desktopPath = "C:\\Users\\Mario\\Desktop\\reporty01";
            File chartFile = new File(desktopPath + "pie_chart.png"); // Append the file name to the desktop path

            try {
                ImageIO.write(chartImage, "PNG", chartFile);
                System.out.println("Pie chart image saved successfully to the desktop.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error saving pie chart image: " + e.getMessage());
            }


        }

    }

