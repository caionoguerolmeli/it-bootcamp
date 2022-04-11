package temperaturas;

public class TemperaturaGlobais {

    public static void main(String args[]) {

        System.out.println(getTemperatures());

    }

    public static String getTemperatures() {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;

        String cityMaxTemp = "";
        String cityMinTemp = "";

        for (int j = 0; j < temperaturas.length; j++) {
            if (temperaturas[j][0] < minTemp) {
                minTemp = temperaturas[j][0];
                cityMinTemp = cities[j];
            }
            if (temperaturas[j][1] > maxTemp) {
                maxTemp = temperaturas[j][1];
                cityMaxTemp = cities[j];
            }

        }


        return "A menor temperatura é de " + cityMinTemp + " com " + minTemp + "C e a maior temperatura é de " + cityMaxTemp + " com " + maxTemp + "C.";
    }
}
