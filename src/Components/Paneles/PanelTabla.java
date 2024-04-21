package Components.Paneles;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Models.Calculo;
import Models.Costo;

public class PanelTabla extends JPanel{
    private Calculo calculo;
    private int[] meses;
    private double[] factorEstacional;
    private int[] inventarioInicial;
    private double[] numeroR1;
    private int[] demanda;
    private int[] demandaAjustada;
    private int[] inventarioFinal;
    private int[] faltante;
    private String[] orden;
    private double[] numeroR2;
    private String[] dias;
    private double[] inventarioPromedio;

    public PanelTabla(Calculo calculo) {
        this.calculo = calculo;    
        meses = calculo.obtenerMeses();
        factorEstacional = calculo.obtenerFactoresEstacionales();
        inventarioInicial = calculo.obtenerInventarioInicial();
        numeroR1 = calculo.obtenerR1();
        demanda = calculo.obtenerDemanda();
        demandaAjustada = calculo.obtenerDemandaAjustada();
        inventarioFinal = calculo.obtenerInventarioFinal();
        faltante = calculo.obtenerFaltante();
        orden = calculo.obtenerOrden();
        numeroR2 = calculo.obtenerR2();
        dias = calculo.obtenerDias();
        inventarioPromedio = calculo.obtenerInventarioPromedio();
        iniciarPanel();
        iniciarComponentes();
    }

    public void iniciarPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        this.setVisible(true);
    }

    public void iniciarComponentes() {
        definirTabla();      
        definirTablaCostos();  
    }

    private void definirTabla() {
        int iteraciones = meses.length;
        Object[][] datos = new Object[iteraciones][12]; 
        for (int i = 0; i < iteraciones; i++) {
            datos[i][0] = meses[i];
            datos[i][1] = factorEstacional[i];
            datos[i][2] = inventarioInicial[i];
            datos[i][3] = numeroR1[i];
            datos[i][4] = demanda[i];
            datos[i][5] = demandaAjustada[i];
            datos[i][6] = inventarioFinal[i];
            datos[i][7] = faltante[i];
            datos[i][8] = orden[i];
            datos[i][9] = numeroR2[i];
            datos[i][10] = dias[i];
            datos[i][11] = inventarioPromedio[i];
        }

        String[] nombresColumnas = {
            "Mes",
            "Factor Estacional",
            "Inventario Inicial",
            "R1",
            "Demanda",
            "Demanda Ajustada",
            "Inventario Final",
            "Faltante",
            "Orden",
            "R2",
            "Dias",
            "Inventario Promedio"
        };

        DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane);
    }

    private void definirTablaCostos() {
        Object[][] datos = new Object[1][4]; 
        Costo costos = new Costo(calculo);
        datos[0][0] = costos.calcularCostoOrden();
        datos[0][1] = costos.calcularCostoInventario();
        datos[0][2] = costos.calcularCostoFaltante();
        datos[0][3] = costos.calcularCostoTotal();

        String[] nombresColumnas = {
            "Costo Ordenar",
            "Costo Inventario",
            "Costo Faltante",
            "Costo Total"
        };

        DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane);
        System.out.println("Imprime tabla");
    }
}
