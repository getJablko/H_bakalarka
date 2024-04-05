package GUI.HlMenu.Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
public class GraphPieChart extends JPanel {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public GraphPieChart(String datumOd, String DatumDo) throws IOException {
        // novy dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        int result1 = 0;
        int result2 = 0;
        try {
            transaction.begin();
            // ziskanie dat z databazy - JPQL
            Query query = entityManager.createNativeQuery(
                    "SELECT COUNT(p.id_poruchy) " +
                            "FROM B_porucha p " +
                            "WHERE TO_DATE(SUBSTR(p.porucha_od, 1, 4000), 'YYYY-MM-DD') >= TO_DATE(:datumOd, 'YYYY-MM-DD')");
            query.setParameter("datumOd", datumOd);
            result1 = ((Number) query.getSingleResult()).intValue();

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
        plot.setSectionPaint("Aktívne poruchy: " + df.format(activePercentage) + "%", new Color(30, 144, 255));
        plot.setSectionPaint("Vyriešené poruchy: " + df.format(resolvedPercentage) + "%", new Color(250, 128, 114));
        // nastavenie farieb "labelov"
        plot.setLabelBackgroundPaint(new Color(255, 204, 153));
        // nastavenie farby pozadia
        chart.getPlot().setBackgroundPaint(new Color(220, 220, 220));
        // zobrazenie grafu v ChartPaneli
        ChartPanel chartPanel = new ChartPanel(chart);
        // Set preferred size
        chartPanel.setPreferredSize(new Dimension(435, 225));
        chartPanel.setSize(435,225);
        add(chartPanel);
        chartPanel.setVisible(true);

        // export grafu
        //String desktopPath = "C:\\Users\\Mario\\Desktop\\reporty01";
        ChartUtilities.saveChartAsPNG(new File("reports\\pie_chart.png"), chart, chartPanel.getWidth(), chartPanel.getHeight());
    }

}

