package com.example.firebase14t;

public class Productos1 {

        private String Codigo;
        private String Nombre;

        private double Stock,  PrecioV;
        private String Descripcion;

        public Productos1() {
            //Es obligatorio incluir constructor por defecto
        }

        public Productos1( String Descripcion,String Codigo, String Nombre, double PrecioV, double Stock)
        {
           this.Descripcion=Descripcion;
            this.Codigo = Codigo;
            this.Nombre = Nombre;
            this.PrecioV=PrecioV;
           this.Stock=Stock;
        }

        public String getDescripcion() {
            return Descripcion;
        }

        public void setDescripcion(String Descripcion) {
            this.Descripcion= Descripcion;
        }

        public String getCodigo() {
            return Codigo;
        }


     public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

        public String  getNombre() {return Nombre; }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public double getPrecioV() {
            return PrecioV;
        }

        public void setPrecioV(double PrecioV) {
            this.PrecioV = PrecioV;
        }
    public double getStock() {
        return Stock;
    }

    public void setStock(double Stock) {
        this.Stock= Stock;
    }

        @Override
        public String toString() {
            return "Productos1{" +
                    "Descripcion='" + Descripcion+ '\'' +
                    ", Codigo='" + Codigo + '\'' +
                    ", Nombre=" + Nombre +'\'' +
                    ", PrecioV=" + PrecioV+'\'' +
                    ", Stock=" + Stock+
                    '}';
        }

    }

