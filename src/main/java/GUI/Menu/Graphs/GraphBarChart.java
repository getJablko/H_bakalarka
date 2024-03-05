package GUI.Menu.Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphBarChart extends JPanel {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public GraphBarChart() {
        // vytvorenie datasetu
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) createDataset();

        // vytvorenie grafu
        JFreeChart chart = ChartFactory.createBarChart(
                "Poruchy typov strojov",
                "Typ stroja",
                "Počet porúch",
                dataset
        );
        // nastavenie nazvu
        TextTitle title = chart.getTitle();

        //nastavenie textu/fontov
        title.setFont(new Font("Arial", Font.BOLD, 18)); // Set font size to 18
        // farba pozadia
        chart.setBackgroundPaint(new Color(255, 255, 254));

        // kod na upravu grafu
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(220,220,220));

        // uprava nazvov osi
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12)); // Set font size to 12

        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10)); // Set font size to 12

        // uprava renderu grafu - farby
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        // Czmena farieb
        renderer.setSeriesPaint(0, new Color(135,206,250));
        renderer.setSeriesPaint(1, new Color(233,150,122));
        renderer.setSeriesPaint(2, new Color(64,224,208));
        renderer.setSeriesPaint(3, new Color(221,160,221));
        renderer.setSeriesPaint(4, new Color(255,182,193));
        renderer.setSeriesPaint(5, new Color(188,143,143));

        for (int i = 0; i <= 5; i++) {
            renderer.setMaximumBarWidth(0.1); // sirka
            renderer.setDrawBarOutline(true); // outline
            renderer.setSeriesOutlineStroke(i, new BasicStroke(0.75f)); // nastavenie sirky
            renderer.setSeriesOutlinePaint(i, Color.BLACK); // farba
        }


        // zobrazenie grafu v ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(450, 225)); // preferred size
        add(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            transaction.begin();
            // ziskane data z databazy - JPQL
            TypedQuery<Object[]> query1 = entityManager.createQuery(
                    "SELECT t.typStroja , COUNT(p.idStroja) " +
                            "FROM BStroj t " +
                            "JOIN BPorucha p ON t.idStroja = p.idStroja " +
                            "GROUP BY t.typStroja", Object[].class);

            List<Object[]> results = query1.getResultList();

            for (Object[] result : results) {
                Object[] row = {
                        result[0],  // typStroja
                        result[1],  // count poruch
                };
                dataset.addValue((Number) result[1], (Comparable) result[0], "");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while loading data: " + e.getMessage() + " Please try again!");
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
        return dataset;
    }
}
