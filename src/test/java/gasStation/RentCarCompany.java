package gasStation;

class RentCarCompany {

    private Sonata sonata;
    private Avante avante;
    private K5 k5;

    public static RentCarCompany checkFuel(int distance) {
        RentCarCompany company = new RentCarCompany();
        company.sonata = new Sonata(distance);
        company.avante = new Avante(distance);
        company.k5 = new K5(distance);
        return company;
    }

     public String writeReport() {
        return sonata.report() + "\n" + avante.report() + "\n" + k5.report();
     }
}
