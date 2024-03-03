package GUI.Menu.Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class GraphPieChart extends JPanel {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        public GraphPieChart() {
            // Create a dataset
            DefaultPieDataset dataset = new DefaultPieDataset();
            int result1 = 0;
            int result2 = 0;
            try {
                transaction.begin();
                // Retrieve data from the database using JPQL with a join
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
            // Inside your Graph class
            DecimalFormat df = new DecimalFormat("#.##");
            double activePercentage = (100.0 * result1) / (result1 + result2);
            double resolvedPercentage = (100.0 * result2) / (result1 + result2);
            dataset.setValue("Aktívne poruchy: " + df.format(activePercentage) + "%", result1);
            dataset.setValue("Vyriešené poruchy: " + df.format(resolvedPercentage) + "%", result2);

            // Create a chart
            JFreeChart chart = ChartFactory.createPieChart(
                    "Aktuálny stav porúch",
                    dataset,
                    true, // Include legend
                    true, // Include tooltips
                    false // Include URLs
            );
            // Customize label colors
            PiePlot plot = (PiePlot) chart.getPlot();
            // Customize the renderer (for changing column colors)
            // Get the title of the chart
            TextTitle title = chart.getTitle();
            // Set a custom font with a specific size for the title
            title.setFont(new Font("Arial", Font.BOLD, 18)); // Set font size to 18
            // Change color ofsection
            plot.setSectionPaint("Aktívne poruchy: " + df.format(activePercentage) + "%", new Color(30,144,255));
            plot.setSectionPaint("Vyriešené poruchy: " + df.format(resolvedPercentage) + "%", new Color(250,128,114));
            // Set label color
            plot.setLabelBackgroundPaint(new Color(255, 204, 153));
            // Set the background color
            chart.getPlot().setBackgroundPaint(new Color(220,220,220));
            // Display the chart in a ChartPanel
            ChartPanel chartPanel = new ChartPanel(chart);
            // Set preferred size
            chartPanel.setPreferredSize(new Dimension(435, 225));
            add(chartPanel);
        }
    }

