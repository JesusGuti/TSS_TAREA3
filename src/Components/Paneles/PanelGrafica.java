package Components.Paneles;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Models.Calculo;

public class PanelGrafica extends JPanel{
    private Calculo calculo;
    private int[] meses;
    private int[] inventarioInicial;

    public PanelGrafica(Calculo calculo) {
        this.calculo = calculo;    
        this.meses = calculo.obtenerMeses();
        this.inventarioInicial = calculo.obtenerInventarioInicial();
        iniciarPanel();
        iniciarComponentes();
    }

    public void iniciarPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        this.setVisible(true);
    }

    public void iniciarComponentes() {
        definirGrafica();
    }

    private void definirGrafica() {
        XYSeries series = new XYSeries("Grafica Inventario VS Tiempo");
        int iteraciones = meses.length;
        for(int i=0; i < iteraciones ;i++) {
            series.add(meses[i],inventarioInicial[i]);   
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Inventario VS Tiempo",
            "Inventario",
            "Tiempo",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        this.add(chartPanel);
    }
}
