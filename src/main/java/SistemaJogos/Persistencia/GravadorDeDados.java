package SistemaJogos.Persistencia;
//
import SistemaJogos.Sistema.Jogo;
import SistemaJogos.Sistema.Usuario;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    public static final String ARQUIVOS_USUARIOS = "usuarios.dat";
    public static final String ARQUIVOS_JOGOS = "jogos.dat";

    public HashMap<String, Usuario> recuperarUsuarios() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(ARQUIVOS_USUARIOS));
            return (HashMap<String, Usuario>) in.readObject();
        } catch (Exception e) {
            System.out.println("Não foi possível recuperar os usuários!");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVOS_USUARIOS);
        } finally {
            if (in!=null) {
                in.close();
            }
        }
    }

    public HashMap<Integer, Jogo> recuperarJogos() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(ARQUIVOS_JOGOS));
            return (HashMap<Integer, Jogo>) in.readObject();
        } catch (Exception e) {
            System.out.println("Não foi possível recuperar os jogos!");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVOS_JOGOS);
        } finally {
            if(in!=null) {
                in.close();
            }
        }
    }

    public void salvarUsuarios(Map<String, Usuario> usuarios) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_USUARIOS));
            out.writeObject(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Erro ao salvar os usuários no arquivo "+ARQUIVOS_USUARIOS);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void salvarJogos(Map<Integer, Jogo> jogos) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_JOGOS));
            out.writeObject(jogos);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Erro ao salvar os jogos no arquivo "+ARQUIVOS_JOGOS);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
