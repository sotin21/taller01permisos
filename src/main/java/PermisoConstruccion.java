class PermisoConstruccion extends Permiso {
    private int metrosCuadrados;
    private static final double TARIFA_METRO_CUADRADO = 15000;

    public PermisoConstruccion(String tipo, String fechaEmision, String fechaVencimiento, double costoBase, int metrosCuadrados) {
        super(tipo, fechaEmision, fechaVencimiento, costoBase);
        this.metrosCuadrados = metrosCuadrados;
    }

    @Override
    public double calcularCosto() {
        return costoBase + (metrosCuadrados * TARIFA_METRO_CUADRADO);
    }
}
