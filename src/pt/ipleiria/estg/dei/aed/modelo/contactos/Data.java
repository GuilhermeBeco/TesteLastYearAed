package pt.ipleiria.estg.dei.aed.modelo.contactos;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static Data parseData(String data) {
        String[] partes = data.split("/");
        return new Data(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(dia).append("/").append(mes).append("/").append(ano).toString();
    }

    public int comparar(Data data) {
        int comparacao = Integer.compare(ano, data.ano);
        if (comparacao != 0) {
            return comparacao;
        }

        comparacao = Integer.compare(mes, data.mes);
        if (comparacao != 0) {
            return comparacao;
        }

        return Integer.compare(dia, data.dia);
    }

}
