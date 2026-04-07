/* Escrever as classes PlayList e Música, usadas para registrar as playlists de um aplicativo de músicas.
• Cada playlist deve ter um nome e uma descrição além de uma lista de músicas;
• O construtor da classe PlayList recebe o nome e a descrição inicial da playlist e possui métodos recuperar e
alterar esses valores (get/set);
• O método Inserir insere uma música em uma playlist;
• O método Listar retorna a lista de músicas de uma playlist;
• O método ToString retorna o número de músicas na playtlist;
• Cada música tem informações sobre título, artista e álbum da música;
• O construtor da classe Música recebe os dados iniciais de uma música e possui métodos alterar esses valores
(get/set);
• O método ToString retorna os dados de uma música;
• Insira outros atributos e métodos nas classes, caso necessário. */

package Lista04;
import java.util.ArrayList;

class Playlist {
    private String nome;
    private String descricao;
    private ArrayList<Musica> listaMusica;

    public Playlist(String nome, String descricao) {
        this.setNome(nome);
        this.setDescricao(descricao);
        listaMusica = new ArrayList<>(); // inicialização da lista
    }

    public void setNome(String nome) {this.nome = nome;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}

    public void inserir(Musica musica) {
        listaMusica.add(musica);
    }

    public ArrayList<Musica> listar() {
        return listaMusica;
    }

    public void listaFormatada() {
        System.out.println("--- Músicas da Playlist ---\n");
        for (Musica musica : listaMusica) {
            System.out.println(musica);
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Número de músicas na playlist: " + listaMusica.size();
    }
}

class Musica {
    private String titulo;
    private String artista;
    private String album;

    public Musica(String titulo, String artista, String album) {
        this.setTitulo(titulo);
        this.setArtista(artista);
        this.setAlbum(album);
    }

    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setArtista(String artista) {this.artista = artista;}
    public void setAlbum(String album) {this.album = album;}

    public String getTitulo() {return titulo;}
    public String getArtista() {return artista;}
    public String getAlbum() {return album;}

    @Override
    public String toString() {
        return "Título: " + titulo + "\nArtista: " + artista + "\nAlbum: " + album;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Playlist playlist01 = new Playlist("Vibe Songs", "😎");
        Musica m1 = new Musica("Porradão de Muay Thai", "PECAOS", "Porradão de Muay Thai");
        Musica m2 = new Musica("Anel de Giges", "Fabio Brazza", "Epopéia da Poeira Cósmica");
        Musica m3 = new Musica("Papoulas", "Yago Oproprio", "OPROPRIO");

        playlist01.inserir(m1);
        playlist01.inserir(m2);
        playlist01.inserir(m3);
        System.out.println("Playlist: " + playlist01.getNome() + "\nDescrição: " + playlist01.getDescricao() + "\n");
        playlist01.listaFormatada();
        }
    }