class PermisoNegocio extends Permiso {
    private int tamanoLocal;
    private int cantidadEmpleados;
    private static final double TARIFA_TAMANO_LOCAL = 150000;
    private static final double TARIFA_EMPLEADO = 20000;

    public PermisoNegocio(String tipo, String fechaEmision, String fechaVencimiento, double costoBase, int tamanoLocal, int cantidadEmpleados) {
        super(tipo, fechaEmision, fechaVencimiento, costoBase);
        this.tamanoLocal = tamanoLocal;
        this.cantidadEmpleados = cantidadEmpleados;
    }

    @Override
    public double calcularCosto() {
        return costoBase + (tamanoLocal * TARIFA_TAMANO_LOCAL) + (cantidadEmpleados * TARIFA_EMPLEADO);
    }
}
