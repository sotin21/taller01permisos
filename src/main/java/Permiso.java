abstract class Permiso {
    protected String tipo;
    protected String fechaEmision;
    protected String fechaVencimiento;
    protected double costoBase;

    public Permiso(String tipo, String fechaEmision, String fechaVencimiento, double costoBase) {
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.costoBase = costoBase;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public abstract double calcularCosto();
}