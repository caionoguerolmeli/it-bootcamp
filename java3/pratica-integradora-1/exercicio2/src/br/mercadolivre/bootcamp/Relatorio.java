package br.mercadolivre.bootcamp;

public class Relatorio extends Document{
    String text;
    int paginas;
    String autor;
    String revisor;

    public Relatorio(String text, int paginas, String autor, String revisor) {
        this.text = text;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "text='" + text + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
